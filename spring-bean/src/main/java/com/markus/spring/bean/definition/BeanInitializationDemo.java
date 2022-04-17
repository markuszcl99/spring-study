package com.markus.spring.bean.definition;

import com.markus.spring.bean.factory.DefaultUserFactory;
import com.markus.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @author: markus
 * @date: 2022/3/15 10:21 下午
 * @Description: 延迟初始化Bean
 * @Blog: http://markuszhang.com/
 */
@Configuration
public class BeanInitializationDemo {
    /**
     * 初始化Bean有三种方式：
     * 1. Java注解       @PostConstruct
     * 2. Spring接口     实现InitializingBean 重写 afterPropertiesSet 方法
     * 3. 自定义方法
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册配置类
        applicationContext.register(BeanInitializationDemo.class);
        // 启动应用上下文
        applicationContext.refresh();
        System.out.println("Spring应用上下文启动完成....");
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);
        System.out.println("Spring应用上下文准备关闭...");
        // 关闭应用上下文XQ
        applicationContext.close();
        System.out.println("Spring应用上下文已关闭...");

    }

    @Bean(initMethod = "initUserFactory", destroyMethod = "doDestroy")
    @Lazy
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}  
