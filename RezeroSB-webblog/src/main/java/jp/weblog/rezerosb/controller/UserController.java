package jp.weblog.rezerosb.controller;

import jp.weblog.rezerosb.model.Result;
import jp.weblog.rezerosb.model.User;
import jp.weblog.rezerosb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(String username, String password) {
        User u = userService.findByUserName(username);
        if (u == null){
            userService.register(username,password);
            return Result.success();
        }else{
            return Result.error("既に存在する。");
        }
    }
}
