package com.markus.aop;

/**
 * @author: markus
 * @date: 2022/10/12 12:13 AM
 * @Description: 默认实现
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class DefaultEchoService implements EchoService {
    @Override
    public String echo(String message) {
        System.out.println("Target Method...");
        return "【echo】" + message;
    }
}
