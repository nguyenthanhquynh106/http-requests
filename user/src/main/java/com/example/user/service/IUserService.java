package com.example.user.service;

import com.example.user.model.User;

public interface IUserService {

	public void insert(User s);
	
	public User findById(Long id);

}
