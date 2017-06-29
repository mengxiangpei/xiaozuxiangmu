package com.jk.service;

import com.jk.pojo.Tree;
import com.jk.pojo.UserInfo;

import java.util.List;

/**
 * Created by 高启友 on 2017/6/28.
 */
public interface SyResourceService {
    //左侧的树
    List<Tree> selectMainMenu(String userId);
    //新增用户
    int insertSelective(UserInfo userInfo);

}
