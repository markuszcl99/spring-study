package com.markus.spring.spring.bean.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;
import org.springframework.lang.NonNull;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: markus
 * @date: 2022/3/27 8:40 下午
 * @Description: 自定义作用域（线程级别） 实现
 * @Blog: http://markuszhang.com/
 */
public class ThreadLocalScope implements Scope {

    public static final String SCOPE_NAME = "thread-local";

    private NamedThreadLocal<Map<String,Object>> threadLocal = new NamedThreadLocal("thread-local-scope"){

        @Override
        public Object initialValue(){
            return new HashMap<String,Object>();
        }
    };

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String,Object> currContext = getContext();

        Object object = currContext.get(name);
        if (object == null){
            object = objectFactory.getObject();
            currContext.put(name,object);
        }
        return object;
    }

    @NonNull
    private Map<String,Object> getContext(){
        return threadLocal.get();
    }

    @Override
    public Object remove(String name) {
        Map<String,Object> context = getContext();
        return context.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
        // todo 先不做处理
    }

    @Override
    public Object resolveContextualObject(String key) {
        Map<String,Object> context = getContext();
        return context.get(key);
    }

    @Override
    public String getConversationId() {
        Thread thread = Thread.currentThread();
        return String.valueOf(thread.getId());
    }
}
