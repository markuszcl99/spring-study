package com.markus.spring.spring.dependency.injectionv2;

import com.markus.spring.spring.dependency.injection.UserHolder;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: markus
 * @date: 2022/9/2 10:39 PM
 * @Description: 底层Api实现 setter方法依赖注入
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ApiDependencySetterInjectionDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/dependency-lookup.xml");

        // 创建BeanDefinition
        BeanDefinition beanDefinition = createBeanDefinition();
        // 注册BeanDefinition
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
        beanFactory.registerBeanDefinition("userHolder", beanDefinition);

        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);

        applicationContext.close();
        // 控制台输出
//      UserHolder{user=User{id=null, age=23, name='markus', city=BEIJING, workCities=[BEIJING, HEZE], lifeCities=[BEIJING, HEZE], resource=class path resource [META-INF/user-config.properties]}, users=null}
//      Process finished with exit code 0
    }

    private static BeanDefinition createBeanDefinition() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        builder.addPropertyReference("user", "user");
        return builder.getBeanDefinition();
    }
}
