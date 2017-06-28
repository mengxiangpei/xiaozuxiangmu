package com.jk.dao;

import com.jk.pojo.Sysresource;

public interface SysresourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(Sysresource record);

    int insertSelective(Sysresource record);

    Sysresource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Sysresource record);

    int updateByPrimaryKey(Sysresource record);
}