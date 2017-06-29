package com.jk.dao;

import com.jk.pojo.SysRoleInfo;
import com.jk.util.PageUtil;

import java.util.List;

public interface SysRoleInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysRoleInfo record);

    int insertSelective(SysRoleInfo record);

    SysRoleInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysRoleInfo record);

    int updateByPrimaryKey(SysRoleInfo record);


    List<SysRoleInfo> selectRoleList();
}