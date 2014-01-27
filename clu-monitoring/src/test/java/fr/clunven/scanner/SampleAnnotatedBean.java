package fr.clunven.scanner;

import fr.clunven.profiler.log.Profiled;

@ClassShoudBeScanned
public class SampleAnnotatedBean {

	@Profiled(logParameters = true, logOutput = true)
	public void sampleMethod() {
		System.out.println("Je ne fais rien mais je suis tagge par le scanner au chargement des BEANS");
	}
	
	public void methode2() {
		System.out.println("Je ne fais rien mais je suis tagge par le scanner au chargement des BEANS");
	}

}
