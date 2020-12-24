package web.dao;

import web.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static int USER_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++USER_COUNT,"Ivan1",31));
        users.add(new User(++USER_COUNT,"Ivan2",32));
        users.add(new User(++USER_COUNT,"Ivan3",33));
        users.add(new User(++USER_COUNT,"Ivan4",34));
    }

    public List<User> index(){
        return users;
    }

    public User show(int id){
        return users.stream().filter(user -> user.getId()==id).findAny().orElse(null);
    }

    public void save(User user){
        user.setId(++USER_COUNT);
        users.add(user);

    }
    public void update(int id ,User updateduser){
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updateduser.getName());
        userToBeUpdated.setAge(updateduser.getAge());
    }

    public void delete(int id ){
        users.removeIf(p->p.getId() == id);
    }
}
