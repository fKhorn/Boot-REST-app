package boot.util;

import boot.model.Role;
import boot.model.User;
import boot.service.RoleService;
import boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Util {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void setDefaultUsers() {
        Set<Role> roles = new HashSet<>();
        roleService.addRole(new Role("ROLE_USER"));
        roleService.addRole(new Role("ROLE_ADMIN"));
        roles.add(roleService.getRoleByName("ROLE_USER"));
        User user = new User("user", "user", "user@user.com", roles);
        userService.setPasswordEncoder(user);
        userService.initialUser(user);

        Set<Role> roles1 = new HashSet<>();
//        roles1.add(roleService.getRoleByName("ROLE_USER"));
        roles1.add(roleService.getRoleByName("ROLE_ADMIN"));
        User admin = new User("admin", "admin", "admin@admin.com", roles1);
        userService.setPasswordEncoder(admin);
        userService.initialUser(admin);
    }
}
