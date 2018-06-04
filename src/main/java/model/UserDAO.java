package model;

import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;


public class UserDAO extends AbstractDAO<User> {
    public UserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }


    public User findById(Long id){
        return get(id);
    }

    public void createUser(User user){
        persist(user);
    }
}
