package com.codfish.springbootquickstart.controller;

import com.codfish.springbootquickstart.request.user.LoginReq;
import com.codfish.springbootquickstart.response.BaseResponse;
import com.codfish.springbootquickstart.response.user.UserListResp;
import com.codfish.springbootquickstart.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    public BaseResponse login(LoginReq request) {
        UsernamePasswordToken token = new UsernamePasswordToken(request.getUsername(), request.getPassword());
        Subject subject = SecurityUtils.getSubject();
        BaseResponse response = new BaseResponse();

        try {
            subject.login(token);
            response.success(null, "登录成功");
        } catch (AuthenticationException e) {
            response.error(-1, e.getMessage());
        }
        return response;
    }

    @GetMapping("/userlist")
    @ResponseBody
    public BaseResponse<UserListResp> getUserList() {
        BaseResponse<UserListResp> response = userService.getUserList();
        return response;
    }

}
