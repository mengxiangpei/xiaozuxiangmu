package com.jk.service;

import com.jk.pojo.SysRoleResourceKey;

/**
 * Created by ASUS on 2017/6/27.
 */
public interface SysService {


    SysRoleResourceKey toUpdateSys(String sysId);

    void grantResourceOfRole(SysRoleResourceKey sysRoleResourceKey);
}
