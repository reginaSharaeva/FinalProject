package org.itis.gr404.validators;

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
 * Created by Регина on 24.04.2016.
 */
@Component
public class UserValidator implements Validator {
    @Autowired
    private UserRepository userRepository;

    public boolean supports(Class aClass) {
        return UserForm.class.equals(aClass);
    }

    public UserValidator() {}

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public enum ERROR_TYPES {
        OK,
        NO_FIRSTNAME,
        NO_LASTNAME,
        NO_AGE,
        NO_LOGIN,
        NO_PASSWORD,
        NO_CONFIRM,
        NEGATIVE_AGE,
        NEGATIVE_LOGIN,
        NEGATIVE_CONFIRM;
    }

    public void validate(Object obj, Errors errors) {
        UserForm userForm = (UserForm) obj;
        ERROR_TYPES result = validate(userForm);
        if (!result.equals(ERROR_TYPES.OK)) {
            switch (result) {
                case NO_FIRSTNAME:
                    errors.rejectValue("firstName", "field.required", "Введите Ваше имя!");
                    break;
                case NO_LASTNAME:
                    errors.rejectValue("lastName", "field.required", "Введите Вашу фамилию!");
                    break;
                case NO_AGE:
                    errors.rejectValue("age", "field.required", "Введите Ваш возраст!");
                    break;
                case NO_LOGIN:
                    errors.rejectValue("login", "field.required", "Введите Ваш логин!");
                    break;
                case NO_PASSWORD:
                    errors.rejectValue("password", "field.required", "Введите Ваш пароль!");
                    break;
                case NO_CONFIRM:
                    errors.rejectValue("confirmPassword", "field.required", "Подтвердите пароль");
                    break;
                case NEGATIVE_AGE:
                    errors.rejectValue("age", "incorrect", "Неверный формат данных!");
                    break;
                case NEGATIVE_LOGIN:
                    errors.rejectValue("login", "incorrect", "Пользователь с таким логином уже есть!");
                    break;
                case NEGATIVE_CONFIRM:
                    errors.rejectValue("confirmPassword", "incorrect", "Не совпадает с паролем!");
                    break;
            }

        }
    }

    public ERROR_TYPES validate(UserForm form) {
        if (!StringUtils.hasText(form.getFirstName())) {
            return ERROR_TYPES.NO_FIRSTNAME;
        }
        if (!StringUtils.hasText(form.getLastName())) {
            return ERROR_TYPES.NO_LASTNAME;
        }
        if (!StringUtils.hasText(form.getAge()) || form.getAge().equals("0")) {
            return ERROR_TYPES.NO_AGE;
        }
        if (!StringUtils.hasText(form.getLogin())) {
            return ERROR_TYPES.NO_LOGIN;
        }
        if (!StringUtils.hasText(form.getPassword())) {
            return ERROR_TYPES.NO_PASSWORD;
        }
        if (!StringUtils.hasText(form.getConfirmPassword())) {
            return ERROR_TYPES.NO_CONFIRM;
        }
        if (!form.getAge().matches("^[0-9]+$")) {
            return ERROR_TYPES.NEGATIVE_AGE;
        }
        if (!form.getConfirmPassword().equals(form.getPassword())) {
            return ERROR_TYPES.NEGATIVE_CONFIRM;
        }
        List<User> users = (List<User>) userRepository.getAllUsers();
        for (User user: users) {
            if (form.getLogin().equals(user.getLogin())) {
                return ERROR_TYPES.NEGATIVE_LOGIN;
            }
        }
        return ERROR_TYPES.OK;
    }
}
