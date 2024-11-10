package com.entity;

import com.util.VeDate;

public class Rebbs {
    private String rebbsid = "R" + VeDate.getStringId();
    private String usersid;
    private String bbsid;
    private String contents;
    private String addtime;
    private String username;
    private String title;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRebbsid() {
        return rebbsid;
    }

    public void setRebbsid(String rebbsid) {
        this.rebbsid = rebbsid;
    }

    public String getUsersid() {
        return this.usersid;
    }

    public void setUsersid(String usersid) {
        this.usersid = usersid;
    }

    public String getBbsid() {
        return this.bbsid;
    }

    public void setBbsid(String bbsid) {
        this.bbsid = bbsid;
    }

    public String getContents() {
        return this.contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getAddtime() {
        return this.addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}


/**
 * 
 */
