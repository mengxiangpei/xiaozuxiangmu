package com.jk.service;

import com.jk.dao.SysresourceMapper;
import com.jk.pojo.Sysresource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by asus on 2017/06/28.
 */
@Service
public class SysResourceServiceImpl implements  SysResourceService {
    @Autowired
    private SysresourceMapper sysresourceMapper;

    public List<Sysresource> getResourceTree() {
        return sysresourceMapper.selectResourceTree();
    }

}
