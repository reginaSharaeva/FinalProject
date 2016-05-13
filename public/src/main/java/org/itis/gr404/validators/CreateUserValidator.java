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
public class CreateUserValidator extends UserValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

    public CreateUserValidator() {
    }

    public CreateUserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validate(Object obj, Errors errors) {
        super.validate(obj, errors);
        UserForm userForm = (UserForm) obj;
        if (!errors.hasErrors()) {
            ERROR_TYPES result = validateForCreate(userForm);
            if (!result.equals(ERROR_TYPES.OK)) {
                switch (result) {
                    case NO_LOGIN:
                        errors.rejectValue("login", "field.required", "Введите Ваш логин!");
                        break;
                    case NEGATIVE_LOGIN:
                        errors.rejectValue("login", "incorrect", "Пользователь с таким логином уже есть!");
                        break;
                    case NO_PASSWORD:
                        errors.rejectValue("password", "field.required", "Введите Ваш пароль!");
                        break;
                }
            }
        }
    }

    public ERROR_TYPES validateForCreate(UserForm form) {
        if (!StringUtils.hasText(form.getLogin())) {
            return ERROR_TYPES.NO_LOGIN;
        }
        List<User> users = (List<User>) userRepository.getAllUsers();
        for (User user: users) {
            if (form.getLogin().equals(user.getLogin())) {
                return ERROR_TYPES.NEGATIVE_LOGIN;
            }
        }
        if (!StringUtils.hasText(form.getPassword())) {
            return ERROR_TYPES.NO_PASSWORD;
        }
        return ERROR_TYPES.OK;
    }
}
