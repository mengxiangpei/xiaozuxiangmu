package com.jk.controller;

import com.jk.pojo.UserInfo;
import com.jk.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by ASUS on 2017/6/27.
 */
@RequestMapping("sys")
@Controller
public class SysController {

    @Autowired
    private SysService sysService;



//   角色查询
     @RequestMapping("selectUserList")
    @ResponseBody
    public List<UserInfo> selectUserList(){

        List userPage = sysService.selectUserList();

        return userPage;
    }





   //页面跳转

    @RequestMapping(value = "select",method = RequestMethod.GET)
    public String select(){
        return "main/home";
    }

}
