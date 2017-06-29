package com.jk.dao;

import com.jk.pojo.SysUserInfo;
import com.jk.pojo.UserInfo;

import java.util.List;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
<<<<<<< HEAD


    int  insertUserInfo(UserInfo userInfo);
=======
    //角色查询
    List selectUserList();


>>>>>>> db0e8d3b1823e3a6e9a39745ad16cad78118b1a7
}