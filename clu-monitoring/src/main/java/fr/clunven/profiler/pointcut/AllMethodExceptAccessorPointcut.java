package fr.clunven.profiler.pointcut;

import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component("AllMethodExceptGettersSettersPointcut")
public class AllMethodExceptAccessorPointcut extends JdkRegexpMethodPointcut implements InitializingBean {

	/** serial number. */
	private static final long serialVersionUID = 261535776838514221L;

	/** {@inheritDoc} */
	public void afterPropertiesSet() throws Exception {
		setPattern(".*");
		setExcludedPatterns(new String[] {".*\\.get.*", ".*\\.set.*", ".*\\.is.*"});
	}
	
	
	

}
