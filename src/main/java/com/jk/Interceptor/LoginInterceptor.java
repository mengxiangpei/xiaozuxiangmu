package com.jk.Interceptor;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jk.pojo.SessionInfo;
import com.jk.util.ConfigUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	
    private List<String> excludeUrls;
    
    
	
	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
        System.err.println("LoginInterceptor登录拦截器-------preHandle()执行");
		
		System.err.println("LoginInterceptor登录拦截器-------preHandle()执行时间"+new Date());
		
		System.err.println( "当前请求的URI ----- " + request.getRequestURI());
	
		       //web项目访问路径
				String  xiangmuUrl = request.getContextPath();  //  /ssi-mv-easyui
				
				//前台浏览器请求的URI路径
				String URI =  request.getRequestURI();  // /ssi-mv-easyui/user/checkSysUserLogin.action
				
				//将  项目的访问路径 去除截去掉
				String url = URI.substring(xiangmuUrl.length());  //  /user/checkSysUserLogin.action
				
				SessionInfo sessionInfo = 	(SessionInfo) request.getSession().getAttribute(ConfigUtil.getSessionInfoName());
				if (null != sessionInfo  && null != sessionInfo.getUser()) {
					return true;
				}else if (null != request.getRequestURI() &&  excludeUrls.contains(url) ) { // excludeUrls.contains() 判断集合是否包含该元素
					return true; //放过 用户注册，用户登录，是否重名等 不需要拦截的请求
				}
				else{
					response.sendRedirect(request.getContextPath()+"/index.jsp");
                  //request.getRequestDispatcher("").forward(request, response);
					return false;	
				}
	}

	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.err.println("LoginInterceptor登录拦截器-------afterCompletion()执行");
		System.err.println("LoginInterceptor登录拦截器-------afterCompletion()执行时间"+new Date());
	}


}
