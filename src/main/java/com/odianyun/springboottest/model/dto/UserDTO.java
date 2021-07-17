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

    private String mobile;
    private String password;

    private Long companyId = 21001L;

    private Integer pageNo;
    private Integer pageSize;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
