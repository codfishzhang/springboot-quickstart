package com.codfish.springbootquickstart.service;

import com.codfish.springbootquickstart.request.user.LoginReq;
import com.codfish.springbootquickstart.response.BaseResponse;
import com.codfish.springbootquickstart.response.user.LoginResp;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public BaseResponse<LoginResp> login(LoginReq request) {

        return null;
    }
}
