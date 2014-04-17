package fr.clunven.viz.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Pojo to draw bubbles with jqplots.
 * 
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class BubbleChartData {
    
    /** Data Series. */
    private Map<String, PointData> series = new HashMap<String, PointData>();

    /**
     * Getter accessor for attribute 'series'.
     * 
     * @return current value of 'series'
     */
    public Map<String, PointData> getSeries() {
        return series;
    }

    /**
     * Setter accessor for attribute 'series'.
     * 
     * @param series
     *            new value for 'series '
     */
    public void setSeries(Map<String, PointData> series) {
        this.series = series;
    }

}
