package com.example.user.repository;

import com.example.user.model.User;

public interface IUserRepository {

	public void insert(User s);

	public User update(User s);

	public User findById(long id);
}
