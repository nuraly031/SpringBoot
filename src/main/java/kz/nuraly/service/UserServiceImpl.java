package kz.nuraly.service;

import kz.nuraly.dao.UserDao;
import jakarta.transaction.Transactional;
import kz.nuraly.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public List<User> index() {
        return userDao.index();
    }

    @Override
    public User indexCount(int id) {
        return userDao.indexCount(id);
    }
    @Transactional
    @Override
    public void save(User user) {
        userDao.save(user);

    }
    @Transactional
    @Override
    public void update(int id, User updated) {
        userDao.update(id,updated);
    }
    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}