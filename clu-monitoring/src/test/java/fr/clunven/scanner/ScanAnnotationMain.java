package fr.clunven.scanner;

import java.lang.reflect.Method;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import fr.clunven.profiler.log.Profiled;

public class ScanAnnotationMain {
	
	public static void main(String[] args) throws Exception {
		// Scanner sur les differents BEAN pour retrouver des classes marquées
		ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
		scanner.addIncludeFilter(new AnnotationTypeFilter(ClassShoudBeScanned.class));
		// La variable est le package de base
		Set < BeanDefinition > beanDefSet = scanner.findCandidateComponents("fr.clunven.scanner");
		
		for (BeanDefinition beanDef : beanDefSet) {
			Class<?> target  = Class.forName(beanDef.getBeanClassName());
			Method[] methods = target.getMethods();
			for (Method method : methods) {
				Profiled ap = method.getAnnotation(Profiled.class);
				if (null != ap) {
					System.out.println(method.getName() + ": " + ap);
				}
			}
		}
	}
	
}
