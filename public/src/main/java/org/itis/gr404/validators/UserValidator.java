package org.itis.gr404.validators;

import org.itis.gr404.validators.form.UserForm;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

/**
 * Created by Регина on 24.04.2016.
 */
@Component
public class UserValidator {

    public boolean supports(Class aClass) {
        return UserForm.class.equals(aClass);
    }

    public enum ERROR_TYPES {
        OK,
        NO_FIRSTNAME,
        NO_LASTNAME,
        NO_AGE,
        NEGATIVE_AGE,
        NO_LOGIN,
        NEGATIVE_LOGIN,
        NEGATIVE_CONFIRM,
        NO_PASSWORD,
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
                case NEGATIVE_AGE:
                    errors.rejectValue("age", "incorrect", "Неверный формат возраста!");
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
        if (!form.getAge().matches("^[0-9]+$")) {
            return ERROR_TYPES.NEGATIVE_AGE;
        }
        if (!form.getConfirmPassword().equals(form.getPassword())) {
            return ERROR_TYPES.NEGATIVE_CONFIRM;
        }
        return ERROR_TYPES.OK;
    }
}
