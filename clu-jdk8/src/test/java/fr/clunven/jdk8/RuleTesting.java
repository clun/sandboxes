package fr.clunven.jdk8;

import org.junit.Test;

public class RuleTesting {
	
	public Rule myRule = (s) -> { System.out.println(s); return true; };
	
	@Test
	public void myTest() {
		myRule.check("a");
	}

}
