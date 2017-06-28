package com.jk.pojo;

public class SysUserSysroleKey {
    private String sysuserId;

    private String sysroleId;

    public String getSysuserId() {
        return sysuserId;
    }

    public void setSysuserId(String sysuserId) {
        this.sysuserId = sysuserId == null ? null : sysuserId.trim();
    }

    public String getSysroleId() {
        return sysroleId;
    }

    public void setSysroleId(String sysroleId) {
        this.sysroleId = sysroleId == null ? null : sysroleId.trim();
    }
}