    package com.nosix.manager.controller;

    import com.nosix.manager.bean.AdminUser;
    import com.nosix.manager.service.AdminUserService;
    import org.apache.shiro.SecurityUtils;
    import org.apache.shiro.authc.UsernamePasswordToken;
    import org.apache.shiro.subject.Subject;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestParam;

    import javax.annotation.Resource;
    import javax.servlet.http.HttpServletRequest;


    /**
    * Created by john on 2/14/14.
    */
    @Controller
    @RequestMapping("account")
    public class AdminAccountController {
        private static final Logger log = LoggerFactory.getLogger(AdminAccountController.class);
        @Resource
        private AdminUserService adminUserService;

        @RequestMapping("login")
        public String adminLogin(HttpServletRequest request,Model model, @RequestParam(value = "NSusername",defaultValue = "")String NSusername,@RequestParam(value = "NSpassword",defaultValue = "")String NSpassword){
            String ip = this.getRemoteAddress(request);
            //1.接受提交的当事人证书
            UsernamePasswordToken token = new UsernamePasswordToken(NSusername,NSpassword);
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
            log.info("用户:{}登录Nosix管理系统",NSusername);
            return "redirect:/main.do";
        }
        @RequestMapping(value = "add")
        public String addAdminUser(@RequestParam(value = "NSusername",defaultValue = "")String NSusername,@RequestParam(value = "NSpassword",defaultValue = "")String NSpassword,Model model,HttpServletRequest request){
            if(NSusername.isEmpty()|| NSpassword.isEmpty()){

            }else{
                AdminUser adminUser  = new AdminUser();
                adminUser.setNSusername(NSusername);
                adminUser.setNSpassword(NSpassword);
                adminUserService.addAdminUser(adminUser);
            }
            return "views/main";
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
