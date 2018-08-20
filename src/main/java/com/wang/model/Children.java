package com.wang.model;

public class Children {
    public Children(){}
    private Integer childid;

    private String childname;

    private Integer wifeid;

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    private Wife wife;

    public Integer getChildid() {
        return childid;
    }

    public void setChildid(Integer childid) {
        this.childid = childid;
    }

    public String getChildname() {
        return this.childname;
    }

    public void setChildname(String childname) {
        this.childname = childname == null ? null : childname.trim();
    }

    public Integer getWifeid() {
        return wifeid;
    }

    public void setWifeid(Integer wifeid) {
        this.wifeid = wifeid;
    }
}