package com.nosix.manager.bean;

import java.util.Date;

/**
 * Created by john on 2/14/14.
 */
public class AdminUser {
    private Long id;
    private String NSusername;
    private String NSpassword;
    private Date NScreatetime;
    private String NSemail;
    private String NSphone;
    private String NSsalt;
    private String NSip;

    public String getNSip() {
        return NSip;
    }
    public void setNSip(String NSip) {
        this.NSip = NSip;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNSusername() {
        return NSusername;
    }

    public void setNSusername(String NSusername) {
        this.NSusername = NSusername;
    }

    public String getNSpassword() {
        return NSpassword;
    }

    public void setNSpassword(String NSpassword) {
        this.NSpassword = NSpassword;
    }

    public Date getNScreatetime() {
        return NScreatetime;
    }

    public void setNScreatetime(Date NScreatetime) {
        this.NScreatetime = NScreatetime;
    }

    public String getNSemail() {
        return NSemail;
    }

    public void setNSemail(String NSemail) {
        this.NSemail = NSemail;
    }

    public String getNSphone() {
        return NSphone;
    }

    public void setNSphone(String NSphone) {
        this.NSphone = NSphone;
    }

    public String getNSsalt() {
        return NSsalt;
    }

    public void setNSsalt(String NSsalt) {
        this.NSsalt = NSsalt;
    }
}
