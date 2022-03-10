package com.markus.spring.study.dependency.container;

import com.markus.spring.study.dependency.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: markus
 * @date: 2022/3/10 11:39 下午
 * @Description: 注解ApplicationContext作为IoC容器
 * @Blog: http://markuszhang.com/
 */
//@Configuration 加上这个注解 可以cglib增强
public class AnnotationApplicationContextAsIoCContainer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotationApplicationContextAsIoCContainer.class);
        applicationContext.refresh();

        //依赖查找
        lookupByType(applicationContext);
        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public User user(){
        User user = new User();
        user.setAge(23);
        user.setName("Markus");
        return user;
    }

    private static void lookupByType(ApplicationContext applicationContext){
        User user = applicationContext.getBean(User.class);
        System.out.println("依赖查找（注解驱动）："+user);
    }
}
