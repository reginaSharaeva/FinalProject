package org.itis.gr404.controllers;

import org.itis.gr404.entities.User;
import org.itis.gr404.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Regina on 13.04.2016.
 */
@Controller
@RequestMapping(value = "/final_project")
public class MainPageController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Object initForm() {
        return "main_page";
    }

    @ModelAttribute("userList")
    protected List<User> referenceData() {
        return userRepository.getAllUsers();
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String onSubmitDelete(@PathVariable("id") int id) {
        User user = userRepository.getUserById(id);
        userRepository.deleteUser(user);
        return "redirect:/final_project";
    }
}
