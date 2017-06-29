package com.jk.dao;

import com.jk.pojo.SysResource;
import com.jk.pojo.SysRoleResourceKey;

import java.util.List;

public interface SysRoleResourceMapper {
    int deleteByPrimaryKey(SysRoleResourceKey key);

    int insert(SysRoleResourceKey record);

    int insertSelective(SysRoleResourceKey record);

}