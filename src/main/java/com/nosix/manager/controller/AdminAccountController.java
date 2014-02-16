package com.nosix.manager.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


/**
* Created by john on 2/14/14.
*/
@Controller
@RequestMapping("login")
public class AdminAccountController {
    private static final Logger log = LoggerFactory.getLogger(AdminAccountController.class);
    @RequestMapping("")
    public String adminLogin(HttpServletRequest request,Model model, @RequestParam(value = "username",defaultValue = "")String username,@RequestParam(value = "password",defaultValue = "")String password){
        String ip = this.getRemoteAddress(request);
        System.out.print(username+"||"+password);
        //1.接受提交的当事人证书
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        //2.获得当前的Subject
        Subject currentSubject = SecurityUtils.getSubject();
        //3.登录
        try {
            currentSubject.login(token);
        }catch (Exception e){
            e.printStackTrace();
            currentSubject.logout();
        }
        //4.登录成功,插入登录信息
        log.info("用户:{}登录Nosix管理系统",username);
        return "/views/main";
    }
    /**
     * 获取客户机IP地址
     *@param request  HttpServletRequest
     *@return 客户机IP地址
     */
    private String getRemoteAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
