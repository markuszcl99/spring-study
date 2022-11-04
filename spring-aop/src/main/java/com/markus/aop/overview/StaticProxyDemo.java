package com.markus.aop.overview;

/**
 * @author: markus
 * @date: 2022/11/1 10:42 PM
 * @Description: 静态代理示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class StaticProxyDemo {
    public static void main(String[] args) {
        EchoService echoService = new ProxyEchoService(new DefaultEchoService());
        echoService.echo("Hello World!");
    }
}
