package com.jk.controller;

import com.jk.pojo.SysUserInfo;
import com.jk.service.SysService;
import com.jk.util.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by ASUS on 2017/6/27.
 */
@RequestMapping("sys")
@Controller
public class SysController {

    @Autowired
    private SysService sysService;





    //注册
    @RequestMapping(value="registerSysUser",method=RequestMethod.POST)
    @ResponseBody
    public ReturnJson registerSysUser(SysUserInfo user, HttpServletRequest request){
        ReturnJson rj=new ReturnJson();
        //获取session中的验证码
        String code = (String) request.getSession().getAttribute("imageCode");
        //校验验证码是否正确
        if (null != user && !"".equals(user.getImgcode().trim()) && !"".equals(code)) {
            //验证码正确---不区分大小写
            if (user.getImgcode().trim().toUpperCase().equals(code.toUpperCase())) {
                sysService.saveSysUser(user);
                // 主键id ,布尔类型 ,影响数据库的条数
                rj.setSuccess(true);
                rj.setMsg("注册成功");
            }else{
                rj.setSuccess(false);
                rj.setMsg("验证码错误");
            }
        }
        return rj;
    }

    //校验用户---账户名称是否已存在
    @RequestMapping(value="checkSysUser",method=RequestMethod.POST)
    @ResponseBody
    public ReturnJson checkSysUser(SysUserInfo user){
        ReturnJson rj = new ReturnJson();
        SysUserInfo u = sysService.checkSysUser(user);
        if (null != u) {
            rj.setSuccess(false);//已经被注册
        }else{
            rj.setSuccess(true);
        }
        return rj;
    }

    //调到注册页面
    @RequestMapping("register")
    public String register(){
        return "register";
    }



    @RequestMapping(value = "select",method = RequestMethod.GET)
    public String select(){
        return "selectList";
    }

}
