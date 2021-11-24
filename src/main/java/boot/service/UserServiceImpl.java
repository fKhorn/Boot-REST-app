package boot.service;

import boot.dao.UserDao;
import boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        setPasswordEncoder(user);
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void delete(long id) {
        userDao.delete(getUserById(id));
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        if(!getUserById(user.getId()).getPassword().equals(user.getPassword())) {
            setPasswordEncoder(user);
        }
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void initialUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void setPasswordEncoder(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }
}
