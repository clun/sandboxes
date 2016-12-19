package org.ff4j.aop.proxy;

import java.lang.reflect.InvocationHandler;

import org.ff4j.aop.proxy.jdk.FF4jJdkProxyFactory;
import org.ff4j.aop.proxy.jdk.LoggerInvocationHandler;
import org.ff4j.aop.proxy.service.SpeakFrench;
import org.ff4j.aop.proxy.service.SpeakService;
import org.junit.Before;
import org.junit.Test;

public class ProxyJdkDemo {
    
    private SpeakService french;
    
    private InvocationHandler ih;
    
    @Before
    public void setup() {
        french = new SpeakFrench();
        ih = new LoggerInvocationHandler<>(french);
    }
    
    @Test
    // We tell everything : Enforce which interface we would like to use
    public void testEnforceInterface() {
        FF4jJdkProxyFactory.proxy(french, SpeakService.class, ih).sayHello("Cedrick");
    }
        
    @Test
    // Just give handler class and let him instanciate
    public void testWithInvocationHandlerClass() {  
        FF4jJdkProxyFactory.proxy(french, SpeakService.class, LoggerInvocationHandler.class).sayHello("Cedrick");
    }
        
    @Test
    // If single interface, deduction
    public void testGuessInterface() {
        FF4jJdkProxyFactory.proxy(french, ih).sayHello("Cedrick");
    }
    
    @Test
    public void testInterfaceHandler() {
        // Guess interface & instanciate handler
        FF4jJdkProxyFactory.proxy(french, LoggerInvocationHandler.class).sayHello("Cedrick");
        
    }
}
