package com.codfish.springbootquickstart.common;

import com.codfish.springbootquickstart.common.utils.PasswordUtils;

public class PasswordTool {
    public static void main(String[] args) {
        System.out.println(new PasswordUtils().encryptPassword("admin", "admin123", "111111"));
    }
}
