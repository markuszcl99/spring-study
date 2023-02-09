package com.markus.spring.injection;

import com.markus.spring.annotation.MyAutowired;
import com.markus.spring.bean.User;
import com.markus.spring.configuration.BeanConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import java.util.Collection;
import java.util.Map;

/**
 * @author: markus
 * @date: 2023/2/5 10:43 PM
 * @Description: @Autowired注解示例
 * @Blog: https://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
@Import({
        com.markus.spring.configuration.BeanConfiguration.class
})
public class AutowiredAnnotationDependencyInjectionDemo {

    @Autowired
    private User user;

    @Autowired
    private Map<String, User> userMap;

    @Autowired
    private Collection<User> userCollection;

    private User userFromCtor;

    //    @Autowired 可标注在构造器或者构造器的参数里面，两者取其一即可
    public AutowiredAnnotationDependencyInjectionDemo(@Autowired User user) {
        this.userFromCtor = user;
    }

    private User userFromMethod;

    @Autowired
    public void autowiredUser(User user) {
        this.userFromMethod = user;
    }

    @MyAutowired
    private User userFromCustomAnnotation;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AutowiredAnnotationDependencyInjectionDemo.class);

        context.refresh();

        AutowiredAnnotationDependencyInjectionDemo demo = context.getBean(AutowiredAnnotationDependencyInjectionDemo.class);
        System.out.println("demo.user : " + demo.user);
        System.out.println("demo.userMap : " +demo.userMap);
        System.out.println("demo.userCollection : " +demo.userCollection);
        System.out.println("demo.userFromCtor : " +demo.userFromCtor);
        System.out.println("demo.userFromMethod : " +demo.userFromMethod);
        System.out.println("demo.userFromCustomAnnotation : " +demo.userFromCustomAnnotation);
        context.close();
        //
    }

}
