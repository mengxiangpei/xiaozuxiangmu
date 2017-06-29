package com.jk.controller;

import com.jk.pojo.SessionInfo;
import com.jk.pojo.SysUserInfo;
import com.jk.service.SysUserInfoService;
import com.jk.util.ConfigUtil;
import com.jk.util.MD5Util;
import com.jk.util.ReturnJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class LoginController {

	@Autowired
	private SysUserInfoService sysUserInfoService;

	/**
	 * 注销退出系统
	 * @param request
	 */
	@RequestMapping("logoutSysUser")
	@ResponseBody
	public void logoutSysUser(HttpServletRequest request){
		request.getSession().removeAttribute(ConfigUtil.getSessionInfoName());
	}
	
	
	/*//修改密码
	@RequestMapping(value="updateSysUserPwd",method=RequestMethod.POST)
	@ResponseBody
	public ReturnJson updateSysUserPwd(UserPwd userPwd,HttpServletRequest request){
		ReturnJson rj = new ReturnJson();
		//用户ID----session获取 ，隐藏域
		SessionInfo sessionInfo =  (SessionInfo) request.getSession().getAttribute(ConfigUtil.getSessionInfoName());
		String userId = sessionInfo.getUser().getId();
		//1.根据用户ID查询旧密码是否与数据库一致
		//如果session存放的用户对象中的密码是属性值为null
		SysUser u  = sysService.selectUserById(userId);
		//旧密码一致
		if (null != u && u.getPwd().equals(MD5Util.md5(userPwd.getOldPwd()))) {
			userPwd.setUserId(userId);
			sysService.updateUserPwdById(userPwd);
			rj.setSuccess(true);
			rj.setMsg("修改密码成功");
		} else {
			rj.setSuccess(false);
			rj.setMsg("旧密码错误，修改密码失败");
		}
		return rj;
	}*/
	
	/**
	 * 校验用户登录
	 * @return
	 */
	@RequestMapping(value="checkSysUserLogin",method=RequestMethod.POST)
	@ResponseBody
	public ReturnJson checkSysUserLogin(SysUserInfo user,HttpServletRequest request,Integer flag){
		ReturnJson rj = new ReturnJson();
		
		//获取session中的验证码
				String code = (String) request.getSession().getAttribute("imageCode");


				if (null !=flag && 1 !=flag) {
					//校验验证码是否正确
					if (null != user && !"".equals(user.getImgcode().trim()) && !"".equals(code)) {
						//验证码正确---不区分大小写
						if (user.getImgcode().trim().toUpperCase().equals(code.toUpperCase())) {
							userFeng(user,rj,request);
						}
					}
				} else {
					userFeng(user,rj,request);
				}
		return rj;
	}
	public void userFeng(SysUserInfo user,ReturnJson rj,HttpServletRequest request){
		//u 查询数据库的信息   
		//user 用户登录时表单
		SysUserInfo u = sysUserInfoService.checkSysUser(user);
		if (null != u) {//用户名正确
			if (u.getSysuserPwd().equals(MD5Util.md5(user.getSysuserPwd()))) {//密码正确
				rj.setSuccess(true);
				rj.setMsg("登录成功");
				//登录成功之后将用户信息存放到session中
				SessionInfo sessionInfo = new SessionInfo();
				//用户密码置 空
				u.setSysuserPwd(null);
			//	sessionInfo.setUser(u);
				sessionInfo.setUser(u);
				request.getSession().setAttribute(ConfigUtil.getSessionInfoName(),sessionInfo);
			} else {
				rj.setSuccess(false);
				rj.setMsg("密码错误");
			}
		} else {//用户名错误
				rj.setSuccess(false);
				rj.setMsg("用户名错误");
		}
	}
	
	
	
	/*//注册
	@RequestMapping(value="registerSysUser",method=RequestMethod.POST)
	@ResponseBody
	public ReturnJson registerSysUser(SysUser user,HttpServletRequest request){
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
	*/
	
	//校验用户---账户名称是否已存在
	/*@RequestMapping(value="checkSysUser",method=RequestMethod.POST)
	@ResponseBody
	public ReturnJson checkSysUser(SysUser user){
		ReturnJson rj = new ReturnJson();
	    SysUser u = sysService.checkSysUser(user);
	    if (null != u) {
			rj.setSuccess(false);//已经被注册
		}else{
			rj.setSuccess(true);
		}
		return rj;
	}*/
	
	
	/*//调到注册页面
	@RequestMapping("register")
	public String register(){
		return "sys/register";
	}

	//调到登录页面
	@RequestMapping("login")
	public String login(){
		return "sys/login";
	}
*/



	/**
	 * @param /page  当前页
	 * @param /rows  每页条数
	 * @return 分页user信息
	 *//*
	@RequestMapping("selectUserList")
	@ResponseBody
	public Map<String,Object> selectUserList(Integer page,Integer rows,PageUtil<SysUser> userPage){
		
*//*		PageUtil<User> userPage = new PageUtil<>();*//*
		userPage.setCpage(page);
		userPage.setPageSize(rows);
		//查询条件---map
		System.out.println(userPage.getWhereMap());
		//分页查询
		userPage = sysService.selectUserList(userPage);
		
		//封装到map 设置easyui的datagrid组件识别的json字符串
		Map<String,Object> map = new HashMap<>();
		map.put("total", userPage.getTotalCount());
		map.put("rows", userPage.getList());
		
		return map;
	}
	*/

	@RequestMapping("toUserList")
	public String toUserList(){
		return "user/userList";
	}
	
}
