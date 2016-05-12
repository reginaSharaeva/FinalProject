package org.itis.gr404;

import org.itis.gr404.entities.User;
import org.itis.gr404.repositories.UserRepository;
import org.itis.gr404.repositories.UserRepositoryImpl;
import org.itis.gr404.validators.UserValidator;
import org.itis.gr404.validators.form.UserForm;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    public void testNoLogin() {
        UserValidator userValidator = new UserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "20", "", "12345", "12345");
        UserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.NO_LOGIN, result);
    }

    @Test
    public void testNoPassword() {
        UserValidator userValidator = new UserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "20", "ivan23", "", "12345");
        UserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.NO_PASSWORD, result);
    }

    @Test
    public void testNoConfirm() {
        UserValidator userValidator = new UserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "20", "ivan23", "12345", "");
        UserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.NO_CONFIRM, result);
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
    public void testNegativeLogin() {
        UserRepository repository = mock(UserRepositoryImpl.class);

        List<User> users = new ArrayList<User>();
        users.add(new User("Ayrat", "Natfullin", 32, "ayrat", "parol"));
        users.add(new User("Regina", "Sharaeva", 20, "admin", "12345"));

        when(repository.getAllUsers()).thenReturn(users);

        UserValidator userValidator = new UserValidator(repository);

        UserForm userForm = new UserForm("Ivan", "Ivanov", "20", "admin", "12345", "12345");
        UserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.NEGATIVE_LOGIN, result);
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
        UserRepository repository = mock(UserRepositoryImpl.class);

        List<User> users = new ArrayList<User>();
        users.add(new User("Ayrat", "Natfullin", 32, "ayrat", "parol"));
        users.add(new User("Regina", "Sharaeva", 20, "admin", "12345"));

        when(repository.getAllUsers()).thenReturn(users);

        UserValidator userValidator = new UserValidator(repository);

        UserForm userForm = new UserForm("Ivan", "Ivanov", "20", "ivan23", "12345", "12345");
        UserValidator.ERROR_TYPES result = userValidator.validate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.OK, result);
    }
}
