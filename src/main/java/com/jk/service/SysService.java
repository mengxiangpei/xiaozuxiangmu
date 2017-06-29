package com.jk.service;

import java.util.List;

/**
 * Created by ASUS on 2017/6/27.
 */
import com.jk.pojo.SysUserInfo;

public interface SysService {

	void saveSysUser(SysUserInfo user);

    //角色查询
    List selectUserList();
	SysUserInfo checkSysUser(SysUserInfo user);
}
