package com.nosix.manager.realms;

import com.nosix.manager.bean.User;
import com.nosix.manager.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.security.auth.login.AccountException;

/**
 * Created by john on 2/14/14.
 */
public class NosixJdbcRealm extends JdbcRealm{
    private  static final Logger log = LoggerFactory.getLogger(NosixJdbcRealm.class);
    @Resource
    private UserService userService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        User user = userService.getUserByUsername(upToken.getUsername());
        if(user != null){
            SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(upToken.getUsername(), user.getNSpassword(), getName());
            saInfo.setCredentials(ByteSource.Util.bytes(upToken.getUsername()));
            return saInfo;
        }else {
            return null;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return super.doGetAuthorizationInfo(principals);
    }
}
