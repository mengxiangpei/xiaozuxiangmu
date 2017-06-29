package com.jk.service;

import com.jk.dao.SysRoleResourceMapper;
import com.jk.dao.UserInfoMapper;
import com.jk.pojo.SysRoleResourceKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ASUS on 2017/6/27.
 */
@Service
public class SysServiceImpl implements SysService {

    @Autowired
    private UserInfoMapper grantResourceOfRole;


    @Autowired
    private SysRoleResourceMapper sysRoleResourceMapper;

    @Override
    public void grantResourceOfRole(SysRoleResourceKey sysRoleResourceKey) {
        sysRoleResourceMapper.grantResourceOfRole(sysRoleResourceKey);
    }

    @Override
    public SysRoleResourceKey toUpdateSys(String sysId) {
        return sysRoleResourceMapper.toUpdateSys(sysId);
    }
}
