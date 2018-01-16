package com.love.marriage.aspect;

import com.love.marriage.constant.CookieConstant;
import com.love.marriage.constant.RedisConstant;
import com.love.marriage.exception.UserAuthorizeException;
import com.love.marriage.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Crete by Marlon
 * Create Date: 1/16/2018
 * Class Describe
 * Authorize 认证  奠定了后台系统的开发
 **/

@Aspect
@Slf4j
@Component
public class UserAuthorizeAspect {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Pointcut("execution( public * com.love.marriage.controller.User*.*(..))" + "&& !execution(public * com.love.marriage.controller..*(..))")
    public void verify() {

    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("【登录校验】 Cookie中查询不到token");
            throw new UserAuthorizeException();
        }
        //去redis里边查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录校验】 Redis里边查询不到token");
            throw new UserAuthorizeException();
        }
    }


}
