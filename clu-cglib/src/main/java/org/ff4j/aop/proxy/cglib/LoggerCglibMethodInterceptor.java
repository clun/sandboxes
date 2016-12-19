package org.ff4j.aop.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Method Interceptor.
 *
 * @author Cedrick LUNVEN  (@clunven)
 *
 * @param <T>
 *      current bean to proxify
 */
public class LoggerCglibMethodInterceptor<T> implements MethodInterceptor {
    
    /** Reference to original bean. */
    protected final T original;

    public LoggerCglibMethodInterceptor() {
        this(null);
    }

    public LoggerCglibMethodInterceptor(T original) {
        this.original = original;
    }
    
    /** {@inheritDoc} */
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("BEFORE");
        Object o = methodProxy.invokeSuper(object, args);
        System.out.println("AFTER");
        return o;
    }
    
    /*
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("BEFORE");
        method.invoke(original, args);
        System.out.println("AFTER");
        return null;
    } */   

}
