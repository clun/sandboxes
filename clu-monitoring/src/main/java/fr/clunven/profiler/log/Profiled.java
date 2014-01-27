package fr.clunven.profiler.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation permettant d'activer un profiling explicite sur une m�thode.
 *
 * @author clunven
 */
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Profiled {
	
	/** Permet de realiser des 'traces' des elements en entree. */
	boolean logParameters() default false;
	
	/** Permet de realiser des 'traces' des elements en sortie. */
	boolean logOutput() default false;
}
