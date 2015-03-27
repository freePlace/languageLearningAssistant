package freeplace.lla.model.data.service;

import java.util.List;

import freeplace.lla.model.data.HibernateUtil;
import freeplace.lla.model.data.repositories.UserRepository;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import freeplace.lla.model.entities.User;

@Service
public class UserServiceImpl implements UserService<User>{
    
    private final UserRepository userRepository;

    public UserServiceImpl(){
        userRepository = null;
    }
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User add(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User update(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public User findByLogin(String login, boolean addComments) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            User user = (User) session.createQuery("from User where login =:login")
                    .setString("login", login)
                    .uniqueResult();
            session.getTransaction().commit();
            if(addComments) {
                Hibernate.initialize(user.getComments());
            }
            return user;
        } catch (Exception e) {
            if(session != null) {
                session.getTransaction().rollback();
            }
            throw new HibernateException(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
