package com.markus.aop.overview;

/**
 * @author: markus
 * @date: 2022/11/4 10:47 PM
 * @Description: 类加载示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class ClassLoadingDemo {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        classLoader = classLoader.getParent();
        while (true) {
            if (classLoader != null) { // == null 为 Bootstrap ClassLoader
                System.out.println(classLoader);
                classLoader = classLoader.getParent();
            }
            break;
        }
    }
}
