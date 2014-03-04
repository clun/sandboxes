package fr.clunven.viz.graphdracula;

import java.io.Serializable;

/**
 * POJO to render a graph edge.
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class EdgeStyle implements Serializable {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -527564325967755427L;

	/**
	 * label for the edge
	 */
	private String label = "";
	
	/**
	 * if directed.
	 */
	private boolean directed = false;
	
	/**
	 * Color of wire
	 */
	private String color = "#000";
	
	/**
	 * Fill color
	 */
	private String fillColor = null;
	
	/**
	 * Choose color for label
	 */
	private DisplayFont font = new DisplayFont();

	/**
	 * Getter accessor for attribute 'label'.
	 *
	 * @return
	 *       current value of 'label'
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Setter accessor for attribute 'label'.
	 * @param label
	 * 		new value for 'label '
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Getter accessor for attribute 'directed'.
	 *
	 * @return
	 *       current value of 'directed'
	 */
	public boolean isDirected() {
		return directed;
	}

	/**
	 * Setter accessor for attribute 'directed'.
	 * @param directed
	 * 		new value for 'directed '
	 */
	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	/**
	 * Getter accessor for attribute 'color'.
	 *
	 * @return
	 *       current value of 'color'
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Setter accessor for attribute 'color'.
	 * @param color
	 * 		new value for 'color '
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Getter accessor for attribute 'fillColor'.
	 *
	 * @return
	 *       current value of 'fillColor'
	 */
	public String getFillColor() {
		return fillColor;
	}

	/**
	 * Setter accessor for attribute 'fillColor'.
	 * @param fillColor
	 * 		new value for 'fillColor '
	 */
	public void setFillColor(String fillColor) {
		this.fillColor = fillColor;
	}

	/**
	 * Getter accessor for attribute 'font'.
	 *
	 * @return
	 *       current value of 'font'
	 */
	public DisplayFont getFont() {
		return font;
	}

	/**
	 * Setter accessor for attribute 'font'.
	 * @param font
	 * 		new value for 'font '
	 */
	public void setFont(DisplayFont font) {
		this.font = font;
	}
	
}
