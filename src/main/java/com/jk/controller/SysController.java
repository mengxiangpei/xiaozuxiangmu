package com.jk.controller;

import com.jk.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by ASUS on 2017/6/27.
 */
@RequestMapping("sys")
@Controller
public class SysController {

    @Autowired
    private SysService sysService;


    @RequestMapping(value = "select",method = RequestMethod.GET)
    public String select(){
        return "selectList";
    }

}
