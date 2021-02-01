package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/add")
    List<User> insertUser() {
        return userService.insertService();
    }
    @RequestMapping("/query")
    User testQuery() {
        return userService.selectUserByName("SnailClimb");
    }
    @RequestMapping("/queryAll")
    public List<User> selectAllUsers() {
        return userService.selectAllUser();
    }

    @RequestMapping("/changeover")
    public List<User> testChangeMoney() {
        userService.changemoney();
        return userService.selectAllUser();
    }

    @RequestMapping("/delete")
    public String testDelete() {
        userService.deleteService(3);
        return "OK";
    }
}
