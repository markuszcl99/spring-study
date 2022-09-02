package com.markus.spring.spring.bean.lifecycle.processor;

import com.markus.spring.ioc.container.domain.SuperUser;
import com.markus.spring.ioc.container.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * @author: markus
 * @date: 2022/4/28 9:58 下午
 * @Description: Spring Bean生命周期 实例化前、后阶段 示例
 * @Blog: http://markuszhang.com/
 */
public class UserInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("user".equals(beanName)) {
            System.out.println("postProcessBeforeInstantiation：实例化之前进行");
        }
        return null;
    }

    /**
     * 在属性填充前的操作
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (User.class.equals(bean.getClass())) {
            System.out.println("postProcessAfterInstantiation：实例化之后初始化之前进行");
            return true;
        }
        // 默认返回为true
        return true;
    }
}
