package com.jk.service;

import com.jk.pojo.SysRoleInfo;
import com.jk.util.PageUtil;

import java.util.List;

/**
 * Created by asus on 2017/06/28.
 */
public interface SysRoleService {

    List<SysRoleInfo> selectRoleList();
}
