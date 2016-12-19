package org.ff4j.aop.proxy.cglib;

import java.util.HashMap;
import java.util.Map;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * Factory class to create. proxies
 *  
 * @author Cedrick LUNVEN  (@clunven)
 */
public class FF4jCglibProxyFactory {
    
    /** Map of existing proxies. */
    private static Map < String, Object > existingProxies = new HashMap<>();
    
    /**
     * Create proxy based on class.
     *
     * @param targetClass
     *      target class
     * @param interceptor
     *      current interceptor
     * @return
     *      proxifed class
     */
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Class < ? extends T> targetClass, CallbackFilter filter, Callback... interceptors) {
        if (!existingProxies.containsKey(targetClass.getName())) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(targetClass);
            enhancer.setCallbacks(interceptors);
            enhancer.setCallbackFilter(filter);
            existingProxies.put(targetClass.getName(), enhancer.create());
        }
        return (T) existingProxies.get(targetClass.getName());
    }
    
    /**
     * Create proxy based on class.
     *
     * @param targetClass
     *      target class
     * @param interceptor
     *      current interceptor
     * @return
     *      proxifed class
     */
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Class < ? extends T> targetClass, MethodInterceptor interceptor) {
        if (!existingProxies.containsKey(targetClass.getName())) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(targetClass);
            enhancer.setCallback(interceptor);
            existingProxies.put(targetClass.getName(), enhancer.create());
        }
        return (T) existingProxies.get(targetClass.getName());
    }

}
