package boot.controllers;

import boot.model.Role;
import boot.model.User;
import boot.service.RoleService;
import boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users;
    }

    @GetMapping("/authorities")
    public List<Role> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        return roles;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/addNew")
    public User addNewUser(@RequestBody User user) {
        userService.addUser(user);
        return userService.getUserByName(user.getUsername());
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        userService.updateUser(user);
        System.out.println(userService.getUserById(user.getId()));
        return userService.getUserById(user.getId());
    }

    @DeleteMapping("{id}")
    public User deleteUser(@PathVariable long id) {
        User user = userService.getUserById(id);
        userService.delete(id);
        return user;
    }
}
