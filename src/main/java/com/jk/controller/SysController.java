package com.jk.controller;

import com.jk.pojo.SessionInfo;
import com.jk.pojo.Tree;
import com.jk.pojo.UserInfo;
import com.jk.service.SyResourceService;
import com.jk.service.SysService;
import com.jk.util.ConfigUtil;
import com.jk.util.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "select",method = RequestMethod.GET)
    public String select(){
        return "selectList";
    }

}
