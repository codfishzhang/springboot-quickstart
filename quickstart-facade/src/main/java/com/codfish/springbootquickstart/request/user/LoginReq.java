package com.codfish.springbootquickstart.request.user;

import com.codfish.springbootquickstart.message.RespConstant;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class LoginReq implements Serializable {
    private static final long serialVersionUID = -874890352564869108L;

    @NotBlank(message = RespConstant.RESP_REGEX_USERNAME_BLANK)
    private String username;

    @NotBlank(message = RespConstant.RESP_REGEX_PASSWORD_BLANK)
    private String password;
}
