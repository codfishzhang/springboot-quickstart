package com.codfish.springbootquickstart.controller;

import com.codfish.springbootquickstart.request.user.LoginReq;
import com.codfish.springbootquickstart.response.BaseResponse;
import com.codfish.springbootquickstart.response.user.LoginResp;
import com.codfish.springbootquickstart.response.user.UserListResp;
import com.codfish.springbootquickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public BaseResponse<LoginResp> login(LoginReq request) {
        BaseResponse<LoginResp> response = userService.login(request);
        return response;
    }

    @GetMapping("/userlist")
    @ResponseBody
    public BaseResponse<UserListResp> getUserList() {
        BaseResponse<UserListResp> response = userService.getUserList();
        return response;
    }

}
