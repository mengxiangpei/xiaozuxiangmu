package com.jk.controller;

import com.jk.pojo.SysRoleInfo;
import com.jk.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by asus on 2017/06/28.
 */
@Controller
@RequestMapping(value = "role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;


    /**
     **
     * @return 分页Role信息
     */
    @RequestMapping(value="selectRoleList",method= RequestMethod.POST)
    @ResponseBody
    public List<SysRoleInfo> selectRoleList(){
        List<SysRoleInfo> sysRoleInfoList = sysRoleService.selectRoleList();
        return sysRoleInfoList;
    }


    @RequestMapping("toRoleList")
    public String toRoleList(){
        return "role/roleList";
    }
}
