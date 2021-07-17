package com.odianyun.springboottest.test;

import com.alibaba.fastjson.JSONObject;
import com.odianyun.springboottest.model.po.UUser;
import com.odianyun.springboottest.startup.Application;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: EDZ
 * @time: 11:05
 * @date: 2021/7/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {

    @Resource
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void testString() {
        String key = "username:1";
        ValueOperations<String, Serializable> operations = redisTemplate.opsForValue();
        operations.set(key, "diaoxingguo");
        operations.set(key, "diaoxingguo123");
        String value = (String) operations.get(key);

        System.out.println("value = " + value);
    }

    @Test
    public void testObj() throws InterruptedException {
        String key = "user:1";
        UUser user = new UUser();
        user.setId(1L);
        user.setMobile("13127787865");
        user.setPassword("123456");
        ValueOperations<String, Serializable> operations = redisTemplate.opsForValue();
//        operations.set(key, user);
        operations.set(key, user, 2, TimeUnit.SECONDS);
        UUser userValue = (UUser) operations.get(key);
        System.out.println("key = " + redisTemplate.hasKey(key));
        System.out.println("value = " + JSONObject.toJSONString(userValue));

        Thread.sleep(2500);
        UUser userValue2 = (UUser) operations.get(key);

        System.out.println("key = " + redisTemplate.hasKey(key));
        System.out.println("value = " + JSONObject.toJSONString(userValue2));
    }

    @Test
    public void testDelete() {
        String key = "user:1";
        UUser user = new UUser();
        user.setId(1L);
        user.setMobile("13127787865");
        user.setPassword("123456");
        ValueOperations<String, Serializable> operations = redisTemplate.opsForValue();
        operations.set(key, user);
        UUser userValue = (UUser) operations.get(key);
        System.out.println("key = " + redisTemplate.hasKey(key));
        System.out.println("value = " + JSONObject.toJSONString(userValue));

        redisTemplate.delete(key);

        System.out.println("key = " + redisTemplate.hasKey(key));
    }

    @Test
    public void testHash() throws InterruptedException {
        String key = "so:1";
        HashOperations<String, String, Object> operations = redisTemplate.opsForHash();

        operations.put(key, "orderCode", "1");
        operations.put(key, "userId", "2");
        String orderCode = (String) operations.get(key, "orderCode");
        Map<String, Object> map = operations.entries(key);

        System.out.println("orderCode = " + orderCode);
        System.out.println("map = " + JSONObject.toJSONString(map));
        redisTemplate.expire(key, 1, TimeUnit.SECONDS);
        Thread.sleep(1500);

        List<Object> list = operations.multiGet(key, Lists.newArrayList("orderCode", "userId"));

//        operations.hasKey(key, "orderCode");
        System.out.println("list = " + JSONObject.toJSONString(list));
    }

    @Test
    public void testSet() {
        String key = "so:item:1";
        SetOperations<String, Serializable> set = redisTemplate.opsForSet();
        set.add(key, "123");
        set.add(key, "123");
        set.add(key, "124");
        set.add(key, "125");

//        Set<Serializable> values = set.members(key);
//        values.forEach(System.out::println);
//        System.out.println(set.isMember(key, "123"));
//        set.remove(key, "123");
//        System.out.println(set.isMember(key, "123"));

        String key1 = "so:item:2";
        set.add(key1, "124");
        set.add(key1, "125");
        set.add(key1, "126");
        set.add(key1, "127");

//        Set<Serializable> difference = set.difference(key, key1);
        String key2 = "so:item:3";
        set.differenceAndStore(key, key1, key2);

//        difference.forEach(System.out::println);
        set.members(key2).forEach(System.out::println);
    }

    @Test
    public void testList() {
        ListOperations<String, Serializable> operations = redisTemplate.opsForList();
        String key = "user:fans:1";
        operations.leftPushAll(key, Lists.newArrayList("diaoxingguo", "xingguodiao"));
        operations.leftPush(key, "xingguo");
        operations.rightPush(key, "xingguo123");
        operations.range(key, 0, -1).forEach(System.out::println);
    }

    @Test
    public void testZSet(){
        ZSetOperations<String, Serializable> zset = redisTemplate.opsForZSet();
        String key = "user:like:1";
        zset.add(key, "xingguo", 1);
        zset.add(key, "diaoxingguo", 3);
        zset.add(key, "xingguodiao", 2);
        zset.add(key, "xingguodiao111", 4);

//        Set<Serializable> values = zset.range(key, 0,-1);
//        values.forEach(System.out::println);
//        Set<Serializable> valueScores = zset.rangeByScore(key, 0,3);
        Set<Serializable> valueScores = zset.reverseRangeByScore(key, 0,3);
        valueScores.forEach(System.out::println);
    }
}
