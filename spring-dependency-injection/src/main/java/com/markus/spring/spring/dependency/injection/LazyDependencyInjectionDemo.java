package com.markus.spring.spring.dependency.injection;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collection;

/**
 * @author: markus
 * @date: 2022/3/20 9:25 下午
 * @Description: 延迟依赖注入 示例
 * @Blog: http://markuszhang.com/
 */
public class LazyDependencyInjectionDemo {

    @Autowired
    private User user;

    @Autowired
    @Qualifier(value = "user")
    private ObjectFactory<User> userObjectFactory; // ObjectFactory 单一类型注入 期待得到user对象

    @Autowired
    private ObjectFactory<Collection<User>> userCollectionObjectFactory; // ObjectFactory 集合类型注入 期待得到所有User类型的对象

    @Autowired
    private ObjectProvider<User> userObjectProvider; // ObjectProvider 既能单一类型 又能集合类型

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(LazyDependencyInjectionDemo.class);

        BeanDefinitionReader reader = new XmlBeanDefinitionReader(applicationContext);
        String resourcePath = "classpath:/META-INF/dependency-lookup.xml";
        reader.loadBeanDefinitions(resourcePath);

        applicationContext.refresh();
        LazyDependencyInjectionDemo demo = applicationContext.getBean(LazyDependencyInjectionDemo.class);
        System.out.println("demo.user is \n\t"+demo.user);
        System.out.println("demo.userObjectFactory.getObject() is \n\t"+demo.userObjectFactory.getObject());
        System.out.println("demo.userCollectionObjectFactory.getObject() is \n\t"+demo.userCollectionObjectFactory.getObject());
        System.out.println("demo.userObjectProvider.getObject() is \n\t"+demo.userObjectProvider.getObject());

        // 遍历ObjectProvider 集合类型注入
        System.out.print("foreach userObjectProvider: \n\t");
        demo.userObjectProvider.forEach(System.out::println);

        applicationContext.close();
    }
}
