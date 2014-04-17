package fr.clunven.viz.domain;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PieChartData {

    /** Map for analazing DATA. */
    private Map<String, Double> series = new HashMap<String, Double>();

    /**
     * Getter accessor for attribute 'series'.
     * 
     * @return current value of 'series'
     */
    public Map<String, Double> getSeries() {
        return series;
    }

    /**
     * Setter accessor for attribute 'series'.
     * 
     * @param series
     *            new value for 'series '
     */
    public void setSeries(Map<String, Double> series) {
        this.series = series;
    }

}
