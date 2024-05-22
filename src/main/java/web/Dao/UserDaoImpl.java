package web.Dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getListUser() {
        final String hql = "select u from User u";
        List<User> list = em.createQuery(hql, User.class).getResultList();
        return list;
    }

    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public User mergeUser(User userId) {
        return em.merge(userId);
    }

    @Override
    public void removeUser(int id) {
        final String hql = "delete User  where id = :id";
        em.createQuery(hql).setParameter("id", id).executeUpdate();
    }
}
