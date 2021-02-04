package com.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.service.LoginService;
import com.project.service.dao.LoginDAO;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDAO loginMapper;

	@Override
	public boolean loginCheck(String id, String pw) throws Exception {
		// TODO Auto-generated method stub
		return loginMapper.loginCheck(id, pw);

	}

}
