package com.markus.aop;

import com.markus.aop.overview.ProxyEchoService;

/**
 * @author: markus
 * @date: 2022/10/12 12:16 AM
 * @Description: 静态代理示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class StaticProxyClient {
    public static void main(String[] args) {
        ProxyEchoService proxyEchoService = new ProxyEchoService(new DefaultEchoService());
        proxyEchoService.echo("Hello World AOP!");
    }
}
