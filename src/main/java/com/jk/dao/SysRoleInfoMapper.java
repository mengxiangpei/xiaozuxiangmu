package com.jk.dao;

import com.jk.pojo.SysRoleInfo;

public interface SysRoleInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRoleInfo record);

    int insertSelective(SysRoleInfo record);

    SysRoleInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRoleInfo record);

    int updateByPrimaryKey(SysRoleInfo record);
}