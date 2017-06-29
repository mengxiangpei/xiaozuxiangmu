package com.jk.pojo;


/**
 * sessionInfo只要登录成功，就需要设置到session里面，便于系统使用
 * 
 */
public class SessionInfo implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7145049418287239762L;
	
	private SysUserInfo user;

	public SysUserInfo getUser() {
		return user;
	}

	public void setUser(SysUserInfo user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "SessionInfo{" +
				"user=" + user +
				'}';
	}
}
