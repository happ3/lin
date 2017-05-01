package com.ssm.dao.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.mapper.UserMapper;
import com.ssm.repository.User;

@Service
public class UserService implements IUserService{

	@Resource
	private UserMapper userMapper;

	@Override
	public User getUserById(int userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	
}
