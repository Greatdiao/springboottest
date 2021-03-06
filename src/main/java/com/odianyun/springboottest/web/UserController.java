
package com.odianyun.springboottest.web;

import com.google.common.collect.Maps;
import com.odianyun.springboottest.model.dto.UserDTO;
import com.odianyun.springboottest.model.po.UUser;
import com.odianyun.springboottest.model.vo.UserVO;
import com.odianyun.springboottest.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: EDZ
 * @time: 21:38
 * @date: 2021/7/10
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Value("${request.url}")
    private String requestUrl;
    @Value("${request.appkey}")
    private String requestAppKey;
    @Value("${book.name}")
    private String bookName;

    @Resource
    private UserService userService;

    @GetMapping("/getById")
    public UUser getById(Long id) {
        UUser uUser = userService.getUserById(id);
        return uUser;
    }

    @GetMapping("/get")
    public UUser get(Long id) {
        UUser uUser = userService.get(id);
        return uUser;
    }

    @PostMapping("/getUser")
    public UserVO getUser() {
        UserVO userVO = new UserVO();
        userVO.setAge(25);
        userVO.setName("张三");
        return userVO;
    }

    @RequestMapping("/saveUser")
    public void saveUser(@Valid UserDTO user, BindingResult result) {
        System.out.println("user:"+user);
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                System.out.println(error.getCode()+ "-" + error.getDefaultMessage());
            }
        }
    }

    @GetMapping("/getRequestInfo")
    public Map getRequestInfo() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("requestUrl", requestUrl);
        map.put("requestAppKey", requestAppKey);
        return map;
    }

    @GetMapping("/getBookInfo")
    public Map getBookInfo() {
        Map<String, Object> map = Maps.newHashMap();
        map.put("bookName", bookName);
        return map;
    }

    @PostMapping("add")
    public UUser add(@RequestBody UserDTO dto){
        UUser user = userService.add(dto);
        return user;
    }

    @PostMapping("batchAdd")
    public UUser batchAdd(@RequestBody List<UserDTO> list){
        UUser user = userService.batchAdd(list);
        return user;
    }


    @PostMapping("list")
    public List<UUser> list(@RequestBody UserDTO dto){
        List<UUser> userList = userService.list(dto);
        return userList;
    }
}
