package fr.clunven.profiler.report;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Aspect Allowing to profile target method using default PROFILES.
 *
 * @author clunven
 */
@Aspect
@Component("ReportAspect")
public class ReportAspect {
	
	@Pointcut(value="execution(public * *(..))")
	public void anyPublicMethod() {}

	@Around("anyPublicMethod() && @annotation(reportProfiling)")
	public Object reportProfiling(ProceedingJoinPoint pjp, ReportInfos reportProfiling)
	throws Throwable {
		long before = System.currentTimeMillis();
        Object returnedValue = pjp.proceed();
        long after  = System.currentTimeMillis();
        String packageName = pjp.getTarget().getClass().getPackage().getName();
        String className   = pjp.getTarget().getClass().getName();
        String methodName  = pjp.getSignature().getName();
        Report mm = new Report(packageName, className, methodName, before, after);
        ReportManager.getInstance().publish(mm);
		return returnedValue;
	}

}
