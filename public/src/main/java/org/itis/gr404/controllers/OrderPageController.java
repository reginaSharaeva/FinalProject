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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Регина on 13.04.2016.
 */
@Controller
@RequestMapping(value = "orderPage" )
public class OrderPageController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderValidator orderValidator;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET)
    public Object initForm() {
        return "order_page";
    }

    @ModelAttribute("orderList")
    protected List<Order> referenceOrders() {
        return orderRepository.getAllOrders();
    }

    @RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.GET)
    public String onSubmitDelete(@PathVariable("id") int id) {
        Order order = orderRepository.getOrderById(id);
        orderRepository.deleteOrder(order);
        return "redirect:/orderPage";
    }

    @ModelAttribute("userList")
    public List<User> referenceUsers() {
        return userRepository.getAllUsers();
    }

    @RequestMapping(value="/updateOrder/{orderId}", method = RequestMethod.GET)
    public Object initUpdate(@PathVariable("orderId") int orderId) {
        Order order = orderRepository.getOrderById(orderId);
        request.setAttribute("orderForm", new OrderForm(order.getGood(), order.getPrice() + "", order.getUser().getLogin()));
        return "update_order";
    }

    @RequestMapping(value="/updateOrder/{orderId}", method = RequestMethod.POST)
    public Object onSubmitUpdate(@PathVariable("orderId") int orderId, @ModelAttribute("orderForm") OrderForm orderForm, BindingResult bindingResult) {
        orderValidator.validate(orderForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "update_order";
        }
        Order order = orderRepository.getOrderById(orderId);
        order.setGood(orderForm.getGood());
        order.setPrice(Integer.parseInt(orderForm.getPrice()));
        User user = userRepository.getUserByLogin(orderForm.getUserLogin());
        order.setUser(user);
        orderRepository.updateOrder(order);
        return "redirect:/orderPage";
    }
}
