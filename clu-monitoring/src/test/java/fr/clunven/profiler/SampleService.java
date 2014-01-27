package fr.clunven.profiler;

import org.springframework.stereotype.Component;

import fr.clunven.profiler.log.Profiled;
import fr.clunven.profiler.report.Report;

@Component
public class SampleService {
	
	@Profiled
	public void createSampleBean(String pa, Report mm) {
		System.out.println("Je sert a rien " + pa);
	}
	
	@Profiled(logOutput = true, logParameters = true)
	public Report methodeLotOfLog(String pa, Report mm) {
		System.out.println("Je sert e rien " + pa);
		return mm;
	}
	
	
	

}
