package com.nosix.manager.bean;

import java.util.Date;

/**
 * Created by john on 2/16/14.
 */
public class Role {
    private Long id;
    private String NSremark;
    private String NSrolecode;
    private String NSisdeleted;
    private Date   NScreatetime;

    public String getNSrolecode() {
        return NSrolecode;
    }

    public void setNSrolecode(String NSrolecode) {
        this.NSrolecode = NSrolecode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNSremark() {
        return NSremark;
    }

    public void setNSremark(String NSremark) {
        this.NSremark = NSremark;
    }

    public String getNSisdeleted() {
        return NSisdeleted;
    }

    public void setNSisdeleted(String NSisdeleted) {
        this.NSisdeleted = NSisdeleted;
    }

    public Date getNScreatetime() {
        return NScreatetime;
    }

    public void setNScreatetime(Date NScreatetime) {
        this.NScreatetime = NScreatetime;
    }
}
