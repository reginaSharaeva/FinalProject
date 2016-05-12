package org.itis.gr404;

import org.itis.gr404.validators.UpdateUserValidator;
import org.itis.gr404.validators.form.UserForm;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Регина on 12.05.2016.
 */
public class UpdateUserValidatorTest {

    @Test
    public void testNoFirstName() {
        UpdateUserValidator userValidator = new UpdateUserValidator();
        UserForm userForm = new UserForm("", "Ivanov", "20", "ivan23", "12345", "12345");
        UpdateUserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UpdateUserValidator.ERROR_TYPES.NO_FIRSTNAME, result);
    }

    @Test
    public void testNoLastName() {
        UpdateUserValidator userValidator = new UpdateUserValidator();
        UserForm userForm = new UserForm("Ivan", "", "20", "ivan23", "12345", "12345");
        UpdateUserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UpdateUserValidator.ERROR_TYPES.NO_LASTNAME, result);
    }

    @Test
    public void testNoAge() {
        UpdateUserValidator userValidator = new UpdateUserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "", "ivan23", "12345", "12345");
        UpdateUserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UpdateUserValidator.ERROR_TYPES.NO_AGE, result);
    }

    @Test
    public void testNullAge() {
        UpdateUserValidator userValidator = new UpdateUserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "0", "ivan23", "12345", "12345");
        UpdateUserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UpdateUserValidator.ERROR_TYPES.NO_AGE, result);
    }

    @Test
    public void testNegativeAge() {
        UpdateUserValidator userValidator = new UpdateUserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "tr", "ivan23", "12345", "12345");
        UpdateUserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UpdateUserValidator.ERROR_TYPES.NEGATIVE_AGE, result);
    }

    @Test
    public void testAgeLessNull() {
        UpdateUserValidator userValidator = new UpdateUserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "-2", "ivan23", "12345", "12345");
        UpdateUserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UpdateUserValidator.ERROR_TYPES.NEGATIVE_AGE, result);
    }

    @Test
    public void testNegativeConfirm() {
        UpdateUserValidator userValidator = new UpdateUserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "20", "ivan23", "12345", "45");
        UpdateUserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UpdateUserValidator.ERROR_TYPES.NEGATIVE_CONFIRM, result);
    }

    @Test
    public void testGoodResult() {
        UpdateUserValidator userValidator = new UpdateUserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "20", "ivan23", "12345", "12345");
        UpdateUserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UpdateUserValidator.ERROR_TYPES.OK, result);
    }
}
