package com.jk.pojo;

public class SysRoleResourceKey {
    private String sysresourceId;

    private String sysroleId;

    public String getSysresourceId() {
        return sysresourceId;
    }

    public void setSysresourceId(String sysresourceId) {
        this.sysresourceId = sysresourceId == null ? null : sysresourceId.trim();
    }

    public String getSysroleId() {
        return sysroleId;
    }

    public void setSysroleId(String sysroleId) {
        this.sysroleId = sysroleId == null ? null : sysroleId.trim();
    }
}