package com.markus.spring.aop.feature.introduction.support;

import com.markus.aop.overview.EchoService;
import com.markus.spring.aop.feature.introduction.UsageTracked;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: markus
 * @date: 2022/11/12 10:16 PM
 * @Description: 调用跟踪器默认实现
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class DefaultUsageTracked implements UsageTracked, EchoService {

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void echoMethodInvokeCount() {
        System.out.println(count.incrementAndGet());
    }

    @Override
    public String echo(String message) {
        System.out.println(message);
        return message;
    }

    @Override
    public String echoWithException(String message) throws NullPointerException {
        return null;
    }
}
