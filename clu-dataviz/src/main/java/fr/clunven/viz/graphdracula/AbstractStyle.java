package fr.clunven.viz.graphdracula;

/**
 * Super class for render graph.
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public abstract class AbstractStyle {
	
	/** Font family. */
	private String fontFamily = "Arial, Helvetica, sans-serif";
	
	/** Font Size */
	private int fontSize = 14;
	
	/** Font Color */
	private String fontColor = "#000";
	
	/** If of Form */
	private String id = null;
	
	/**
	 * Getter accessor for attribute 'fontFamily'.
	 *
	 * @return
	 *       current value of 'fontFamily'
	 */
	public String getFontFamily() {
		return fontFamily;
	}

	/**
	 * Setter accessor for attribute 'fontFamily'.
	 * @param fontFamily
	 * 		new value for 'fontFamily '
	 */
	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}

	/**
	 * Getter accessor for attribute 'fontSize'.
	 *
	 * @return
	 *       current value of 'fontSize'
	 */
	public int getFontSize() {
		return fontSize;
	}

	/**
	 * Setter accessor for attribute 'fontSize'.
	 * @param fontSize
	 * 		new value for 'fontSize '
	 */
	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	/**
	 * Getter accessor for attribute 'fontColor'.
	 *
	 * @return
	 *       current value of 'fontColor'
	 */
	public String getFontColor() {
		return fontColor;
	}

	/**
	 * Setter accessor for attribute 'fontColor'.
	 * @param fontColor
	 * 		new value for 'fontColor '
	 */
	public void setFontColor(String fontColor) {
		this.fontColor = fontColor;
	}

	/**
	 * Getter accessor for attribute 'id'.
	 *
	 * @return
	 *       current value of 'id'
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter accessor for attribute 'id'.
	 * @param id
	 * 		new value for 'id '
	 */
	public void setId(String id) {
		this.id = id;
	}
}
