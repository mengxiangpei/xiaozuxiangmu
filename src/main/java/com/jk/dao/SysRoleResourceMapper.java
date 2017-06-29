package com.jk.dao;

import com.jk.pojo.SysRoleInfo;
import com.jk.pojo.SysRoleResourceKey;

import java.util.List;

public interface SysRoleResourceMapper {
    int deleteByPrimaryKey(SysRoleResourceKey key);

    int insert(SysRoleResourceKey record);

    int insertSelective(SysRoleResourceKey record);

    List<SysRoleResourceKey> getResourceByRoleId(SysRoleInfo role);
}