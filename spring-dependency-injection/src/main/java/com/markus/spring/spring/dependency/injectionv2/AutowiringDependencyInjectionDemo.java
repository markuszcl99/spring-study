package com.markus.spring.spring.dependency.injectionv2;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

/**
 * @author: markus
 * @date: 2022/9/4 2:18 PM
 * @Description: 自动绑定注入 字段、方法注入
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AutowiringDependencyInjectionDemo {

    @Autowired
    private User user; // 注入的是 superUser (@Autowired 首先按照类型注入，如果找到多个就选被primary标注的bean注入，如果没标注，就按照名称选择)

    @Resource
    private User user1; // 注入的是 superUser

    @Autowired
    private Collection<User> users; // 注入的是 user superUser

    @Autowired
    private Map<String, User> userMap; // 注入的是 user superUser

    @Autowired
    private Optional<User> userOptional; // 注入的是 superUser

    private User initUser;

    @Autowired
    public void methodInjectUser(User user) {
        this.initUser = user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AutowiringDependencyInjectionDemo.class);

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry) context.getBeanFactory());
        reader.loadBeanDefinitions("classpath:/META-INF/dependency-lookup.xml");

        context.refresh();

        AutowiringDependencyInjectionDemo demo = context.getBean(AutowiringDependencyInjectionDemo.class);
        System.out.println(demo.user);
        System.out.println(demo.user1);
        System.out.println(demo.users);
        System.out.println(demo.userMap);
        System.out.println(demo.userOptional);
        System.out.println(demo.initUser);

        context.close();
    }
}
