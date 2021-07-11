package com.odianyun.springboottest.model.dto;

import javax.validation.constraints.NotEmpty;

/**
 * @description:
 * @author: EDZ
 * @time: 21:58
 * @date: 2021/7/10
 */
public class UserDTO {
    @NotEmpty(message = "姓名不能为空")
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
