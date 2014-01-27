package fr.clunven.asynchronous;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import fr.clunven.profiler.report.Report;

public class SampleFutureTaskMain {
	
	public static void main(String[] args) {
		Report mm = new Report("", "", "methodName", 0, 0);
		ExecutorService executor = Executors.newFixedThreadPool(1);
		executor.execute(new FutureTask<Boolean>(new SampleCallable(mm)));
		executor.execute(new FutureTask<Boolean>(new SampleCallable(mm)));
		executor.execute(new FutureTask<Boolean>(new SampleCallable(mm)));
		executor.execute(new FutureTask<Boolean>(new SampleCallable(mm)));
		executor.execute(new FutureTask<Boolean>(new SampleCallable(mm)));
		executor.execute(new FutureTask<Boolean>(new SampleCallable(mm)));
		executor.execute(new FutureTask<Boolean>(new SampleCallable(mm)));
		executor.execute(new FutureTask<Boolean>(new SampleCallable(mm)));
		executor.execute(new FutureTask<Boolean>(new SampleCallable(mm)));
	}
	
}