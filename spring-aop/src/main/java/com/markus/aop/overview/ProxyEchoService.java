package com.markus.aop.overview;

/**
 * @author: markus
 * @date: 2022/11/1 10:40 PM
 * @Description: EchoService代理类
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ProxyEchoService implements EchoService {

    private final EchoService echoService;

    public ProxyEchoService(EchoService echoService) {
        this.echoService = echoService;
    }

    @Override
    public String echo(String message) {
        long startTime = System.currentTimeMillis();
        String result = echoService.echo(message);
        long constTime = System.currentTimeMillis() - startTime;
        System.out.println("echo 方法执行的实现: " + constTime + " ms.");
        return result;
    }

    @Override
    public String echoWithException(String message) throws NullPointerException {
        return null;
    }
}
