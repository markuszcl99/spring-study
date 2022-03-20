package com.markus.spring.spring.dependency.injection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: markus
 * @date: 2022/3/20 12:11 上午
 * @Description: spring底层api 实现setter注入 示例
 * @Blog: http://markuszhang.com/
 */
public class ApiDependencySetterInjectionDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 加载 XML资源 生成BeanDefinition
        String resourcePath = "classpath:/META-INF/dependency-lookup.xml";
        BeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions(resourcePath);

        // 生成UserHolder 的 BeanDefinition
        BeanDefinition beanDefinition = createUserHolderBeanDefinition();
        // 注册UserHolder 的 BeanDefinition
        applicationContext.registerBeanDefinition("userHolder",beanDefinition);

        // 启动上下文
        applicationContext.refresh();

        // 依赖查找
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder.getUser());

        // 关闭上下文
        applicationContext.close();
    }

    private static BeanDefinition createUserHolderBeanDefinition(){
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
//        builder.addPropertyReference("user","user"); // 找到spring容器中 name="user"的Bean
        builder.addPropertyReference("user","superUser"); // 找到spring容器中 name="superUser"的Bean
        return builder.getBeanDefinition();
    }
}
