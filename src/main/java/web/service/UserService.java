package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getListUser ();
    void addUser(User user);
    User mergeUser(User userId);
    void deleteById(int id);
}
