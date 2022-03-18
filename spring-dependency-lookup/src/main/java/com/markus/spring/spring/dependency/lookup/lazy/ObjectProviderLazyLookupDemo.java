package com.markus.spring.spring.dependency.lookup.lazy;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;

/**
 * @author: markus
 * @date: 2022/3/18 10:28 下午
 * @Description: ObjectFactory 延迟查找 示例
 * @Blog: http://markuszhang.com/
 */
public class ObjectProviderLazyLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ObjectProviderLazyLookupDemo.class);
        applicationContext.refresh();
        lookupByProvider(applicationContext);
        lookupIfAvailable(applicationContext);
        lookupByStreamOps(applicationContext);
        applicationContext.close();
    }

    @Bean
    @Lazy
    public User user(){
        return User.createUser();
    }

    @Bean
    public String helloWorld(){
        return "Hello,world";
    }

    @Bean
    public String message(){
        return "Message";
    }

    private static void lookupByProvider(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<User> provider = applicationContext.getBeanProvider(User.class);
        User user = provider.getObject();
        System.out.println(user);
    }

    private static void lookupIfAvailable(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<User> provider = applicationContext.getBeanProvider(User.class);
        User user = provider.getIfAvailable(User::createUser);
        System.out.println(user);
    }

    private static void lookupByStreamOps(AnnotationConfigApplicationContext applicationContext){
        ObjectProvider<String> provider = applicationContext.getBeanProvider(String.class);
        provider.stream().forEach(System.out::println);
    }
}
