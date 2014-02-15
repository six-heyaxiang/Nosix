package com.nosix.manager.service;

import com.nosix.manager.bean.User;

/**
 * Created by john on 2/14/14.
 */
public interface UserService {
    /**
     * @desc 获得用户通过用户名
     * @date 2014年2月14日 23时33分48秒
     * @param username
     * @return
     */
    User getUserByUsername(String username);
}
