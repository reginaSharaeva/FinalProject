package org.itis.gr404.validators;

import org.itis.gr404.validators.form.OrderForm;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Регина on 13.04.2016.
 */
@Component
public class OrderValidator implements Validator {

    public boolean supports(Class aClass) {
        return OrderForm.class.equals(aClass);
    }

//    private enum ERROR_TYPES {
//        OK,
//        NO_PRICE,
//        NEGATIVE_PRICE;
//    }

    public void validate(Object obj, Errors errors) {
        OrderForm orderForm = (OrderForm) obj;
//        ERROR_TYPES error = validate(orderForm);
//        if (!error.equals(ERROR_TYPES.OK)) {
//            switch (error) {
//                case NO_PRICE:
//                    errors.rejectValue( "good", "field.required", "Введите название товара");
//                    break;
//                case NEGATIVE_PRICE:
//                    break;
//            }
//
//        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "good", "field.required", "Введите название товара");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "field.required", "Введите цену");

        if ( ! errors.hasFieldErrors("price")) {
            if (!orderForm.getPrice().matches("^[0-9]+$") || orderForm.getPrice().equals("0") ) {
                errors.rejectValue("price", "incorrect", "Неверный формат!");
            }
        }
        if ( ! errors.hasFieldErrors("good")) {
            if (!orderForm.getGood().matches("^[a-zA-ZА-Яа-я\\s]+$")) {
                errors.rejectValue("good", "incorrect", "Неверный формат!");
            }
        }
    }

//    private ERROR_TYPES validate(OrderForm form) {
//        //
//        if (!StringUtils.hasText(form.getPrice())) {
//            return ERROR_TYPES.NO_PRICE;
//        }
//    }
}
