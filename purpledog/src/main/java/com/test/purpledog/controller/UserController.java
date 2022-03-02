package com.test.purpledog.controller;

import com.test.purpledog.domain.User;
import com.test.purpledog.dto.SignUpReq;
import com.test.purpledog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/purple-dog/api")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public String signUp(@RequestBody SignUpReq signUpReq){
        String resultMsg;
        resultMsg = userService.signUp(signUpReq);

        return resultMsg;
    }

    @GetMapping("/users")
    public List<User> users(){
        return userService.findUsers();
    }

    @GetMapping("/user/{id}")
    public User userById(@PathVariable String id){
        return userService.findUserById(id);
    }

    @PostMapping("/pwd-change")
    public User changePwd(@RequestBody String id, @RequestBody String password){
        return userService.changePwd(id, password);
    }
}
