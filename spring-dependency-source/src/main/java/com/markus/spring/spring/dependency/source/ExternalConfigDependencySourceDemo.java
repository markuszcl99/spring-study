package com.markus.spring.spring.dependency.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author: markus
 * @date: 2022/3/26 10:36 下午
 * @Description: 外部化配置 依赖来源 示例
 * @Blog: http://markuszhang.com/
 */
@Configuration
@PropertySource(value = "classpath:/META-INF/default.properties",encoding = "UTF-8")
public class ExternalConfigDependencySourceDemo {

    @Value("${user.id:-1}")
    private Integer id;

    @Value("${usr.name}")
    private String userName;

    @Value("${user.properties}")
    private Resource resource;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ExternalConfigDependencySourceDemo.class);

        applicationContext.refresh();
        ExternalConfigDependencySourceDemo demo = applicationContext.getBean(ExternalConfigDependencySourceDemo.class);
        System.out.println("demo.id "+demo.id);
        System.out.println("demo.userName "+demo.userName);
        System.out.println("demo.resource "+demo.resource);
        applicationContext.close();
    }
}
