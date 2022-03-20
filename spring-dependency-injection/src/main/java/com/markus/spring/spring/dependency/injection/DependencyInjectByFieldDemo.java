package com.markus.spring.spring.dependency.injection;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;

/**
 * @author: markus
 * @date: 2022/3/20 2:05 下午
 * @Description: 字段注入 示例
 * @Blog: http://markuszhang.com/
 */
public class DependencyInjectByFieldDemo {

    @Autowired
    private UserHolder userHolder;

    @Resource
    private UserHolder userHolder2;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(DependencyInjectByFieldDemo.class);

        BeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup.xml");

        applicationContext.refresh();
        // 依赖查找
        DependencyInjectByFieldDemo demo = applicationContext.getBean(DependencyInjectByFieldDemo.class);
        System.out.println(demo.userHolder);
        System.out.println(demo.userHolder2);
        applicationContext.close();

    }

    @Bean
    public UserHolder userHolder(User user){
        return new UserHolder(user);
    }
}
