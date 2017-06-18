package com.oms.dao;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import com.oms.entity.Role;

public class UserDetailsDao {
	
	@NotNull
	@Size(min=3, max=15, message="{nameSizeError}")
	private String name;
	
	@NotNull
	@Size(min=1, max=255, message="Please add some more characters")
	@Pattern(regexp="[A-Za-z0-9._%-+]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}", message="{emailPatternError}")
	private String email;
	
	@NotNull
	@Size(min=1, max=30)
	private String password;
	
	@NotNull
	@Size(min=1, max=30, message="{role not selected}")
	private String roles;
	
	@NotNull
	MultipartFile file;
	
	@NotNull
	@Size(min=1, max=1, message="{invalid}")
	@Pattern(regexp="^(?!^(?:M|F|M/F)$).*$")
	String sex;
	
	@NotNull
	@Size(min=1, max=20, message="{invalid}")
	String country;
	
	@NotNull
	Integer ph;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Integer getPh() {
		return ph;
	}
	public void setPh(Integer ph) {
		this.ph = ph;
	}
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	

}
