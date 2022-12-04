package com.markus.spring.aop.feature.blog.aspect;

import com.markus.spring.aop.feature.introduction.UsageTracked;
import com.markus.spring.aop.feature.introduction.support.DefaultUsageTracked;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * @author: markus
 * @date: 2022/12/4 6:58 PM
 * @Description: @DeclareParents示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Aspect
public class AspectJDeclareParentsConfig {
    @DeclareParents(value = "com.markus.spring.aop.feature.blog.domain.DefaultPointcutDemo", defaultImpl = DefaultUsageTracked.class)
    private UsageTracked usageTracked;

    @Before("target(com.markus.spring.aop.feature.blog.domain.PointcutDemo) && this(usageTracked)")
    public void before(UsageTracked usageTracked){
        usageTracked.echoMethodInvokeCount();
    }
}
