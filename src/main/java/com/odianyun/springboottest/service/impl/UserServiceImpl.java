package com.odianyun.springboottest.service.impl;

import com.odianyun.springboottest.mapper.UserMapper;
import com.odianyun.springboottest.model.po.UUser;
import com.odianyun.springboottest.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: EDZ
 * @time: 10:33
 * @date: 2021/7/11
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UUser getUserById(Long id) {
        UUser uUser = userMapper.getById(id);
        return uUser;
    }
}
