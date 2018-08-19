package com.codfish.springbootquickstart.common.exception.user;

import com.codfish.springbootquickstart.common.exception.BaseException;

public class UserException extends BaseException {


    private static final long serialVersionUID = 8354443781352538518L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }
}
