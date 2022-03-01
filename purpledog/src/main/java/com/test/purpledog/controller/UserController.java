package com.test.purpledog.controller;

import com.test.purpledog.dto.SignUpReq;
import com.test.purpledog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
