package fr.clunven.viz.domain;

/**
 * Bean to generate a point on a GRAPH.
 * 
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class PointData {

    private double x = 0;

    private double y = 0;

    private double value = 1;

    public PointData(double x, double y, double value) {
        super();
        this.x = x;
        this.y = y;
        this.value = value;
    }

    /**
     * Getter accessor for attribute 'x'.
     * 
     * @return current value of 'x'
     */
    public double getX() {
        return x;
    }

    /**
     * Setter accessor for attribute 'x'.
     * 
     * @param x
     *            new value for 'x '
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Getter accessor for attribute 'y'.
     * 
     * @return current value of 'y'
     */
    public double getY() {
        return y;
    }

    /**
     * Setter accessor for attribute 'y'.
     * 
     * @param y
     *            new value for 'y '
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Getter accessor for attribute 'value'.
     * 
     * @return current value of 'value'
     */
    public double getValue() {
        return value;
    }

    /**
     * Setter accessor for attribute 'value'.
     * 
     * @param value
     *            new value for 'value '
     */
    public void setValue(double value) {
        this.value = value;
    }

}
