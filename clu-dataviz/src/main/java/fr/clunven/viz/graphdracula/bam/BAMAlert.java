package fr.clunven.viz.graphdracula.bam;

import java.io.Serializable;

/**
 * Current application alert.
 * 
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class BAMAlert implements Serializable {

    /** Serial. */
    private static final long serialVersionUID = -1399223743649332877L;

    private String name;

    private String applicationName;

    private String businessChain;

    private String severity;

    private long timestamp;

    public BAMAlert() {}

    /**
     * Parameterized constructor.
     * 
     * @param name
     *            traget
     * @param applicationName
     * 
     * @param businessChain
     */
    public BAMAlert(String name, String applicationName, String businessChain) {
        super();
        this.name = name;
        this.applicationName = applicationName;
        this.businessChain = businessChain;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * Getter accessor for attribute 'name'.
     * 
     * @return current value of 'name'
     */
    public String getName() {
        return name;
    }

    /**
     * Setter accessor for attribute 'name'.
     * 
     * @param name
     *            new value for 'name '
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter accessor for attribute 'applicationName'.
     * 
     * @return current value of 'applicationName'
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * Setter accessor for attribute 'applicationName'.
     * 
     * @param applicationName
     *            new value for 'applicationName '
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    /**
     * Getter accessor for attribute 'businessChain'.
     * 
     * @return current value of 'businessChain'
     */
    public String getBusinessChain() {
        return businessChain;
    }

    /**
     * Setter accessor for attribute 'businessChain'.
     * 
     * @param businessChain
     *            new value for 'businessChain '
     */
    public void setBusinessChain(String businessChain) {
        this.businessChain = businessChain;
    }

    /**
     * Getter accessor for attribute 'severity'.
     * 
     * @return current value of 'severity'
     */
    public String getSeverity() {
        return severity;
    }

    /**
     * Setter accessor for attribute 'severity'.
     * 
     * @param severity
     *            new value for 'severity '
     */
    public void setSeverity(String severity) {
        this.severity = severity;
    }

    /**
     * Getter accessor for attribute 'timestamp'.
     * 
     * @return current value of 'timestamp'
     */
    public long getTimestamp() {
        return timestamp;
    }

    /**
     * Setter accessor for attribute 'timestamp'.
     * 
     * @param timestamp
     *            new value for 'timestamp '
     */
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Getter accessor for attribute 'serialversionuid'.
     * 
     * @return current value of 'serialversionuid'
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    // ---------- POJO Utilities ----------

    /** {@inheritDoc} */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((applicationName == null) ? 0 : applicationName.hashCode());
        result = prime * result + ((businessChain == null) ? 0 : businessChain.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((severity == null) ? 0 : severity.hashCode());
        result = prime * result + (int) (timestamp ^ (timestamp >>> 32));
        return result;
    }

    /** {@inheritDoc} */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BAMAlert other = (BAMAlert) obj;
        if (applicationName == null) {
            if (other.applicationName != null)
                return false;
        } else if (!applicationName.equals(other.applicationName))
            return false;
        if (businessChain == null) {
            if (other.businessChain != null)
                return false;
        } else if (!businessChain.equals(other.businessChain))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (severity == null) {
            if (other.severity != null)
                return false;
        } else if (!severity.equals(other.severity))
            return false;
        if (timestamp != other.timestamp)
            return false;
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "ApplicationAlert [name=" + name + ", applicationName=" + applicationName + ", businessChain=" + businessChain
                + ", severity=" + severity + ", timestamp=" + timestamp + "]";
    }

}
