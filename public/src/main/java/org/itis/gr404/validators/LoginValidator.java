package org.itis.gr404.validators;

import org.itis.gr404.HashMake;
import org.itis.gr404.entities.User;
import org.itis.gr404.repositories.UserRepository;
import org.itis.gr404.validators.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;

/**
 * Created by Регина on 13.04.2016.
 */
@Component
public class LoginValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

    public LoginValidator() {}

    public LoginValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean supports(Class aClass) {
        return User.class.equals(aClass);
    }

    public enum ERROR_TYPES {
        OK,
        NO_LOGIN,
        NO_USER,
        NO_PASSWORD,
        NEGATIVE_PASSWORD;
    }

    public void validate(Object obj, Errors errors) {
        User user = (User) obj;
        ERROR_TYPES result = validate(user);
        if (!result.equals(ERROR_TYPES.OK)) {
            switch (result) {
                case NO_LOGIN:
                    errors.rejectValue("login", "field.required", "Введите Ваш логин!");
                    break;
                case NO_PASSWORD:
                    errors.rejectValue("password", "field.required", "Введите Ваш пароль!");
                    break;
                case NO_USER:
                    errors.rejectValue("login", "incorrect", "Нет такого пользователя!");
                    break;
                case NEGATIVE_PASSWORD:
                    errors.rejectValue("password", "incorrect", "Неверный пароль!");
                    break;
            }

        }
    }

    public ERROR_TYPES validate(User user) {
        if (!StringUtils.hasText(user.getLogin())) {
            return ERROR_TYPES.NO_LOGIN;
        }
        User user1 = null;
        List<User> users = userRepository.getAllUsers();
        for (User u: users) {
            if (user.getLogin().equals(u.getLogin())) {
                user1 = u;
            }
        }
        if (user1 == null) {
            return ERROR_TYPES.NO_USER;
        }

        if (!StringUtils.hasText(user.getPassword())) {
            return ERROR_TYPES.NO_PASSWORD;
        }

        HashMake hashMake =  new HashMake();
        String psw = hashMake.md5Apache(user.getPassword());
        if (!psw.equals(user1.getPassword())) {
            return ERROR_TYPES.NEGATIVE_PASSWORD;
        }

        return ERROR_TYPES.OK;
    }
}
