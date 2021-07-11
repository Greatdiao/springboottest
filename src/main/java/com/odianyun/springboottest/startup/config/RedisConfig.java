package com.odianyun.springboottest.startup.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: EDZ
 * @time: 12:11
 * @date: 2021/7/11
 */
@Component
@PropertySource("classpath:redis.properties")
@ConfigurationProperties("redis")
public class RedisConfig {
    private String ip;
    private Integer port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
