package com.markus.spring.spring.dependency.injectionv2;

import com.markus.spring.spring.dependency.injection.UserHolder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: markus
 * @date: 2022/9/4 12:02 PM
 * @Description: 底层api 实现依赖构造器注入 示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ApiDependencyConstructorInjectionDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup.xml");

        // 构建BeanDefinition
        BeanDefinition userHolderBeanDefinition = createBeanDefinition();
        // 注册BeanDefinition
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context.getBeanFactory();
        registry.registerBeanDefinition("userHolder", userHolderBeanDefinition);

        // 依赖查找 UserHolder
        UserHolder userHolder = context.getBean("userHolder", UserHolder.class);
        System.out.println(userHolder);

        // 关闭应用上下文
        context.close();

    }

    private static BeanDefinition createBeanDefinition() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        // 底层API实现构造器注入
        builder.addConstructorArgReference("user");
        return builder.getBeanDefinition();
    }
}
