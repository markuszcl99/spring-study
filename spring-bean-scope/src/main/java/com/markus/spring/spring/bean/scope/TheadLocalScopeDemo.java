package com.markus.spring.spring.bean.scope;

import com.markus.spring.ioc.container.domain.User;
import com.markus.spring.spring.bean.annotation.ThreadScope;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author: markus
 * @date: 2022/3/27 8:51 下午
 * @Description: 使用 自定义作用域 示例
 * @Blog: http://markuszhang.com/
 */
public class TheadLocalScopeDemo {


    @Bean
    @ThreadScope
    public static User user() {
        return createUser();
    }

    private static User createUser() {
        User user = new User();
        user.setId(System.nanoTime());
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TheadLocalScopeDemo.class);
        applicationContext.addBeanFactoryPostProcessor(new BeanFactoryPostProcessor() {
            @Override
            public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
                beanFactory.registerScope(ThreadLocalScope.SCOPE_NAME, new ThreadLocalScope());
            }
        });
        applicationContext.refresh();
        scopeBeansByLookup(applicationContext);
        applicationContext.close();
    }

    private static void scopeBeansByLookup(AnnotationConfigApplicationContext applicationContext) {
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(()->{
               User user = applicationContext.getBean(User.class);
                System.out.println(user);
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
