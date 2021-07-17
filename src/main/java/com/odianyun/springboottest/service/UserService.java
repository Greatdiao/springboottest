package com.odianyun.springboottest.service;

import com.odianyun.springboottest.model.dto.UserDTO;
import com.odianyun.springboottest.model.po.UUser;

import java.util.List;

public interface UserService {
    UUser getUserById(Long id);
    UUser get(Long id);

    UUser add(UserDTO dto);

    UUser batchAdd(List<UserDTO> list);

    List<UUser> list(UserDTO dto);
}
