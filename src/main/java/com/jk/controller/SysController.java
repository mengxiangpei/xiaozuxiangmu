package com.jk.controller;

<<<<<<< HEAD
import com.jk.pojo.SessionInfo;
import com.jk.pojo.Tree;
import com.jk.pojo.UserInfo;
import com.jk.service.SyResourceService;
import com.jk.service.SysService;
import com.jk.util.ConfigUtil;
=======
import com.jk.pojo.SysUserInfo;
import com.jk.pojo.UserInfo;
import com.jk.service.SysService;
>>>>>>> db0e8d3b1823e3a6e9a39745ad16cad78118b1a7
import com.jk.util.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
<<<<<<< HEAD
=======

import javax.servlet.http.HttpServletRequest;
import java.util.List;
>>>>>>> db0e8d3b1823e3a6e9a39745ad16cad78118b1a7

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
/**
 * Created by 高启友 on 2017/6/29.
 * 2017
 * 六月
 */

@RequestMapping("sys")
@Controller
public class SysController {

    @Autowired
    private SysService sysService;

    @Autowired
    private SyResourceService syResourceService;

    /**
     * 左侧导航树
     * @param request
     * @return
     */
    @RequestMapping("selectMainMenu")
    @ResponseBody
    public List<Tree> selectMainMenu(HttpServletRequest request) {

      //  SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(ConfigUtil.getSessionInfoName());

       // String userId = sessionInfo.getUser().getId();
        String userId ="1b73981e-14b0-4398-beb2-c814930416f8";
        List<Tree> treeList = syResourceService.selectMainMenu(userId);
        return treeList;
    }
    //新增方法
    @RequestMapping(value = "seaveUserInfo",method=RequestMethod.POST)
    @ResponseBody
    public ReturnJson seaveUserInfo(UserInfo userInfo){
        ReturnJson rh= new ReturnJson();
        userInfo.setUserTime(new Date());
        int it=syResourceService.insertSelective(userInfo);
        System.out.print(userInfo.getUserId());
        if (it==1){
            rh.setMsg("新增成功");
            rh.setSuccess(true);
        }else {
            rh.setMsg("失败了哈哈哈");
            rh.setSuccess(false);
        }
        return rh;
    }

    //跳转新增页面
    @RequestMapping("addUser")
    public String addUser(){
        return "addUser";
    }


//   角色查询
     @RequestMapping("selectUserList")
    @ResponseBody
    public List<UserInfo> selectUserList(){

        List userPage = sysService.selectUserList();

        return userPage;
    }





   //页面跳转




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
