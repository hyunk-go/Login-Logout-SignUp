package com.example.login.dao;

public interface LoginDao {

	public void signUp(String id,String pw);
	boolean idCheck(String id);
	String pwCheck(String id);
}
