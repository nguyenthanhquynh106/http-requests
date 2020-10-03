package com.example.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.user.model.User;
import com.example.user.repository.IUserRepository;
import com.example.user.service.IUserService;

@Service
public class UserService implements IUserService {

	private IUserRepository userRepository;

	@Autowired
	public UserService(IUserRepository studentRepositoryJPA) {
		this.userRepository = studentRepositoryJPA;
	}

	@Override
	@Transactional
	public void insert(User s) {
		userRepository.insert(s);
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id);
	}

}
