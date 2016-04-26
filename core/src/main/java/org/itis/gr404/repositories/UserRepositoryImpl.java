package org.itis.gr404.repositories;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.itis.gr404.HashMake;
import org.itis.gr404.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Regina on 13.04.2016.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUserByLogin(String login) {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("login", login)).uniqueResult();
    }

    @Override
    public User getUserById(int id) {
        return (User) sessionFactory.getCurrentSession().createCriteria(User.class).add(Restrictions.eq("id", id)).uniqueResult();
    }

    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        HashMake hashMake = new HashMake();
        String psw = hashMake.md5Apache(user.getPassword());
        user.setPassword(psw);
        sessionFactory.getCurrentSession().save(user);
    }
}
