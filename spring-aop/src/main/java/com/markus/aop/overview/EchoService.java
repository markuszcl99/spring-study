package com.markus.aop.overview;

import com.markus.aop.overview.annotation.EchoInterface;

/**
 * @author: markus
 * @date: 2022/11/1 10:37 PM
 * @Description: 普通接口
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
//@EchoInterface // 用于pointcut @target @args使用
public interface EchoService {
    public String echo(String message);

    public String echoWithException(String message) throws NullPointerException;
}
