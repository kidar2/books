package com.newbook.service;

import com.newbook.dao.UserDao;
import com.newbook.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{

	@Autowired
	public UserDao userDao;

	@Override
	public List<User> getUsers()
	{
		return userDao.getUsers();
	}

	@Override
	public int addUser(User user)
	{
		return userDao.addUser(user);
	}

	@Override
	public void removeUser(int id)
	{
		userDao.removeUser(id);
	}

	@Override
	public void updateUser(User user)
	{
		userDao.updateUser(user);
	}
}
