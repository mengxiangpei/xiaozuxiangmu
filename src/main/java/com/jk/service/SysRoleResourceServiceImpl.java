package com.jk.service;

import com.jk.dao.SysRoleResourceMapper;
import com.jk.pojo.SysRoleInfo;
import com.jk.pojo.SysRoleResourceKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2017/06/28.
 */
@Service
public class SysRoleResourceServiceImpl implements  SysRoleResourceService {
    @Autowired
    private SysRoleResourceMapper sysRoleResourceMapper;


    public List<SysRoleResourceKey> getResourceByRoleId(SysRoleInfo role) {
        return sysRoleResourceMapper.getResourceByRoleId(role);
    }

    @Override
    public void updateResourceOfRole(SysRoleResourceKey roleResource) {
        int x = sysRoleResourceMapper.deleteRoleResourceByRoleId(roleResource.getSysroleId());
        System.out.println(x);

        String[] split = roleResource.getSysresourceId().split(",");

        List<SysRoleResourceKey> roleResourceKeysList = new ArrayList<>();

        SysRoleResourceKey rr = null;
        for (int i = 0; i < split.length; i++) {
                rr = new SysRoleResourceKey();
            rr.setSysroleId(roleResource.getSysresourceId());
            rr.setSysresourceId(split[i]);

            roleResourceKeysList.add(rr);
        }

        sysRoleResourceMapper.insertRoleResourceList(roleResourceKeysList);

    }
}
