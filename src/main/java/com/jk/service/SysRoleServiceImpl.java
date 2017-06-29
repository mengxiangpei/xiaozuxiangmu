package com.jk.service;

import com.jk.dao.SysRoleInfoMapper;
import com.jk.pojo.SysRoleInfo;
import com.jk.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2017/06/28.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleInfoMapper sysRoleInfoMapper;

    @Override
    public List<SysRoleInfo> selectRoleList() {
        return sysRoleInfoMapper.selectRoleList();
    }
}
