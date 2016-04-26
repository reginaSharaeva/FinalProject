package org.itis.gr404.controllers;

import org.itis.gr404.HashMake;
import org.itis.gr404.entities.User;
import org.itis.gr404.repositories.UserRepository;
import org.itis.gr404.validators.UpdateUserValidator;
import org.itis.gr404.validators.form.UserForm;
import org.itis.gr404.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Регина on 13.04.2016.
 */
@Controller
public class UserController {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UpdateUserValidator updateUserValidator;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public Object initAdd(ModelMap model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "new_user";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String onSubmitAdd(@ModelAttribute("userForm") UserForm userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "new_user";
        }
        User user = new User();
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setAge(Integer.parseInt(userForm.getAge()));
        user.setLogin(userForm.getLogin());
        user.setPassword(userForm.getPassword());
        userRepository.saveUser(user);
        return "redirect:/final_project";

    }

    @RequestMapping(value="/updateUser/{id}", method = RequestMethod.GET)
    public Object initUpdate(@PathVariable("id") int id, ModelMap model) {
        User user = userRepository.getUserById(id);
        UserForm userForm = new UserForm();
        userForm.setFirstName(user.getFirstName());
        userForm.setLastName(user.getLastName());
        userForm.setAge(user.getAge() + "");
        userForm.setLogin(user.getLogin());
        userForm.setPassword(user.getPassword());
        userForm.setConfirmPassword(user.getPassword());
        model.addAttribute("userForm", userForm);
        return "update_user";
    }

    @RequestMapping(value="/updateUser/{id}", method = RequestMethod.POST)
    public Object onSubmitUpdate(@PathVariable("id") int id, @ModelAttribute("user") UserForm userForm, BindingResult bindingResult) {
        updateUserValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "update_user";
        }
        User user = userRepository.getUserById(id);
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        user.setAge(Integer.parseInt(userForm.getAge()));
        if (!userForm.getPassword().equals("")) {
            HashMake hashMake = new HashMake();
            user.setPassword(hashMake.md5Apache(userForm.getPassword()));
        }
        userRepository.updateUser(user);
        return "redirect:/final_project";
    }

    @RequestMapping(value = "/cancelUser", method = RequestMethod.GET)
    public Object initForm() {
        return "redirect:/final_project";
    }
}
