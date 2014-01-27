package fr.clunven.profiler.report;

public class Report implements Comparable< Report > {
	
	private String packageName;

	private String className;
	
	private String methodName;
	
	private long startTime;
	
	private long endTime;
	
	public Report(String ppackageName, String pclassName, String pmethodName, long pstartTime, long pendTime) {
		super();
		this.packageName = ppackageName;
		this.className 	 = pclassName;
		this.methodName  = pmethodName;
		this.startTime 	 = pstartTime;
		this.endTime 	 = pendTime;
	}

	public int compareTo(Report o) {
		return (int)(endTime - startTime) - (int)(o.endTime - o.startTime);
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * @param methodName the methodName to set
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * @return the startTime
	 */
	public long getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public long getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	/**
	 * @return the packageName
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 * @param packageName the packageName to set
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
}
