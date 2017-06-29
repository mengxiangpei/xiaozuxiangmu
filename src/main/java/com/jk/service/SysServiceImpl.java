package com.jk.service;

import com.jk.dao.SysUserInfoMapper;
import com.jk.pojo.SysUserInfo;
import com.jk.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class SysServiceImpl implements SysService {
	@Autowired
	private SysUserInfoMapper sysUserInfoMapper;

	public void saveSysUser(SysUserInfo user) {
		//随机数id
		user.setSysuserId(UUID.randomUUID().toString() );
//		密码加密
		user.setSysuserPwd(MD5Util.md5(user.getSysuserPwd()));
		//创建时间
		user.setSysuserCreatedatetime(new Date());
		//修改时间
		user.setSysuserUpdatedatetime(new Date());
		sysUserInfoMapper.saveSysUser(user);
	}
	public SysUserInfo checkSysUser(SysUserInfo user) {
		return sysUserInfoMapper.checkSysUser(user);
	}
}
