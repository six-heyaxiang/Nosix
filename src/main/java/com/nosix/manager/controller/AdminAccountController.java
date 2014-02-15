package com.nosix.manager.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by john on 2/14/14.
 */
@Controller
@RequestMapping("login")
public class AdminAccountController {
    private static final Logger log = LoggerFactory.getLogger(AdminAccountController.class);
    @RequestMapping("")
    public String adminLogin(Model model, @RequestParam(value = "username",defaultValue = "")String username,@RequestParam(value = "password",defaultValue = "")String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
            token.setRememberMe(true);
            org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        log.info("用户:{}登录Nosix管理系统",username);
        return "/views/main";
    }
}
