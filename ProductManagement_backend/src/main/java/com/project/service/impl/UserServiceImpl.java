package com.project.service.impl;

import com.project.entity.Role;
import com.project.entity.User;
import com.project.repository.RoleRepository;
import com.project.repository.UserRepository;
import com.project.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService
{
    UserRepository userRepository;

    RoleRepository roleRepository;

    BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User findUserByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }


    @Override
    public User saveUser(User user)
    {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User addRoleToUser(String username, String roleName)
    {
        User usr = userRepository.findByUsername(username);
        Role r = roleRepository.findByRole(roleName);

        usr.getRoles().add(r);
        return usr;
    }


    @Override
    public Role addRole(Role role)
    {
        return roleRepository.save(role);
    }


    @Override
    public void deleteAllUsers()
    {
        userRepository.deleteAll();

    }

    @Override
    public void deleteAllRoles()
    {
        roleRepository.deleteAll();

    }

}
