package com.project.service;

import com.project.entity.Role;
import com.project.entity.User;

public interface UserService
{
    User findUserByUsername(String username);

    User saveUser(User user);

    Role addRole(Role role);
    User addRoleToUser(String username, String roleName);

    void deleteAllUsers();
    void deleteAllRoles();

}
