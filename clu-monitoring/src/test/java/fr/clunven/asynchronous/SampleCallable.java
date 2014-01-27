package fr.clunven.asynchronous;

import java.util.concurrent.Callable;

import fr.clunven.profiler.report.Report;

public class SampleCallable implements Callable < Boolean > {

	private Report mm;
	
	public SampleCallable(Report pMM) {
		this.mm = pMM;
	}
	
	public Boolean call() throws Exception {
		System.out.println("call " + mm.getMethodName());
		return true;
	}

}
