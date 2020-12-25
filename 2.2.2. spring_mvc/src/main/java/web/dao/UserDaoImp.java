package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("from User");
        List<User> result = query.getResultList();
        return result;
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);

    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void update(int id, User updaters) {
        User userToBeUpdated = entityManager.find(User.class, id);
        userToBeUpdated.setName(updaters.getName());
        userToBeUpdated.setAge(updaters.getAge());
    }


}
