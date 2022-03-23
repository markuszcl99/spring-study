package com.markus.spring.spring.dependency.injection;

import com.markus.spring.ioc.container.domain.User;
import com.markus.spring.spring.dependency.injection.annotation.UserGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.List;

/**
 * {@link Qualifier}
 * @author: markus
 * @date: 2022/3/20 8:59 下午
 * @Description: 限定注入 示例
 * @Blog: http://markuszhang.com/
 */
public class QualifierDependencyInjectionDemo {

    @Autowired
    private User user;

    @Autowired
    @Qualifier(value = "user")
    private User user2;

    @Autowired
    private List<User> exceptQualifierUsers; // 期待：user superUser

    @Autowired
    @Qualifier
    private List<User> qualifierUsers; // 期待：user3 user4 （user5 ∈ @UserGroup）

    @Autowired
    @UserGroup
    private List<User> groupUsers; //   期待 user5

    @Bean
    @Qualifier
    public User user3(){
        return createUser("user3");
    }

    @Bean
    @Qualifier
    public User user4(){
        return createUser("user4");
    }

    @Bean
    @UserGroup
    public User user5(){
        return createUser("user5");
    }

    private User createUser(String name){
        User user = new User();
        user.setName(name);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualifierDependencyInjectionDemo.class);

        BeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String resourcePath = "classpath:/META-INF/dependency-lookup.xml";
        reader.loadBeanDefinitions(resourcePath);

        applicationContext.refresh();
        QualifierDependencyInjectionDemo demo = applicationContext.getBean(QualifierDependencyInjectionDemo.class);
        System.out.println("demo.user is "+demo.user);
        System.out.println("demo.user2 is "+demo.user2);
        System.out.println("demo.exceptQualifierUsers is "+demo.exceptQualifierUsers);
        System.out.println("demo.qualifierUsers is "+demo.qualifierUsers);
        System.out.println("demo.groupUsers is "+demo.groupUsers);
        applicationContext.close();
    }
}
