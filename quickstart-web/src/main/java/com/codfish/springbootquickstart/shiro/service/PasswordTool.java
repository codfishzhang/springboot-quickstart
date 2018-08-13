package com.codfish.springbootquickstart.shiro.service;

import com.codfish.springbootquickstart.data.model.SysUser;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 登录密码方法
 * 
 * @author ruoyi
 */
@Component
public class PasswordTool
{

    @Autowired
    private CacheManager cacheManager;

    private Cache<String, AtomicInteger> loginRecordCache;

    @PostConstruct
    public void init()
    {
        loginRecordCache = cacheManager.getCache("loginRecordCache");
    }

    public void validate(SysUser user, String password)
    {
        String loginName = user.getUsername();

        AtomicInteger retryCount = loginRecordCache.get(loginName);

//        if (retryCount == null)
//        {
//            retryCount = new AtomicInteger(0);
//            loginRecordCache.put(loginName, retryCount);
//        }
//        if (retryCount.incrementAndGet() > Integer.valueOf(maxRetryCount).intValue())
//        {
//            SystemLogUtils.log(loginName, Constants.LOGIN_FAIL, MessageUtils.message("user.password.retry.limit.exceed", maxRetryCount));
//            throw new UserPasswordRetryLimitExceedException(Integer.valueOf(maxRetryCount).intValue());
//        }
//
//        if (!matches(user, password))
//        {
//            SystemLogUtils.log(loginName, Constants.LOGIN_FAIL, MessageUtils.message("user.password.retry.limit.count", retryCount, password));
//            loginRecordCache.put(loginName, retryCount);
//            throw new UserPasswordNotMatchException();
//        }
//        else
//        {
//            clearLoginRecordCache(loginName);
//        }
    }

    public boolean matches(SysUser user, String newPassword)
    {
        return user.getPassword().equals(encryptPassword(user.getUsername(), newPassword, user.getSalt()));
    }

    public void clearLoginRecordCache(String username)
    {
        loginRecordCache.remove(username);
    }

    public String encryptPassword(String username, String password, String salt)
    {
        return new Md5Hash(username + password + salt).toHex().toString();
    }

    public static void main(String[] args)
    {
        System.out.println(new PasswordTool().encryptPassword("admin", "admin123", "111111"));
    }
}
