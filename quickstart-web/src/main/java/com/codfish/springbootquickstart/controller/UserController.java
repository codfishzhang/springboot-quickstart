package com.codfish.springbootquickstart.controller;

import com.codfish.springbootquickstart.request.user.LoginReq;
import com.codfish.springbootquickstart.response.BaseResponse;
import com.codfish.springbootquickstart.response.user.LoginResp;
import com.codfish.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @org.springframework.web.bind.annotation.ResponseBody
    public BaseResponse<LoginResp> login(LoginReq request) {
        BaseResponse<LoginResp> response = userService.login(request);
        return response;
    }

    @GetMapping("/userlist")
    @org.springframework.web.bind.annotation.ResponseBody
    public BaseResponse<LoginResp> getUserList() {
        BaseResponse<LoginResp> response =
    }

}
