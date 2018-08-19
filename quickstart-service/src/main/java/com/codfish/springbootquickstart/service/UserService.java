package com.codfish.springbootquickstart.service;

import com.codfish.springbootquickstart.data.dao.SysUserMapper;
import com.codfish.springbootquickstart.data.model.SysUser;
import com.codfish.springbootquickstart.request.user.LoginReq;
import com.codfish.springbootquickstart.response.BaseResponse;
import com.codfish.springbootquickstart.response.user.LoginResp;
import com.codfish.springbootquickstart.response.user.UserListResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.async.WebAsyncManager;

@Service
public class UserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public BaseResponse<LoginResp> login(LoginReq request) {

//        账号密码为空
        if (StringUtils.isEmpty(request.getUsername()) || StringUtils.isEmpty(request.getPassword())) {
//            WebAsyncManager
        }
        return null;
    }

    public BaseResponse<UserListResp> getUserList() {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(1L);
        return null;
    }
}
