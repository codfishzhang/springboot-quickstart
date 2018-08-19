package com.codfish.springbootquickstart.config;

import com.codfish.springbootquickstart.shiro.realm.UserRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    /**
     * 缓存管理器 使用Ehcache实现
     */
    @Bean
    public EhCacheManager getEhCacheManager()
    {
        net.sf.ehcache.CacheManager cacheManager = net.sf.ehcache.CacheManager.getCacheManager("hrms");
        EhCacheManager ehCacheManager = new EhCacheManager();
        if (cacheManager == null)
        {
            ehCacheManager.setCacheManagerConfigFile("classpath:ehcache/ehcache-shiro.xml");
            return ehCacheManager;
        }
        else
        {
            ehCacheManager.setCacheManager(cacheManager);
            return ehCacheManager;
        }
    }

    /**
     * 自定义Realm
     */
    @Bean
    public UserRealm userRealm(EhCacheManager cacheManager)
    {
        UserRealm userRealm = new UserRealm();
        userRealm.setCacheManager(cacheManager);
        return userRealm;
    }
}
