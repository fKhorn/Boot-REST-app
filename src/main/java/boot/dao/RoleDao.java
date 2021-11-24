package boot.dao;

import boot.model.Role;

import java.util.List;

public interface RoleDao {
    void addRole(Role role);
    Role getRoleByName(String roleName);
    List<Role> getAllRoles();
}
