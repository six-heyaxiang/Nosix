package com.nosix.manager.bean;

/**
 * Created by john on 2/16/14.
 */
public class Permission {
    private Long id;
    private String NSname;
    private String NSdescribtion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNSname() {
        return NSname;
    }

    public void setNSname(String NSname) {
        this.NSname = NSname;
    }

    public String getNSdescribtion() {
        return NSdescribtion;
    }

    public void setNSdescribtion(String NSdescribtion) {
        this.NSdescribtion = NSdescribtion;
    }
}
