package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao  {
    List<User> getAllUsers();
    void save(User user);
    User show(long id);
    void update(long id, User updatedUser);
    void delete(long id);
    User findByUsername(String username);
}
