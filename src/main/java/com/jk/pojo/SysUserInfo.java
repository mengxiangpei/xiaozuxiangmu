package com.jk.pojo;

import java.util.Date;

public class SysUserInfo {
    private String sysuserId;

    private String sysuserName;

    private String sysuserLoginname;

    private String sysuserPwd;

    private String sysuserSex;

    private String sysuserAge;

    private String sysuserPhoto;

    private Date sysuserUpdatedatetime;

    private Date sysuserCreatedatetime;
    //验证码
    private String imgcode;

    public String getImgcode() {
        return imgcode;
    }

    public void setImgcode(String imgcode) {
        this.imgcode = imgcode;
    }

    public String getSysuserId() {
        return sysuserId;
    }

    public void setSysuserId(String sysuserId) {
        this.sysuserId = sysuserId == null ? null : sysuserId.trim();
    }

    public String getSysuserName() {
        return sysuserName;
    }

    public void setSysuserName(String sysuserName) {
        this.sysuserName = sysuserName == null ? null : sysuserName.trim();
    }

    public String getSysuserLoginname() {
        return sysuserLoginname;
    }

    public void setSysuserLoginname(String sysuserLoginname) {
        this.sysuserLoginname = sysuserLoginname == null ? null : sysuserLoginname.trim();
    }

    public String getSysuserPwd() {
        return sysuserPwd;
    }

    public void setSysuserPwd(String sysuserPwd) {
        this.sysuserPwd = sysuserPwd == null ? null : sysuserPwd.trim();
    }

    public String getSysuserSex() {
        return sysuserSex;
    }

    public void setSysuserSex(String sysuserSex) {
        this.sysuserSex = sysuserSex == null ? null : sysuserSex.trim();
    }

    public String getSysuserAge() {
        return sysuserAge;
    }

    public void setSysuserAge(String sysuserAge) {
        this.sysuserAge = sysuserAge == null ? null : sysuserAge.trim();
    }

    public String getSysuserPhoto() {
        return sysuserPhoto;
    }

    public void setSysuserPhoto(String sysuserPhoto) {
        this.sysuserPhoto = sysuserPhoto == null ? null : sysuserPhoto.trim();
    }

    public Date getSysuserUpdatedatetime() {
        return sysuserUpdatedatetime;
    }

    public void setSysuserUpdatedatetime(Date sysuserUpdatedatetime) {
        this.sysuserUpdatedatetime = sysuserUpdatedatetime;
    }

    public Date getSysuserCreatedatetime() {
        return sysuserCreatedatetime;
    }

    public void setSysuserCreatedatetime(Date sysuserCreatedatetime) {
        this.sysuserCreatedatetime = sysuserCreatedatetime;
    }


}