package com.jk.service;

import com.jk.dao.SysUserInfoMapper;
import com.jk.pojo.SysUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2017/6/28.
 */
@Service
public class SysUserInfoServiceImpl implements SysUserInfoService{
    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;


    @Override
    public SysUserInfo checkSysUser(SysUserInfo user) {

        return sysUserInfoMapper.checkSysUserInfo(user);
    }
}
