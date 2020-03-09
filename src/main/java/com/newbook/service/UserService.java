package com.newbook.service;

import com.newbook.entity.User;

import java.util.List;

public interface UserService
{
	List<User> getUsers();

	int addUser(User user);

	void removeUser(int id);

	void updateUser(User user);

}
