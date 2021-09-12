package com.anitesh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anitesh.bean.UserAccount;
import com.anitesh.persistance.UserDao;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;

	@Override
	public UserAccount getUserByCredentials(UserAccount user) {
		
		return userDao.getUserByPassword(user.getEmail(), user.getPassword());
	}

}
