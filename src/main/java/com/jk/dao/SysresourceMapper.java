package com.jk.dao;

import com.jk.pojo.SysResource;

import java.util.List;

public interface SysresourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);

    ///左侧的树
    List<SysResource> selectMainMenu(String userId);
}