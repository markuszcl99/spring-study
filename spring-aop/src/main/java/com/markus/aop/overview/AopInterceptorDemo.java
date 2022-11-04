package com.markus.aop.overview;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: markus
 * @date: 2022/11/4 10:31 PM
 * @Description: Aop拦截器 自定义实现示例
 * @Blog: http://markuszhang.com
 * It's my honor to share what I've learned with you!
 */
public class AopInterceptorDemo {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Object proxy = Proxy.newProxyInstance(classLoader, new Class[]{EchoService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (EchoService.class.isAssignableFrom(method.getDeclaringClass())) {
                    // 前置拦截
                    BeforeInterceptor beforeInterceptor = new BeforeInterceptor() {
                        @Override
                        public Object before(Object proxy, Method method, Object[] args) {
                            long startTime = System.currentTimeMillis();
                            return startTime;
                        }
                    };
                    Object result = null;
                    long startTime = 0L;
                    long endTime = 0L;
                    try {
                        startTime = (long) beforeInterceptor.before(proxy, method, args);
                        EchoService echoService = new DefaultEchoService();
                        result = echoService.echo((String) args[0]);
                        AfterReturningInterceptor afterReturningInterceptor = new AfterReturningInterceptor() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args, Object returnValue) {
                                long endTime = System.currentTimeMillis();
                                return endTime;
                            }
                        };
                        endTime = (long) afterReturningInterceptor.invoke(proxy, method, args, result);
                    } catch (Exception e) {
                        // 异常拦截
                        ThrowsInterceptor throwsInterceptor = new ThrowsInterceptor() {
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args, Throwable exception) {
                                System.out.println("exception is " + exception.getMessage());
                                return null;
                            }
                        };
                        throwsInterceptor.invoke(proxy, method, args, e);
                    } finally {
                        TimeFinalizeInterceptor timeFinalizeInterceptor = new TimeFinalizeInterceptor(startTime, endTime);
                        long costTime = (long) timeFinalizeInterceptor.finalize(proxy, method, args, result);
                        System.out.println("echo 方法执行的时间为: " + costTime + " ms!");
                    }
                    return result;
                }
                return null;
            }
        });

        EchoService echoService = (EchoService) proxy;
        echoService.echo("Hello World!");
    }
}

class TimeFinalizeInterceptor implements FinalizeInterceptor {

    private final long startTime;
    private final long endTime;

    public TimeFinalizeInterceptor(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public Object finalize(Object proxy, Method method, Object[] args, Object retValue) {
        long costTime = endTime - startTime;
        return costTime;
    }
}

