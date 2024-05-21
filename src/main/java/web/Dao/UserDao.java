package web.Dao;


import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getListUser();
    void addUser(User user);
    User mergeUser(User userId);
    void removeUser(int id);
}
