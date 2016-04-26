package org.itis.gr404.repositories;

import org.itis.gr404.entities.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Regina on 11.04.2016.
 */
@Repository
public interface UserRepository {

    public User getUserByLogin(String login);

    public User getUserById(int id);

    public List getAllUsers();

    public void updateUser(User user);

    public void deleteUser(User user);

    public void saveUser(User user);
}
