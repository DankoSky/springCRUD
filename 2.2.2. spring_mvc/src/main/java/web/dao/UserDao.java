package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao  {
    List<User> getAllUsers();
    boolean save(User user);
    User show(int id);
    void update(int id, User updatedUser);
    void delete(int id);
    User findByUsername(String username);
}
