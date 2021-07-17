package com.odianyun.springboottest.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.odianyun.springboottest.mapper.UserMapper;
import com.odianyun.springboottest.model.dto.UserDTO;
import com.odianyun.springboottest.model.po.UUser;
import com.odianyun.springboottest.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public UUser get(Long id) {
        UUser uUser = userMapper.get(id);
        return uUser;
    }

    @Override
    public UUser add(UserDTO dto) {
        UUser user = new UUser();
        user.setMobile(dto.getMobile());
        user.setPassword(dto.getPassword());
        user.setCompanyId(dto.getCompanyId());
        userMapper.add(user);
        return user;
    }

    @Override
    public UUser batchAdd(List<UserDTO> list) {
        List<UUser> poList = Lists.newArrayList();
        BeanUtils.copyProperties(list, poList);
        return userMapper.batchAdd(poList);
    }

    @Override
    public List<UUser> list(UserDTO dto) {
        PageHelper.startPage(dto.getPageNo(), dto.getPageSize());
        List<UUser> list = userMapper.list(dto);

        System.out.println("返回的总数：" + ((Page)list).getTotal());

        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);
        System.out.println("page.getPageNum = " + page.getPageNum());
        System.out.println("page.getPageSize = " + page.getPageSize());
        System.out.println("page.getStartRow = " + page.getStartRow());
        System.out.println("page.getEndRow = " + page.getEndRow());
        System.out.println("page.getTotal = " + page.getTotal());
        System.out.println("page.getPages = " + page.getPages());
        System.out.println("page.isHasPreviousPage = " + page.isHasPreviousPage());
        System.out.println("page.isHasNextPage = " + page.isHasNextPage());

        return list;
    }
}
