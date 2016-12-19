package org.ff4j.aop.proxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.CallbackFilter;

/**
 * Check if the interception should be invoked or not.
 *
 * @author Cedrick LUNVEN  (@clunven)
 */
public class LoggerCglibCallBackFilter implements CallbackFilter {
    
    /** Callback offset in the callbacks attribute of the Enhance. */
    public static final int DEFAULT_BEHAVIOUR  = 0;
    
    /** Callback offset in the callbacks attribute of the Enhance. */
    public static final int LOG_CALLBACK = 1;
    
    /** {@inheritDoc} */
    @Override
    public int accept(Method method) {
        return LOG_CALLBACK;
    }
}
