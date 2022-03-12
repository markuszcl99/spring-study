package com.markus.spring.bean.definition;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * @author: markus
 * @date: 2022/3/12 2:56 下午
 * @Description: 注解 BeanDefinition 示例
 * @Blog: http://markuszhang.com/
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册配置类
        applicationContext.register(AnnotationBeanDefinitionDemo.class);
        // 启动应用上下文
        applicationContext.refresh();

        // 依赖查找(@Component、@Bean、@Import方式)
//        Map<String,User> beans = applicationContext.getBeansOfType(User.class);
//        System.out.println(beans);

        // 命名方式
        registerUserBeanDefinition(applicationContext,"user2");
        registerUserBeanDefinition(applicationContext);
        System.out.println("Config 类型下的所有Beans："+applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型下的所有Beans："+applicationContext.getBeansOfType(User.class));

        // 关闭应用上下文
        applicationContext.close();
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry,String beanName){
        BeanDefinitionBuilder beanDefinitionBuilder = genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("age",23)
                .addPropertyValue("name","Markus");

        if (StringUtils.hasText(beanName)){
            // 命名方式
            beanDefinitionRegistry.registerBeanDefinition(beanName,beanDefinitionBuilder.getBeanDefinition());
        } else{
            // 非命名方式
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(),beanDefinitionRegistry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry beanDefinitionRegistry){
        registerUserBeanDefinition(beanDefinitionRegistry,null);
    }

    @Component
    public static class Config{

        @Bean(name = {"user","markus-user"})
        public User user(){
            User user = new User();
            user.setAge(23);
            user.setName("Markus");
            return user;
        }
    }
}
