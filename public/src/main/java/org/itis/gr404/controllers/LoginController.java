package org.itis.gr404.controllers;

import org.itis.gr404.entities.User;
import org.itis.gr404.repositories.UserRepository;
import org.itis.gr404.validators.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Regina on 11.04.2016.
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginValidator loginValidator;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(method = RequestMethod.GET)
    public Object initForm(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "loginPage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute("user") User user, BindingResult bindingResult) {
        loginValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "loginPage";
        }
        return "redirect:/final_project";

    }
}
