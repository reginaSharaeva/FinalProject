package org.itis.gr404.controllers;

import org.itis.gr404.entities.Order;
import org.itis.gr404.entities.User;
import org.itis.gr404.repositories.OrderRepository;
import org.itis.gr404.repositories.UserRepository;
import org.itis.gr404.validators.OrderValidator;
import org.itis.gr404.validators.form.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Регина on 13.04.2016.
 */
@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderValidator orderValidator;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    @ModelAttribute("userList")
    public List<User> referenceData() {
        return userRepository.getAllUsers();
    }

    @RequestMapping(value = "/newOrder", method = RequestMethod.GET)
    public Object initAdd() {
        OrderForm orderForm = new OrderForm();
        request.setAttribute("orderForm", orderForm);
        return "new_order";
    }

    @RequestMapping(value = "/newOrder", method = RequestMethod.POST)
    public String onSubmitAdd(@ModelAttribute("orderForm") OrderForm orderForm, BindingResult bindingResult) {
        orderValidator.validate(orderForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "new_order";
        }
        Order order = new Order();
        order.setGood(orderForm.getGood());
        order.setPrice(Integer.parseInt(orderForm.getPrice()));
        User user = userRepository.getUserByLogin(orderForm.getUserLogin());
        order.setUser(user);
        orderRepository.saveOrder(order);
        return "redirect:/usersList";

    }

    @RequestMapping(value = "/cancelOrder", method = RequestMethod.GET)
    public Object initForm() {
        return "redirect:/orderPage";
    }

    @RequestMapping(value = "/back", method = RequestMethod.GET)
    public Object initBack() {
        return "redirect:/usersList";
    }


}
