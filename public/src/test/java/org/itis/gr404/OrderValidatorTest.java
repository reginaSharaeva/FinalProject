package org.itis.gr404;

import org.itis.gr404.validators.OrderValidator;
import org.itis.gr404.validators.form.OrderForm;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Регина on 13.05.2016.
 */
public class OrderValidatorTest {

    @Test
    public void testNoGood() {
        OrderValidator validator = new OrderValidator();
        OrderForm form = new OrderForm("", "200", "ivan23");
        OrderValidator.ERROR_TYPES result = validator.validate(form);
        Assert.assertEquals(OrderValidator.ERROR_TYPES.NO_GOOD, result);
    }

    @Test
    public void testNoPrice() {
        OrderValidator validator = new OrderValidator();
        OrderForm form = new OrderForm("doll", "", "ivan23");
        OrderValidator.ERROR_TYPES result = validator.validate(form);
        Assert.assertEquals(OrderValidator.ERROR_TYPES.NO_PRICE, result);
    }

    @Test
    public void testNullPrice() {
        OrderValidator validator = new OrderValidator();
        OrderForm form = new OrderForm("doll", "0", "ivan23");
        OrderValidator.ERROR_TYPES result = validator.validate(form);
        Assert.assertEquals(OrderValidator.ERROR_TYPES.NO_PRICE, result);
    }

    @Test
    public void testNegativeGood() {
        OrderValidator validator = new OrderValidator();
        OrderForm form = new OrderForm("d34", "200", "ivan23");
        OrderValidator.ERROR_TYPES result = validator.validate(form);
        Assert.assertEquals(OrderValidator.ERROR_TYPES.NEGATIVE_GOOD, result);
    }

    @Test
    public void testNegativePrice() {
        OrderValidator validator = new OrderValidator();
        OrderForm form = new OrderForm("doll", "o2", "ivan23");
        OrderValidator.ERROR_TYPES result = validator.validate(form);
        Assert.assertEquals(OrderValidator.ERROR_TYPES.NEGATIVE_PRICE, result);
    }

    @Test
    public void testNullLessPrice() {
        OrderValidator validator = new OrderValidator();
        OrderForm form = new OrderForm("doll", "-3", "ivan23");
        OrderValidator.ERROR_TYPES result = validator.validate(form);
        Assert.assertEquals(OrderValidator.ERROR_TYPES.NEGATIVE_PRICE, result);
    }
}
