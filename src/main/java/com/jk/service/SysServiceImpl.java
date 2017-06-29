package com.jk.service;

import com.jk.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ASUS on 2017/6/27.
 */
@Service
public class SysServiceImpl implements SysService {

    @Autowired
    private UserInfoMapper userInfoMapper;
//角色查询


    @Override
    public List selectUserList() {
        return userInfoMapper.selectUserList();
    }
}
