package com.nosix.manager.service.impl;

import com.nosix.manager.bean.User;
import com.nosix.manager.dao.UserDao;
import com.nosix.manager.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by john on 2/14/14.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
