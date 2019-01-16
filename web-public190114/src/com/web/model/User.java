package com.web.model;

import java.util.Date;

import lombok.Data;

@Data
public class User {
	
	private Integer id;
	
	private String account;
	
	private String password;
	
	private String name;
	
	private Integer age;
	
	private Date birthday;
	
	private Integer status;
}
