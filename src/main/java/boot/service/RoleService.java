package boot.service;

import boot.model.Role;

import java.util.List;

public interface RoleService {
    void addRole(Role role);
    Role getRoleByName(String roleName);
    List<Role> getAllRoles();
}
