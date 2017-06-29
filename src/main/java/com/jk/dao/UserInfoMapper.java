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

    //新增
    int  insertUserInfo(UserInfo userInfo);
    //角色查询
    List selectUserList();


}