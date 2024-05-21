package web.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.Dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao dao;

    public UserServiceImpl(UserDao dao) {
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getListUser() {
        return dao.getListUser();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    @Transactional
    public User mergeUser(User userId) {
        return dao.mergeUser(userId);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        if (dao.getListUser().stream().anyMatch(x -> x.getId() == id)) {
            dao.removeUser(id);
        }
    }
}
