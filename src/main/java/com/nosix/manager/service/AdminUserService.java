package com.nosix.manager.service;

import com.nosix.manager.bean.AdminUser;

/**
 * Created by john on 2/14/14.
 */
public interface AdminUserService {
    /**
     * @desc 获得用户通过用户名
     * @date 2014年2月14日 23时33分48秒
     * @param username
     * @return
     */
    AdminUser getUserByUsername(String username);

    boolean addAdminUser(AdminUser adminUser);
}
