package com.odianyun.springboottest.mapper;

import com.odianyun.springboottest.model.po.UUser;

public interface UserMapper {
    UUser getById(Long id);
}
