package fr.clunven.viz.graphdracula;

public class VertexStyle {

	private DisplayFont font = new DisplayFont();
	
	private int borderWidth = 2;
	
	private String borderColor = "#000";
	
	private String fillColor = "#fff";
	
	/** ACTIONS **/ 
	
	private String onclick = null;
	
	private String ondblClick = null;
	
	private String tooltipText = null;
	
	/**
	 * Getter accessor for attribute 'tooltipText'.
	 *
	 * @return
	 *       current value of 'tooltipText'
	 */
	public String getTooltipText() {
		return tooltipText;
	}

	/**
	 * Setter accessor for attribute 'tooltipText'.
	 * @param tooltipText
	 * 		new value for 'tooltipText '
	 */
	public void setTooltipText(String tooltipText) {
		this.tooltipText = tooltipText;
	}

	/**
	 * Getter accessor for attribute 'borderWidth'.
	 *
	 * @return
	 *       current value of 'borderWidth'
	 */
	public int getBorderWidth() {
		return borderWidth;
	}

	/**
	 * Setter accessor for attribute 'borderWidth'.
	 * @param borderWidth
	 * 		new value for 'borderWidth '
	 */
	public void setBorderWidth(int borderWidth) {
		this.borderWidth = borderWidth;
	}

	/**
	 * Getter accessor for attribute 'borderColor'.
	 *
	 * @return
	 *       current value of 'borderColor'
	 */
	public String getBorderColor() {
		return borderColor;
	}

	/**
	 * Setter accessor for attribute 'borderColor'.
	 * @param borderColor
	 * 		new value for 'borderColor '
	 */
	public void setBorderColor(String borderColor) {
		this.borderColor = borderColor;
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
	 * Getter accessor for attribute 'onclick'.
	 *
	 * @return
	 *       current value of 'onclick'
	 */
	public String getOnclick() {
		return onclick;
	}

	/**
	 * Setter accessor for attribute 'onclick'.
	 * @param onclick
	 * 		new value for 'onclick '
	 */
	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	/**
	 * Getter accessor for attribute 'ondblClick'.
	 *
	 * @return
	 *       current value of 'ondblClick'
	 */
	public String getOndblClick() {
		return ondblClick;
	}

	/**
	 * Setter accessor for attribute 'ondblClick'.
	 * @param ondblClick
	 * 		new value for 'ondblClick '
	 */
	public void setOndblClick(String ondblClick) {
		this.ondblClick = ondblClick;
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
