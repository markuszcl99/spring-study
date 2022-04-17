package com.markus.spring.spring.bean.lifecycle.config;

import com.markus.spring.spring.bean.lifecycle.config.annotation.UserService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author: markus
 * @date: 2022/3/29 11:42 下午
 * @Description: spring bean元信息配置阶段：面向注解 示例
 * @Blog: http://markuszhang.com/
 */
// @Configuration注解可以进行字节码增加，如果加了该注解，那么BeanMetaFaceAnnotationDemo会是代理类，如果不加，则是普通的类
@Configuration
public class BeanMetaFaceAnnotationDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanMetaFaceAnnotationDemo.class);
        // 注解扫描路径
        applicationContext.scan("com/markus/spring/spring/bean/lifecycle/config/annotation");
        applicationContext.refresh();

        BeanMetaFaceAnnotationDemo demo = applicationContext.getBean(BeanMetaFaceAnnotationDemo.class);
        System.out.println(demo);

        UserService userService = applicationContext.getBean(UserService.class);
        System.out.println(userService);

        applicationContext.close();


    }
}
