package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.CreateUserRequest;
import com.example.user.model.User;
import com.example.user.model.UpdateUserRequest;
import com.example.user.service.IUserService;


@RestController
@RequestMapping("/users")
public class UserController {

	private IUserService userService;

	@Autowired
	public UserController(IUserService studentService) {
		this.userService = studentService;
	}

	@GetMapping("/inser/name/{name}/age/{age}")
	public User insertUser1(@PathVariable String name, @PathVariable int age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		userService.insert(user);
		return user;
	}

	@GetMapping("/{userId}")
	public User findById(@PathVariable Long userId) {
		return userService.findById(userId);
	}

	@GetMapping("/insert")
	public User insertUser2(@RequestParam String name, @RequestParam int age) {
		User user = new User();
		user.setName(name);
		user.setAge(age);
		userService.insert(user);
		return user;
	}

	@PostMapping("/string")
	public String string(@RequestBody String s) {
		return String.format("String body is: %s", s);
	}

	@PostMapping("/person")
	public String postPerson(@RequestBody CreateUserRequest restPerson) {
		return String.format("Person name is: %s\nPerson age is: %d", restPerson.getName(), restPerson.getAge());
	}
	
	@PutMapping("/{userId}")
	public String update(@PathVariable Long userId, @RequestBody UpdateUserRequest restBody) {
		return String.format("Update student has id: %s with new add: %s success", userId, restBody.getAddress());
		
	}
	
	@DeleteMapping
	public String delete(@RequestBody List<Long> ids) {
		return String.format("Delete students with id in %s success", ids.toString());
	}
}



















