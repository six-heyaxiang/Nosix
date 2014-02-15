package com.nosix.manager.dao;

import com.nosix.manager.bean.User;
import org.springframework.stereotype.Repository;

/**
 * Created by john on 2/14/14.
 */
@Repository("userDao")
public interface UserDao {
    /**
     * @desc 通过用户名获得用户
     * @date 2014年2月14日23时30分10秒
     * @param username
     * @return
     */
    User getUserByUsername(String username);
}
