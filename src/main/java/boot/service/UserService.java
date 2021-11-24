package boot.service;

import boot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void delete(long id);
    void updateUser(User user);
    void initialUser(User user);
    void setPasswordEncoder(User user);
    User getUserById(Long id);
    User getUserByName(String name);
    List<User> getAllUsers();

}
