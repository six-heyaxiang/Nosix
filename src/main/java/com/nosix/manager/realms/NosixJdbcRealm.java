package com.nosix.manager.realms;

import com.nosix.manager.bean.AdminUser;
import com.nosix.manager.service.AdminUserService;
import com.nosix.manager.utils.Constants;
import com.nosix.manager.utils.security.Encodes;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * Created by john on 2/14/14.
 */
public class NosixJdbcRealm extends JdbcRealm{
    private  static final Logger log = LoggerFactory.getLogger(NosixJdbcRealm.class);
    @Resource
    private AdminUserService userService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        AdminUser adminUser = userService.getUserByUsername(upToken.getUsername());
        if(adminUser != null){
            byte[] salt = Encodes.decodeHex(adminUser.getNSsalt());
            SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(adminUser, adminUser.getNSpassword(),ByteSource.Util.bytes(salt), getName());

            return saInfo;
        }else {
            return null;
        }
    }
    /**
     * 设定Password校验的Hash算法与迭代次数.
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(Constants.HASH_ALGORITHM);
        matcher.setHashIterations(Constants.HASH_INTERATIONS);
        setCredentialsMatcher(matcher);
    }
}
