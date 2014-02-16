package com.nosix.manager.dao;

import com.nosix.manager.bean.AdminUser;
import org.springframework.stereotype.Repository;

/**
 * Created by john on 2/14/14.
 */
@Repository("adminUserDao")
public interface AdminUserDao {
    /**
     * @desc 通过用户名获得用户
     * @date 2014年2月14日23时30分10秒
     * @param NSusername
     * @return
     */
    AdminUser getUserByUsername(String NSusername);

    Long save(AdminUser adminUser);
}
