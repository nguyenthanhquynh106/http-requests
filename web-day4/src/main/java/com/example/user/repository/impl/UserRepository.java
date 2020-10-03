package com.example.user.repository.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.user.model.User;
import com.example.user.repository.IUserRepository;

@Repository
public class UserRepository implements IUserRepository {

	private EntityManager em;

	@Autowired
	public UserRepository(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insert(User s) {
		em.persist(s);
	}

	@Override
	public User update(User s) {
		return em.merge(s);
	}

	@Override
	public User findById(long id) {
		return em.find(User.class, id);
	}

}
