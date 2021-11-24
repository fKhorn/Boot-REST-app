package boot.dao;

import boot.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void delete(User user);
    void updateUser(User user);
    User getUserById(Long id);
    User getUserByEmail(String email);
    User getUserByName(String name);
    List<User> getAllUsers();
}
