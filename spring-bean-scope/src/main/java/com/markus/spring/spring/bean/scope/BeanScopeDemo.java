package com.markus.spring.spring.bean.scope;

import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * @author: markus
 * @date: 2022/3/27 1:37 下午
 * @Description: Bean作用域 示例
 * @Blog: http://markuszhang.com/
 */
public class BeanScopeDemo implements DisposableBean{

    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) Spring默认就是单例
    public static User singletonUser() {
        return createUser();
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public static User prototypeUser() {
        return createUser();
    }

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser;

    @Autowired
    @Qualifier("singletonUser")
    private User singletonUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser1;

    @Autowired
    @Qualifier("prototypeUser")
    private User prototypeUser2;

    @Autowired
    private Map<String,User> users;

    @Autowired
    private ConfigurableListableBeanFactory beanFactory;


    public static User createUser() {
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanScopeDemo.class);

        applicationContext.refresh();

        // 结论一
        // Singleton Bean 无论依赖查找还是依赖注入 均是一个Bean
        // Prototype Bean 无论依赖查找还是依赖注入 均是新生成的Bean

        // 结论二
        // 如果依赖注入集合类型的对象时，单例对象和原型对象 均会存在一个
        // 但原型对象有别于其他注入的原型对象

        // 结论三
        // Singleton Bean 生命周期完全由Spring托管
        // Prototype Bean 在被创建后就不受Spring托管了
        // 所以 Singleton Bean和 Prototype Bean均可以调用初始化方法回调
        // 而仅仅Singleton Bean能调用销毁方法回调
        // 使用原型模式不当，可能会导致OOM

        scopeBeansByLookup(applicationContext);
        scopeBeansByInjection(applicationContext);

        applicationContext.close();
    }

    private static void scopeBeansByInjection(AnnotationConfigApplicationContext applicationContext) {
        BeanScopeDemo demo = applicationContext.getBean(BeanScopeDemo.class);

        System.out.println("demo.singletonUser = "+ demo.singletonUser);
        System.out.println("demo.singletonUser1 = "+ demo.singletonUser1);
        System.out.println("demo.prototypeUser = "+ demo.prototypeUser);
        System.out.println("demo.prototypeUser1 = "+ demo.prototypeUser1);
        System.out.println("demo.prototypeUser2 = "+ demo.prototypeUser2);
        System.out.println("demo.users = "+ demo.users);
    }

    private static void scopeBeansByLookup(AnnotationConfigApplicationContext applicationContext) {

        for (int i = 0; i < 3; i++) {
            User singletonUser = applicationContext.getBean("singletonUser",User.class);
            System.out.println(singletonUser);

            User prototypeUser = applicationContext.getBean("prototypeUser",User.class);
            System.out.println(prototypeUser);
        }
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("Bean 正在销毁中...");
        this.prototypeUser.destroy();
        this.prototypeUser1.destroy();
        this.prototypeUser2.destroy();

        for (Map.Entry<String,User> entry: users.entrySet()){
            String beanName = entry.getKey();
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
            if (beanDefinition.isPrototype()){
                User user = entry.getValue();
                user.destroy();
            }
        }
        System.out.println("Bean 销毁完成");
    }
}
