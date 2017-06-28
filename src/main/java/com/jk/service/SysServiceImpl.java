package com.jk.service;

import com.jk.dao.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ASUS on 2017/6/27.
 */
@Service
public class SysServiceImpl implements SysService {

    @Autowired
    private UserInfoMapper userInfoMapper;

}
