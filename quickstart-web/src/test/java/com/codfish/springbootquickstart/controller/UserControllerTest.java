package com.codfish.springbootquickstart.controller;

import com.codfish.springbootquickstart.SpringbootQuickstartApplication;
import com.codfish.springbootquickstart.request.user.LoginReq;
import com.codfish.springbootquickstart.response.BaseResponse;
import com.codfish.springbootquickstart.response.user.LoginResp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootQuickstartApplication.class)
public class UserControllerTest {

    @Test
    public void login() {
        String username = "admin";
        String password = "admin123";

        LoginReq request = new LoginReq();
        request.setUsername(username);
        request.setPassword(password);

    }

    @Test
    public void getUserList() {
    }
}