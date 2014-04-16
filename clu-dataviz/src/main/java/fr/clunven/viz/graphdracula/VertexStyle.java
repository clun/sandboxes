package fr.clunven.viz.graphdracula;

/**
 * Customization of GraphNode
 * 
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class VertexStyle {

    /** Font. */
	private DisplayFont font = new DisplayFont();
	
    /** Border width. */
	private int borderWidth = 2;
	
    /** Border color. */
	private String borderColor = "#000";
	
    /** Draw color. */
	private String fillColor = "#fff";
	
    /** Action on CLIC **/
    private String clicAction = null;
	
    /** I enabled, will propose clic action. */
    private boolean cliquable = false;

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

    /**
     * Getter accessor for attribute 'cliquable'.
     * 
     * @return current value of 'cliquable'
     */
    public boolean isCliquable() {
        return cliquable;
    }

    /**
     * Setter accessor for attribute 'cliquable'.
     * 
     * @param cliquable
     *            new value for 'cliquable '
     */
    public void setCliquable(boolean cliquable) {
        this.cliquable = cliquable;
    }

    /**
     * Getter accessor for attribute 'clicAction'.
     * 
     * @return current value of 'clicAction'
     */
    public String getClicAction() {
        return clicAction;
    }

    /**
     * Setter accessor for attribute 'clicAction'.
     * 
     * @param clicAction
     *            new value for 'clicAction '
     */
    public void setClicAction(String clicAction) {
        this.clicAction = clicAction;
    }

}
