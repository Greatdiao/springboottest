package com.odianyun.springboottest.mapper;

import com.odianyun.springboottest.model.dto.UserDTO;
import com.odianyun.springboottest.model.po.UUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    UUser getById(Long id);

    @Select("select id, mobile, password, create_time from u_user where id = #{id}")
    UUser get(Long id);

    void add(UUser user);

    UUser batchAdd(List<UUser> poList);

    List<UUser> list(UserDTO dto);
}
