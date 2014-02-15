package com.nosix.manager.service.impl;

import com.nosix.manager.bean.User;
import com.nosix.manager.dao.UserDao;
import com.nosix.manager.service.UserService;
import com.nosix.manager.utils.Constants;
import com.nosix.manager.utils.security.Digests;
import com.nosix.manager.utils.security.Encodes;
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

    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     */
    private void entryptPassword(User user) {
        byte[] salt = Digests.generateSalt(Constants.SALT_SIZE);
        user.setNSsalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(user.getNSpassword().getBytes(), salt, Constants.HASH_INTERATIONS);
        user.setNSpassword(Encodes.encodeHex(hashPassword));
    }
}
