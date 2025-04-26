package com.rezerosb.controller;

import com.rezerosb.rezerosb05mybatis.entity.User;
import com.rezerosb.rezerosb05mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findById")
    public User findById(Integer id){
        return  userService.findById(id);
    }
}
