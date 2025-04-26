package com.rezerosb.rezerosb05mybatis.service.impl;

import com.rezerosb.rezerosb05mybatis.entity.User;
import com.rezerosb.rezerosb05mybatis.mapper.UserMapper;
import com.rezerosb.rezerosb05mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}
