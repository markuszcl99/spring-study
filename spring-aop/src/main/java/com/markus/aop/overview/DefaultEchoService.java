package com.markus.aop.overview;

/**
 * @author: markus
 * @date: 2022/11/1 10:38 PM
 * @Description: 默认实现
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class DefaultEchoService implements EchoService {
    @Override
    public String echo(String message) {
        String result = "[echo] " + message;
        System.out.println(result);
        return result;
    }

    @Override
    public String echoWithException(String message) throws NullPointerException {
        return null;
    }
}
