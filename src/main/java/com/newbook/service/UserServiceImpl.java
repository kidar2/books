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
}
