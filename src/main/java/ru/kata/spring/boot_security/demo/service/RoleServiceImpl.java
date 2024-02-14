package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.models.Role;
@Service
public class RoleServiceImpl implements RoleService {
    private final UserDao userDao;

    public RoleServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public Role getRoleByName(String roleName) {
        return userDao.getRoleByName(roleName);
    }

    @Override
    @Transactional
    public void createRole(Role role) {
        userDao.createRole(role);
    }
}
