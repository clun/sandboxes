package fr.clunven.profiler.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


/**
 * Aspect Allowing to profile target method using default PROFILES.
 *
 * @author clunven
 */
@Aspect
@Component("log.aspect.explicitAnnotation")
 public class LogAspect {
	
	/** Logger pour la classe. */
	private static final Log LOGGER = LogFactory.getLog(AuditUtils.class);

	@Pointcut(value="execution(public * *(..))")
	public void anyPublicMethod() {}

	@Around("anyPublicMethod() && @annotation(activateProfiling)")
	public Object activateProfiling(ProceedingJoinPoint pjp, Profiled activateProfiling)
	throws Throwable {
		// executing method...
		String className   = pjp.getTarget().getClass().getCanonicalName();
        String methodName = pjp.getSignature().getName();
        
		StopWatch sw = new StopWatch(className + "." + methodName+ "(...)");
        sw.start(methodName);
        long before = System.currentTimeMillis();
        Object returnedValue = pjp.proceed();
        sw.stop();
        long after  = System.currentTimeMillis();
        
        LOGGER.debug("START PROFILING '" + className + "." + methodName+ "(...)");
        AuditUtils.logParameters(className, methodName, pjp.getArgs(), activateProfiling.logParameters());
        AuditUtils.logOutPut(returnedValue, activateProfiling.logOutput());
        LOGGER.debug(" + Execution Time : '" + (after - before) + "' millisecond(s)");
        LOGGER.debug(sw.prettyPrint());
        LOGGER.debug("END PROFILING");
        return returnedValue;
    }

   
	
}