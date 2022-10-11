package com.markus.aop.overview;

import com.markus.aop.EchoService;

/**
 * @author: markus
 * @date: 2022/10/12 12:14 AM
 * @Description: 代理对象
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ProxyEchoService implements EchoService {

    private EchoService echoService;

    public ProxyEchoService(EchoService echoService) {
        this.echoService = echoService;
    }

    @Override
    public String echo(String message) {
        String result = "【proxy】" + message;
        System.out.println(result);
        return result;
    }
}
