package org.ff4j.aop.proxy;

import org.ff4j.aop.proxy.cglib.FF4jCglibProxyFactory;
import org.ff4j.aop.proxy.cglib.LoggerCglibCallBackFilter;
import org.ff4j.aop.proxy.cglib.LoggerCglibMethodInterceptor;
import org.ff4j.aop.proxy.service.SpeakFrench;
import org.ff4j.aop.proxy.service.SpeakService;
import org.junit.Test;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.NoOp;

public class ProxyCglibDemo {
    
    @Test
    public void testProxyWithSingleInterceptor() {    
        // Proxy with a single Interceptor (Callback)
        SpeakService ss = FF4jCglibProxyFactory.createProxy(SpeakFrench.class, 
                new LoggerCglibMethodInterceptor<>());
        ss.sayHello("Cedrick");
    }
    
    @Test
    public void testProxyWithMultipleInterceptor() {
        // Proxy with multiple Interceptor filtered with a CallbackFilter
        SpeakService ss2 = FF4jCglibProxyFactory.createProxy(SpeakFrench.class, 
                new LoggerCglibCallBackFilter(), 
                new Callback[] { NoOp.INSTANCE, new LoggerCglibMethodInterceptor<>()});
        ss2.sayHello("Cedrick");
        
    }
   

}
