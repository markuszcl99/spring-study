package com.markus.spring.aop.feature.introduction.support;

import com.markus.spring.aop.feature.introduction.UsageTracked;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: markus
 * @date: 2022/11/12 10:16 PM
 * @Description: 调用跟踪器默认实现
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class DefaultUsageTracked implements UsageTracked {

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void echoMethodInvokeCount() {
        System.out.println(count.incrementAndGet());
    }
}
