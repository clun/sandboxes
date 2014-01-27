package fr.clunven.aspectj;

import java.util.Collections;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.clunven.profiler.SampleService;
import fr.clunven.profiler.report.Report;
import fr.clunven.profiler.report.ReportManager;

public class SampleProfilingMain extends TestCase {
	
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext cpxapc = new ClassPathXmlApplicationContext("applicationContext.xml");
		SampleService ss = cpxapc.getBean(SampleService.class);
		Report mm = new Report("com.sample", "ClassX", "methodY", System.currentTimeMillis(), System.currentTimeMillis());
		
		//ss.methodeLowLog("aaa", mm);
		Thread.sleep(2000);
		ss.methodeLotOfLog("bbb", mm);
		Thread.sleep(2000);
		//ss.methodeLowLog("ccc", mm);
		Thread.sleep(2000);
		ss.methodeLotOfLog("ddd", mm);
		
		Collections.sort(ReportManager.getInstance().getRecordList());
		
	}

}
