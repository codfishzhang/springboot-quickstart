package com.codfish.springbootquickstart.service;

import com.codfish.springbootquickstart.common.exception.user.UserException;
import com.codfish.springbootquickstart.common.utils.PasswordUtils;
import com.codfish.springbootquickstart.data.dao.SysUserMapper;
import com.codfish.springbootquickstart.data.model.SysUser;
import com.codfish.springbootquickstart.data.model.SysUserExample;
import com.codfish.springbootquickstart.request.user.LoginReq;
import com.codfish.springbootquickstart.response.BaseResponse;
import com.codfish.springbootquickstart.response.user.LoginResp;
import com.codfish.springbootquickstart.response.user.UserListResp;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SysUserMapper sysUserMapper;

    public BaseResponse login(LoginReq request) {
        UsernamePasswordToken token = new UsernamePasswordToken(request.getUsername(), request.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return new BaseResponse().success(null);
        } catch (AuthenticationException e) {
            return new BaseResponse().error(-1, e.getMessage());
        }
    }

    // shiro UserRealm使用
    public SysUser login(String username, String password) {

//        账号密码为空
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new UserException("用户名或密码为空", null);
        }
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.or().andUsernameEqualTo(username);
        List<SysUser> sysUserList = sysUserMapper.selectByExample(sysUserExample);

//        用户不存在
        if (sysUserList == null || sysUserList.size() == 0) {
            throw new UserException("用户不存在", null);
        } else {
//            密码验证通过
            SysUser sysUser = sysUserList.get(0);
            if (PasswordUtils.validate(sysUser, password)) {
                if (sysUser.getIsLocked() == true) {
                    throw new UserException("用户被锁定，请联系管理员", null);
                } else {
                    return sysUser;
                }
            } else {
                throw new UserException("密码验证失败", null);
            }
        }
    }

    public BaseResponse<UserListResp> getUserList() {
        SysUser sysUser = sysUserMapper.selectByPrimaryKey(1L);
        return null;
    }
}
