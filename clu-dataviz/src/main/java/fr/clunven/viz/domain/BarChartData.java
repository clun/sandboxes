package fr.clunven.viz.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Bar charts with multiple series.
 * 
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
@XmlRootElement
public class BarChartData {

    /** Labels on X axis (values). */
    private final List<String> xLabels = new ArrayList<String>();

    /** Labels for series */
    private final Map<String, List<Double>> series = new HashMap<String, List<Double>>();

    /** change orientation of BAR. */
    private boolean horizontal = false;

    /** staked data. */
    private boolean stacked = false;

    /**
     * Getter accessor for attribute 'xLabels'.
     * 
     * @return current value of 'xLabels'
     */
    public List<String> getxLabels() {
        return xLabels;
    }

    /**
     * Getter accessor for attribute 'series'.
     * 
     * @return current value of 'series'
     */
    public Map<String, List<Double>> getSeries() {
        return series;
    }

    /**
     * Getter accessor for attribute 'horizontal'.
     * 
     * @return current value of 'horizontal'
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * Setter accessor for attribute 'horizontal'.
     * 
     * @param horizontal
     *            new value for 'horizontal '
     */
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * Getter accessor for attribute 'stacked'.
     * 
     * @return current value of 'stacked'
     */
    public boolean isStacked() {
        return stacked;
    }

    /**
     * Setter accessor for attribute 'stacked'.
     * 
     * @param stacked
     *            new value for 'stacked '
     */
    public void setStacked(boolean stacked) {
        this.stacked = stacked;
    }

}
