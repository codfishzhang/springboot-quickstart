package com.codfish.springbootquickstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.codfish.springbootquickstart.data.dao")
@ComponentScan(basePackages = {
        "com.codfish.springbootquickstart.service",
        "com.codfish.springbootquickstart.controller",
        "com.codfish.springbootquickstart.config",
        "com.codfish.springbootquickstart.shiro"
})
public class SpringbootQuickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootQuickstartApplication.class, args);
    }
}
