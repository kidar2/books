package com.newbook.controller;

import com.newbook.entity.Kuku;
import com.newbook.entity.User;
import com.newbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController
{
	@Autowired
	public UserService userService;


	@GetMapping("/")
	public String index()
	{
		return "index";
	}


	@GetMapping("/users")
	@ResponseBody
	public List<User> getUsers()
	{
		new Kuku().test();
		return userService.getUsers();
	}


	@PostMapping("/users")
	@ResponseStatus(HttpStatus.CREATED)
	public void addUser(@RequestBody User user)
	{
		userService.addUser(user);
	}

	@PostMapping("/users/{userId}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void updateUser(@PathVariable Integer userId, @RequestBody User user)
	{
		user.setId(userId);
		userService.updateUser(user);
	}

	@DeleteMapping("/users/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteUser(@PathVariable Integer userId)
	{
		userService.removeUser(userId);
	}
}
