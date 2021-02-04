package com.project.service.dao;


public interface LoginDAO {

	boolean loginCheck(String id, String pw) throws Exception;
}
