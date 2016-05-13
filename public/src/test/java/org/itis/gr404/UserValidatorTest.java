package org.itis.gr404;

import org.itis.gr404.validators.UserValidator;
import org.itis.gr404.validators.form.UserForm;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Регина on 12.05.2016.
 */
public class UserValidatorTest {

    @Test
    public void testNoFirstName() {
        UserValidator userValidator = new UserValidator();
        UserForm userForm = new UserForm("", "Ivanov", "20", "ivan23", "12345", "12345");
        UserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.NO_FIRSTNAME, result);
    }

    @Test
    public void testNoLastName() {
        UserValidator userValidator = new UserValidator();
        UserForm userForm = new UserForm("Ivan", "", "20", "ivan23", "12345", "12345");
        UserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.NO_LASTNAME, result);
    }

    @Test
    public void testNoAge() {
        UserValidator userValidator = new UserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "", "ivan23", "12345", "12345");
        UserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.NO_AGE, result);
    }

    @Test
    public void testNullAge() {
        UserValidator userValidator = new UserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "0", "ivan23", "12345", "12345");
        UserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.NO_AGE, result);
    }

    @Test
    public void testNegativeAge() {
        UserValidator userValidator = new UserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "tr", "ivan23", "12345", "12345");
        UserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.NEGATIVE_AGE, result);
    }

    @Test
    public void testAgeLessNull() {
        UserValidator userValidator = new UserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "-2", "ivan23", "12345", "12345");
        UserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.NEGATIVE_AGE, result);
    }

    @Test
    public void testNegativeConfirm() {
        UserValidator userValidator = new UserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "20", "ivan23", "12345", "45");
        UserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.NEGATIVE_CONFIRM, result);
    }

    @Test
    public void testGoodResult() {
        UserValidator userValidator = new UserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "20", "ivan23", "12345", "12345");
        UserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.OK, result);
    }
}
