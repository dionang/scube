package com.object;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

public class AccountDetail implements Serializable {
	private int accountId;
	private String username;
	private String password;
	private int companyId;
	private String accountType;
	private String name;
	
//	public AccountDetail(int accountId, int companyId, String accountType, String name) {
//		this.accountId = accountId;
//		this.companyId = companyId;
//		this.accountType = accountType;
//		this.name = name;
//	}
	
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
