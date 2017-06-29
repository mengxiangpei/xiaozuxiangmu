package com.jk.service;

import com.jk.pojo.SysRoleInfo;
import com.jk.pojo.SysRoleResourceKey;

import java.util.List;

/**
 * Created by asus on 2017/06/28.
 */
public interface SysRoleResourceService {
    List<SysRoleResourceKey> getResourceByRoleId(SysRoleInfo role);
}
