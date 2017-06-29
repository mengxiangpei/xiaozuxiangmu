package com.jk.dao;

import com.jk.pojo.SysResource;

import java.util.List;

import java.util.List;

public interface SysresourceMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysResource record);

    int insertSelective(SysResource record);

    SysResource selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysResource record);

    int updateByPrimaryKey(SysResource record);

<<<<<<< HEAD
    ///左侧的树
    List<SysResource> selectMainMenu(String userId);
=======
    int updateByPrimaryKey(Sysresource record);


    List<Sysresource> selectResourceTree();
>>>>>>> db0e8d3b1823e3a6e9a39745ad16cad78118b1a7
}