package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Role;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        List<User> users = entityManager.createQuery("from User").getResultList();
        return users;
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }


    @Override
    public User show(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public User findByUsername(String username) {
        Query query = entityManager.createQuery("from User where name = :name", User.class)
                .setParameter("name", username);
        return (User) query.getSingleResult();
    }


    @Override
    public void update(long id, User updaters) {
        entityManager.merge(updaters);
    }


}
