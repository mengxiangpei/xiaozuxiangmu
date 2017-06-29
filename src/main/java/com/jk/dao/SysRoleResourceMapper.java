package com.jk.dao;

<<<<<<< HEAD
import com.jk.pojo.SysResource;
=======
import com.jk.pojo.SysRoleInfo;
>>>>>>> db0e8d3b1823e3a6e9a39745ad16cad78118b1a7
import com.jk.pojo.SysRoleResourceKey;

import java.util.List;

public interface SysRoleResourceMapper {
    int deleteByPrimaryKey(SysRoleResourceKey key);

    int insert(SysRoleResourceKey record);

    int insertSelective(SysRoleResourceKey record);

<<<<<<< HEAD
=======
    List<SysRoleResourceKey> getResourceByRoleId(SysRoleInfo role);
>>>>>>> db0e8d3b1823e3a6e9a39745ad16cad78118b1a7
}