package com.nosix.manager.service.impl;

import com.nosix.manager.bean.AdminUser;
import com.nosix.manager.dao.AdminUserDao;
import com.nosix.manager.service.AdminUserService;
import com.nosix.manager.utils.Constants;
import com.nosix.manager.utils.security.Digests;
import com.nosix.manager.utils.security.Encodes;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by john on 2/14/14.
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private AdminUserDao adminUserDao;

    @Override
    public AdminUser getUserByUsername(String username) {
        return adminUserDao.getUserByUsername(username);
    }

    @Override
    public boolean addAdminUser(AdminUser adminUser) {
        entryptPassword(adminUser);
        System.out.println(adminUser.getNSusername()+"||"+adminUser.getNSpassword()+"||"+adminUser.getNSsalt());
        adminUserDao.save(adminUser);
        return true;
    }

    /**
     * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
     */
    private void entryptPassword(AdminUser adminUser) {
        byte[] salt = Digests.generateSalt(Constants.SALT_SIZE);
        adminUser.setNSsalt(Encodes.encodeHex(salt));

        byte[] hashPassword = Digests.sha1(adminUser.getNSpassword().getBytes(), salt, Constants.HASH_INTERATIONS);
        adminUser.setNSpassword(Encodes.encodeHex(hashPassword));
    }
}
