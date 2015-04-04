package freeplace.lla.model.data.service.user;

import java.util.List;

import freeplace.lla.model.data.HibernateUtil;
import freeplace.lla.model.data.repositories.user.UserRepository;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import freeplace.lla.model.entities.user.User;

@Service
public class UserServiceImpl extends UserService {
    
    public UserServiceImpl(){
        jpaRepository = null;
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.jpaRepository = userRepository;
    }

    @Override
    public List<User> findByName(String name) {
        return ((UserRepository)jpaRepository).findByName(name);
    }

    @Override
    public List<User> findByLastName(String lastName) {
        return ((UserRepository)jpaRepository).findByLastName(lastName);
    }

    @Override
    public User findByEmail(String email) {
        return ((UserRepository)jpaRepository).findByEmail(email);
    }

    @Override
    public User findByLogin(String login) {
        return ((UserRepository)jpaRepository).findByLogin(login);
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
