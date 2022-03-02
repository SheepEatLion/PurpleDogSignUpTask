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

    @GetMapping("/user")
    public List<User> users(){
        return userService.findUsers();
    }
}
