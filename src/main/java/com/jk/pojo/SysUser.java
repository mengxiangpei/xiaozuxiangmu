package com.jk.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

public class SysUser implements Serializable{

	private static final long serialVersionUID = 2699152550900175937L;
	
	private String id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdatetime;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedatetime;
	private String loginname;
	private String pwd;
	private String name;
	private Integer sex;
	private Integer age;
	private String photo;
	
	// 此属性是业务字段不存数据库，虚拟属性
	private String ip;
	//验证码
	private String imgcode;
	//拥有的角色id字符串
	private String roleIds;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
	public Date getUpdatedatetime() {
		return updatedatetime;
	}
	public void setUpdatedatetime(Date updatedatetime) {
		this.updatedatetime = updatedatetime;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getImgcode() {
		return imgcode;
	}
	public void setImgcode(String imgcode) {
		this.imgcode = imgcode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	
	

}
