package org.itis.gr404.validators;

import org.itis.gr404.HashMake;
import org.itis.gr404.entities.User;
import org.itis.gr404.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Регина on 13.04.2016.
 */
@Component
public class LoginValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

    public boolean supports(Class aClass) {
        return User.class.equals(aClass);
    }

    public void validate(Object obj, Errors errors) {
        User user = (User) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "field.required", "Введите Ваш логин!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required", "Введите Ваш пароль!");
        if (! errors.hasFieldErrors("login") || ! errors.hasFieldErrors("password")) {
            User u = userRepository.getUserByLogin(user.getLogin());
            if (u == null) {
                errors.rejectValue("login", "incorrect", "Нет такого пользователя!");
            } else {
                HashMake hashMake =  new HashMake();
                String psw = hashMake.md5Apache(user.getPassword());
                System.out.println("pswd=" + user.getPassword());
                System.out.println("hash=" + psw);
                if (!psw.equals(u.getPassword())) {
                    errors.rejectValue("password", "incorrect", "Неверный пароль!");
                }
            }
        }
    }
}
