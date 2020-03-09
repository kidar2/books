package com.newbook.controller;

import com.newbook.entity.User;
import com.newbook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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


	@GetMapping("/hello")
	public String hello()
	{
		return "hello";
	}


	@GetMapping("/users")
	@ResponseBody
	public List<User> getUsers()
	{
		return userService.getUsers();
	}


	@GetMapping("/test")
	public User test()
	{
		return new User();
	}

}
