package fr.clunven.jdk8;

/**
 * Sample MEDIA.
 *
 * @author clunven
 */
@FunctionalInterface
public interface Rule {
	
	/**
	 * Unique method.
	 *
	 * @param featureName
	 * 		target name
	 * @param params
	 * 		parameters
	 * @return
	 * 		is the feeature is checked
	 */
	boolean check(String featureName);

}
