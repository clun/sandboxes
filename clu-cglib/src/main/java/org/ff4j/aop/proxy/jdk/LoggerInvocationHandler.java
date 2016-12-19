package org.ff4j.aop.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LoggerInvocationHandler< T > implements InvocationHandler {
    
    private final T original;

    public LoggerInvocationHandler(T original) {
        this.original = original;
    }

    public Object invoke(Object proxy, Method method, Object[] args)
    throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("BEFORE");
        method.invoke(original, args);
        System.out.println("AFTER");
        return null;
    }
}
