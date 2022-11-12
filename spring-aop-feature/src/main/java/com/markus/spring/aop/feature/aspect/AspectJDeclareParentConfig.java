package com.markus.spring.aop.feature.aspect;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import com.markus.spring.aop.feature.interceptor.EchoServiceMethodInterceptor;
import com.markus.spring.aop.feature.introduction.UsageTracked;
import com.markus.spring.aop.feature.introduction.support.DefaultUsageTracked;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author: markus
 * @date: 2022/11/12 9:45 PM
 * @Description: @DeclareParents示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Aspect
public class AspectJDeclareParentConfig {

    @DeclareParents(value = "com.markus.aop.overview.*+", defaultImpl = DefaultUsageTracked.class)
    public UsageTracked usageTracked;

    @Pointcut("target(com.markus.aop.overview.EchoService)")
    public void methodFilter() {
    }

    @Before("methodFilter() && this(usageTracked)")
    public void before(UsageTracked usageTracked) {
        usageTracked.echoMethodInvokeCount();
    }

    @Before("target(com.markus.aop.overview.AopService) && this(usageTracked)")
    public void before4Aop(UsageTracked usageTracked) {
        usageTracked.echoMethodInvokeCount();
    }
}
