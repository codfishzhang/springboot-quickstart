package com.codfish.springbootquickstart.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys")
public class SysController {

    @GetMapping("/clearcache")
    public void clearCache() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
