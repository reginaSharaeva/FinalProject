package org.itis.gr404.validators;

import org.itis.gr404.validators.form.OrderForm;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Регина on 13.04.2016.
 */
@Component
public class OrderValidator implements Validator {

    public boolean supports(Class aClass) {
        return OrderForm.class.equals(aClass);
    }

    public enum ERROR_TYPES {
        OK,
        NO_PRICE,
        NEGATIVE_PRICE,
        NULL_PRICE,
        NO_GOOD,
        NEGATIVE_GOOD;
    }

    public void validate(Object obj, Errors errors) {
        OrderForm orderForm = (OrderForm) obj;
        ERROR_TYPES result = validate(orderForm);
        if (!result.equals(ERROR_TYPES.OK)) {
            switch (result) {
                case NO_GOOD:
                    errors.rejectValue("good", "field.required", "Введите название товара");
                    break;
                case NEGATIVE_GOOD:
                    errors.rejectValue("good", "incorrect", "Неверный формат названия!");
                    break;
                case NO_PRICE:
                    errors.rejectValue("price", "field.required", "Введите цену");
                    break;
                case NULL_PRICE:
                    errors.rejectValue("price", "nullprice", "Цена должна быть больше нуля!");
                case NEGATIVE_PRICE:
                    errors.rejectValue("price", "incorrect", "Неверный формат цены!");
                    break;

            }

        }
    }

    public ERROR_TYPES validate(OrderForm form) {
        if (!StringUtils.hasText(form.getGood())) {
            return ERROR_TYPES.NO_GOOD;
        }
        if (!form.getGood().matches("^[a-zA-ZА-Яа-я\\s]+$")) {
            return ERROR_TYPES.NEGATIVE_GOOD;
        }
        if (!StringUtils.hasText(form.getPrice())) {
            return ERROR_TYPES.NO_PRICE;
        }
        if (form.getPrice().equals("0")) {
            return ERROR_TYPES.NULL_PRICE;
        }
        if (!form.getPrice().matches("^[0-9]+$")) {
            return ERROR_TYPES.NEGATIVE_PRICE;
        }
        return ERROR_TYPES.OK;
    }
}
