package com.jk.dao;

import com.jk.pojo.Sysresource;

import java.util.List;

public interface SysresourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Sysresource record);

    int insertSelective(Sysresource record);

    Sysresource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sysresource record);

    int updateByPrimaryKey(Sysresource record);

    ///左侧的树
    List<Sysresource> selectMainMenu(String userId);



    List<Sysresource> selectResourceTree();
}