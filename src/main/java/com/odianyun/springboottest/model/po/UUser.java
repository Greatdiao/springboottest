package com.odianyun.springboottest.model.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: EDZ
 * @time: 10:27
 * @date: 2021/7/11
 */
public class UUser implements Serializable {
    private static final long serialVersionUID = 98347249293814324L;
    private Long id;
    private String mobile;
    private String password;

    private Date createTime;

    private Long companyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}
