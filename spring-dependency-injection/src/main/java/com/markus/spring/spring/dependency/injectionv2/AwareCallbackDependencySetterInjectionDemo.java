package com.markus.spring.spring.dependency.injectionv2;

import com.markus.spring.spring.dependency.injection.UserHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: markus
 * @date: 2022/9/2 10:28 PM
 * @Description: 接口回调接口 setter方法注入 示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AwareCallbackDependencySetterInjectionDemo {
    public static void main(String[] args) {
        // 我们借用ClassPathXmlApplicationContext 将UserHolder Bean定义到xml中
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-setter-injection.xml");

        UserHolder userHolder = context.getBean(UserHolder.class);
        // 这里我们看下UserHolder中注入的beanFactory是否和Spring内部BeanFactory一致
        System.out.println(userHolder.getBeanFactory() == context.getBeanFactory());
//        主程序输出
//        true
//        Process finished with exit code 0
    }
}
