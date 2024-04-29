package kz.nuraly.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import kz.nuraly.model.User;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> index() {
        return entityManager.createQuery("select c from User c", User.class)
                .getResultList();
    }
    @Override
    public User indexCount(int id) {
        return entityManager.find(User.class, id);
    }
    @Transactional
    @Override
    public void save(User user) {
        entityManager.persist(user);
    }
    @Transactional
    @Override
    public void update(int id, User updated) {
        User userToBeUpdated = entityManager.find(User.class, id);

        userToBeUpdated.setName(updated.getName());
        userToBeUpdated.setLastname(updated.getLastname());
        userToBeUpdated.setAge(updated.getAge());
        userToBeUpdated.setId(updated.getId());
    }
    @Transactional
    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }
}
