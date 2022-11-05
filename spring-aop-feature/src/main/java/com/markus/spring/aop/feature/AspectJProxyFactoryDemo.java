package com.markus.spring.aop.feature;

import com.markus.aop.overview.DefaultEchoService;
import com.markus.aop.overview.EchoService;
import com.markus.spring.aop.feature.aspect.AspectJAnnotationConfig;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

/**
 * @author: markus
 * @date: 2022/11/5 12:20 PM
 * @Description: AspectJ代理工厂 示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AspectJProxyFactoryDemo {
    public static void main(String[] args) {
        // 生成目标类
        EchoService echoService = new DefaultEchoService();
        // 创建AspectJ代理工厂
        AspectJProxyFactory proxyFactory = new AspectJProxyFactory(echoService);
        // 添加Aspect切面
        proxyFactory.addAspect(AspectJAnnotationConfig.class);

        EchoService proxy = proxyFactory.getProxy();
        proxy.echo("Hello World!");
    }
}
