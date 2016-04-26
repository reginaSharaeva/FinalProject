package org.itis.gr404.validators;

import org.itis.gr404.entities.User;
import org.itis.gr404.repositories.UserRepository;
import org.itis.gr404.validators.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Регина on 24.04.2016.
 */
@Component
public class UserValidator implements Validator {
    @Autowired
    private UserRepository userRepository;

    public boolean supports(Class aClass) {
        return UserForm.class.equals(aClass);
    }

    public void validate(Object obj, Errors errors) {
        UserForm userForm = (UserForm) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "field.required", "Введите Ваше имя!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "field.required", "Введите Вашу фамилию!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "field.required", "Введите Ваш возраст!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "field.required", "Введите Ваш логин!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required", "Введите Ваш пароль!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "field.required", "Подтвердите пароль");
        if (! errors.hasFieldErrors("age")) {
            if (! userForm.getAge().matches("^[0-9]+$") || userForm.getAge().equals("0") ) {
                errors.rejectValue("age", "incorrect", "Неверный формат данных!");
            }
        }
        if (! errors.hasFieldErrors("login")) {
            User user = userRepository.getUserByLogin(userForm.getLogin());
            if (user != null) {
                errors.rejectValue("login", "incorrect", "Пользователь с таким логином уже есть!");
            }
        }
        if (! errors.hasFieldErrors("password") || ! errors.hasFieldErrors("confirmPassword")) {
            if (!userForm.getConfirmPassword().equals(userForm.getPassword())) {
                errors.rejectValue("confirmPassword", "incorrect", "Не совпадает с паролем!");
            }
        }

    }
}
