package com.markus.spring.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: markus
 * @date: 2022/12/8 10:45 PM
 * @Description: 组件扫描 示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
//@ComponentScan(basePackages = "com.markus.spring.annotation") // 扫描指定包下的类文件 凡是被标注@Component或者其派生注解的类都会被注册到IoC容器中
//@MyComponentScan(scanBasePackages = "com.markus.spring.annotation") // 自定义ComponentScan注解 显示别名
//@MyComponentScan(scanBasePackagesExplicitAliases = "com.markus.spring.annotation") // 自定义ComponentScan注解 显示别名
//@MyComponentScan2(scanBasePackages = "com.markus.spring.annotation") // 自定义ComponentScan注解 显示重写
@MyComponentScan2(packages = "com.markus.spring.annotation") // 自定义ComponentScan注解 隐性重写
public class ComponentScanDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ComponentScanDemo.class);
        context.refresh();

        TestClass bean = context.getBean(TestClass.class);
        System.out.println(bean);

        context.close();
    }
}
