package fr.clunven.profiler.report;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation permettant d'activer un profiling explicite sur une méthode.
 *
 * @author clunven
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReportInfos {
	
	/** Label. */
	String label() default "";
	
}
