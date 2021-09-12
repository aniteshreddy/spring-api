package com.anitesh.service;

import com.anitesh.bean.UserAccount;

public interface UserService {
	public UserAccount getUserByCredentials(UserAccount user);
}
