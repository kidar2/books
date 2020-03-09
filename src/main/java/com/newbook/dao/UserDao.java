package com.newbook.dao;

import com.newbook.entity.User;

import java.util.List;

public interface UserDao
{
	List<User> getUsers();

	int addUser(User user);

	void removeUser(int id);

	void updateUser(User user);
}
