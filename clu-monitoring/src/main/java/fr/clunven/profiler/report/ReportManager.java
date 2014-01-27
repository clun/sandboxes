package fr.clunven.profiler.report;

import java.util.ArrayList;
import java.util.List;



/**
 * Contient toutes les données de profiling. Cela permettra de réaliser un rendu en fin de service.
 *
 * @author clunven
 */
public final class ReportManager {

	private static ReportManager instance;

	/** HashTable < CATEGORY, List < MethodMetrics > .*/ 
	private List < Report >  recordList;

	private ReportManager() {
		recordList = new ArrayList<Report>();
	}
	
	public static synchronized ReportManager getInstance() {
		if (instance == null) {
			instance = new ReportManager();
		}
		return instance;
	}
	
	void publish(Report mm) {
		recordList.add(mm);
	}

	/**
	 * @return the recordList
	 */
	public List<Report> getRecordList() {
		return recordList;
	}

	/**
	 * @param recordList the recordList to set
	 */
	public void setRecordList(List<Report> recordList) {
		this.recordList = recordList;
	}
	
}
