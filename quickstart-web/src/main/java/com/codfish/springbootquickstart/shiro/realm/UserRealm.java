package com.codfish.springbootquickstart.shiro.realm;

import com.codfish.springbootquickstart.request.user.LoginReq;
import com.codfish.springbootquickstart.response.BaseResponse;
import com.codfish.springbootquickstart.response.user.LoginResp;
import com.codfish.springbootquickstart.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /*授权*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /*登录认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String password = "";
        if (usernamePasswordToken.getPassword() != null) {
            password = new String(usernamePasswordToken.getPassword());
        }

        LoginReq loginReq = new LoginReq();
        loginReq.setUsername(username);
        loginReq.setPassword(password);
        BaseResponse<LoginResp> loginRespBaseResponse = userService.login(loginReq);


        return null;
    }
}
