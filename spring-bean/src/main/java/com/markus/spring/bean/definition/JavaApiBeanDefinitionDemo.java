package com.markus.spring.bean.definition;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: markus
 * @date: 2022/3/12 3:40 下午
 * @Description: Java API 配置元信息-配置类方式
 * @Blog: http://markuszhang.com/
 */
@Configuration
public class JavaApiBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 通过
        AnnotatedBeanDefinitionReader definitionReader = new AnnotatedBeanDefinitionReader(applicationContext);
        definitionReader.register(JavaApiBeanDefinitionDemo.class);

        // 启动应用上下文
        applicationContext.refresh();

        System.out.println(applicationContext.getBeansOfType(User.class));

        // 关闭应用上下文
        applicationContext.close();
    }

    @Bean
    public User user(){
        User user = new User();
        user.setAge(23);
        user.setName("markus");
        return user;
    }
}
