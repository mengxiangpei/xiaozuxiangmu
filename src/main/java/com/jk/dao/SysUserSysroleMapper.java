package com.jk.dao;

import com.jk.pojo.SysUserSysroleKey;

public interface SysUserSysroleMapper {
    int deleteByPrimaryKey(SysUserSysroleKey key);

    int insert(SysUserSysroleKey record);

    int insertSelective(SysUserSysroleKey record);
}