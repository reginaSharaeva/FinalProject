package org.itis.gr404;

import org.itis.gr404.entities.User;
import org.itis.gr404.repositories.UserRepository;
import org.itis.gr404.repositories.UserRepositoryImpl;
import org.itis.gr404.validators.CreateUserValidator;
import org.itis.gr404.validators.UserValidator;
import org.itis.gr404.validators.form.UserForm;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CreateUserValidatorTest {

    @Test
    public void testNoLogin() {
        CreateUserValidator createUserValidator = new CreateUserValidator();
        UserForm userForm = new UserForm("Ivan", "Ivanov", "20", "", "12345", "12345");
        UserValidator.ERROR_TYPES result = createUserValidator.validateForCreate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.NO_LOGIN, result);
    }

    @Test
    public void testNoPassword() {
        UserRepository repository = mock(UserRepositoryImpl.class);

        List<User> users = new ArrayList<User>();
        users.add(new User("Ayrat", "Natfullin", 32, "ayrat", "parol"));
        users.add(new User("Regina", "Sharaeva", 20, "admin", "12345"));

        when(repository.getAllUsers()).thenReturn(users);

        CreateUserValidator createUserValidator = new CreateUserValidator(repository);
        UserForm userForm = new UserForm("Ivan", "Ivanov", "20", "ivan23", "", "12345");
        UserValidator.ERROR_TYPES result = createUserValidator.validateForCreate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.NO_PASSWORD, result);
    }

    @Test
    public void testNegativeLogin() {
        UserRepository repository = mock(UserRepositoryImpl.class);

        List<User> users = new ArrayList<User>();
        users.add(new User("Ayrat", "Natfullin", 32, "ayrat", "parol"));
        users.add(new User("Regina", "Sharaeva", 20, "admin", "12345"));

        when(repository.getAllUsers()).thenReturn(users);

        CreateUserValidator createUserValidator = new CreateUserValidator(repository);

        UserForm userForm = new UserForm("Ivan", "Ivanov", "20", "admin", "12345", "12345");
        UserValidator.ERROR_TYPES result = createUserValidator.validateForCreate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.NEGATIVE_LOGIN, result);
    }

    @Test
    public void testGoodResult() {
        UserRepository repository = mock(UserRepositoryImpl.class);

        List<User> users = new ArrayList<User>();
        users.add(new User("Ayrat", "Natfullin", 32, "ayrat", "parol"));
        users.add(new User("Regina", "Sharaeva", 20, "admin", "12345"));

        when(repository.getAllUsers()).thenReturn(users);

        CreateUserValidator createUserValidator = new CreateUserValidator(repository);

        UserForm userForm = new UserForm("Ivan", "Ivanov", "20", "ivan23", "12345", "12345");
        UserValidator.ERROR_TYPES result = createUserValidator.validateForCreate(userForm);
        Assert.assertEquals(UserValidator.ERROR_TYPES.OK, result);
    }
}
