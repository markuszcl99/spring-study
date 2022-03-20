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
 * @date: 2022/3/20 2:17 下午
 * @Description: 方法注入 示例
 * @Blog: http://markuszhang.com/
 */
public class DependencyInjectMethodDemo {

    private UserHolder userHolder;

    private UserHolder userHolder2;

    @Autowired
    public void init1(UserHolder userHolder){
        this.userHolder = userHolder;
    }

    @Resource
    public void init2(UserHolder userHolder2){
        this.userHolder2 = userHolder2;
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(DependencyInjectMethodDemo.class);

        BeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup.xml");

        applicationContext.refresh();
        // 依赖查找
        DependencyInjectMethodDemo demo = applicationContext.getBean(DependencyInjectMethodDemo.class);
        System.out.println(demo.userHolder);
        System.out.println(demo.userHolder2);
        applicationContext.close();
    }

    @Bean
    public UserHolder userHolder(User user){
        return new UserHolder(user);
    }
}
