package org.itis.gr404;

import org.itis.gr404.entities.User;
import org.itis.gr404.repositories.UserRepository;
import org.itis.gr404.repositories.UserRepositoryImpl;
import org.itis.gr404.validators.LoginValidator;
import org.itis.gr404.validators.form.UserForm;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Регина on 13.05.2016.
 */
public class LoginValidatorTest {

    @Test
    public void testNoLogin() {
        LoginValidator validator = new LoginValidator();
        User user = new User("Ivan", "Ivanov", 20, "", "12345");
        LoginValidator.ERROR_TYPES result = validator.validate(user);
        Assert.assertEquals(LoginValidator.ERROR_TYPES.NO_LOGIN, result);
    }

    @Test
    public void testNoPassword() {
        LoginValidator validator = new LoginValidator();
        User user = new User("Ivan", "Ivanov", 20, "ivan23", "");
        LoginValidator.ERROR_TYPES result = validator.validate(user);
        Assert.assertEquals(LoginValidator.ERROR_TYPES.NO_PASSWORD, result);
    }

    @Test
    public void testNoUser() {
        UserRepository repository = mock(UserRepositoryImpl.class);

        List<User> users = new ArrayList<User>();
        users.add(new User("Ayrat", "Natfullin", 32, "ayrat", "parol"));
        users.add(new User("Regina", "Sharaeva", 20, "admin", "12345"));

        when(repository.getAllUsers()).thenReturn(users);

        LoginValidator validator = new LoginValidator(repository);
        User user = new User("Ivan", "Ivanov", 20, "ivan23", "12345");
        LoginValidator.ERROR_TYPES result = validator.validate(user);
        Assert.assertEquals(LoginValidator.ERROR_TYPES.NO_USER, result);
    }

    @Test
    public void testNegativePassword() {

        UserRepository repository = mock(UserRepositoryImpl.class);

        List<User> users = new ArrayList<User>();
        users.add(new User("Ayrat", "Natfullin", 32, "ayrat", "parol"));
        users.add(new User("Ivan", "Ivanov", 20, "ivan23", "12345"));

        when(repository.getAllUsers()).thenReturn(users);

        LoginValidator validator = new LoginValidator(repository);

        User user = new User("Ivan", "Ivanov", 20, "ivan23", "wer");
        LoginValidator.ERROR_TYPES result = validator.validate(user);
        Assert.assertEquals(LoginValidator.ERROR_TYPES.NEGATIVE_PASSWORD, result);
    }

    @Test
    public void testGoodResult() {
        UserRepository repository = mock(UserRepositoryImpl.class);

        List<User> users = new ArrayList<User>();
        users.add(new User("Ayrat", "Natfullin", 32, "ayrat", "parol"));
        users.add(new User("Regina", "Sharaeva", 20, "admin", "12345"));
        users.add(new User("Ivan", "Ivanov", 20, "ivan23", new HashMake().md5Apache("12345")));

        when(repository.getAllUsers()).thenReturn(users);

        LoginValidator loginValidator = new LoginValidator(repository);

        User user = new User("Ivan", "Ivanov", 20, "ivan23", "12345");

        LoginValidator.ERROR_TYPES result = loginValidator.validate(user);
        Assert.assertEquals(LoginValidator.ERROR_TYPES.OK, result);
    }
}
