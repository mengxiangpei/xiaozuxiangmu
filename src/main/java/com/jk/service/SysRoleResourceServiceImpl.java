package com.jk.service;

import com.jk.dao.SysRoleResourceMapper;
import com.jk.pojo.SysRoleInfo;
import com.jk.pojo.SysRoleResourceKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2017/06/28.
 */
@Service
public class SysRoleResourceServiceImpl implements  SysRoleResourceService {
    @Autowired
    private SysRoleResourceMapper sysRoleResourceMapper;
    public List<SysRoleResourceKey> getResourceByRoleId(SysRoleInfo role) {
        return sysRoleResourceMapper.getResourceByRoleId(role);
    }



}
