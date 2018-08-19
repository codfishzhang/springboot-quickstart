package com.codfish.springbootquickstart.common.utils;

import com.codfish.springbootquickstart.data.model.SysUser;
import org.apache.shiro.crypto.hash.Md5Hash;

public class PasswordUtils {

    public static String encryptPassword(String username, String password, String salt) {
        return new Md5Hash(username + password + salt).toHex().toString();
    }

    public static boolean validate(SysUser sysUser, String password) {
        return sysUser.getPassword().equals(encryptPassword(sysUser.getUsername(), password, sysUser.getSalt()));
    }
}
