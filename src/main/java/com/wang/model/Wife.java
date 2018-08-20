package com.wang.model;

import java.util.List;

public class Wife {
    private Integer id;

    private String wifename;
    public  Wife(){}

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<Children> childrenList) {
        this.childrenList = childrenList;
    }

    private List<Children> childrenList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWifename() {
        return this.wifename;
    }

    public void setWifename(String wifename) {
        this.wifename = wifename == null ? null : wifename.trim();
    }
}