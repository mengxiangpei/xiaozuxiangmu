package com.jk.service;

import com.jk.pojo.SysUserInfo;

public interface SysService {

	void saveSysUser(SysUserInfo user);

	SysUserInfo checkSysUser(SysUserInfo user);
}
