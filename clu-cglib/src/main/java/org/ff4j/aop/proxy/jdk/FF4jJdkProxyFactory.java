package org.ff4j.aop.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class FF4jJdkProxyFactory {
    
    private static <T> Class<?> guessInterface(T target) {
        return target.getClass().getInterfaces()[0];
    }
    
    private static <T> InvocationHandler instanciateInvocationHandler(Class<? extends InvocationHandler> targetHandler, Object service) {
        try {
            return targetHandler.getConstructor(Object.class).newInstance(service);
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot initiate handler, check constructor", e);
        }
    }
    
    /**
     * Use the first interface to create a proxy.
     * @param target
     *      current object
     * @return
     *      an proxy
     */
    public static <T> T proxy(T target, Class<? extends InvocationHandler> clazz) {
        return proxy(target, guessInterface(target), instanciateInvocationHandler(clazz, target));
    }
    
    /**
     * Use the first interface to create a proxy.
     * @param target
     *      current object
     * @return
     *      an proxy
     */
    public static <T> T proxy(T target, InvocationHandler ih) {
        return proxy(target, guessInterface(target), ih);
    }
    
    /**
     * Create a proxy for an object based on target interface.
     *
     * @param implem
     *      current object
     * @param refInterface
     *      related interface
     * @param targetHandler
     *      invocation handler to work with
     * @return
     *      target
     */
    public static <T> T proxy(T service, Class<T> refInterface, Class<? extends InvocationHandler> targetHandler) {
        return proxy(service, refInterface, instanciateInvocationHandler(targetHandler, service));
    }
    
    /**
     * Dynamic proxy relying on JDK default proxy, no bytecode manipulation.
     *
     * @param target
     *      current service to be executed
     * @param targetInterface
     *      reference interface to switch
     * @return
     *      a proxy of the target services
     */
    @SuppressWarnings("unchecked")
    public static <T> T proxy(T target, Class<?> targetInterface, InvocationHandler invocHandler) {
        // Check that ref is an interface
       if(targetInterface == null || targetInterface.getClass().isInterface()) {
           throw new IllegalArgumentException("Invalid interface:" + targetInterface);
       }
       // Check that T is an implementation of ref
       if (!targetInterface.isAssignableFrom(target.getClass())) {
           throw new IllegalArgumentException("Invalid interface:" + target.getClass() + " does not implement " + targetInterface);
       }
       return (T) Proxy.newProxyInstance(targetInterface.getClassLoader(), new Class[] {targetInterface}, invocHandler);
    }
    
}
