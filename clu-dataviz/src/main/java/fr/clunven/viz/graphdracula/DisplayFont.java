package fr.clunven.viz.graphdracula;

import java.io.Serializable;

/**
 * Class to render a FONT within draw element
 * 
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class DisplayFont implements Serializable {

	/** serial. */
	private static final long serialVersionUID = -5240151328286939335L;
	
	private static final String FAMILY_ARIAL = "Arial, Helvetica, sans-serif";

	/** Font family. */
	private String family = FAMILY_ARIAL;
	
	/** Font Size */
	private int size = 10;
	
	/** Font Color */
	private String color = "#000";
	
	/** if bold */
	private boolean bold = false;
	
	/** if italic */
	private boolean italic = false;
	
	/** if uderlined */
	private boolean underline = false;
	
	/**
	 * Default constructor.
	 */
	public DisplayFont() {
	}
	
	/**
	 * Getter accessor for attribute 'family'.
	 *
	 * @return
	 *       current value of 'family'
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * Setter accessor for attribute 'family'.
	 * @param family
	 * 		new value for 'family '
	 */
	public void setFamily(String family) {
		this.family = family;
	}

	/**
	 * Getter accessor for attribute 'size'.
	 *
	 * @return
	 *       current value of 'size'
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Setter accessor for attribute 'size'.
	 * @param size
	 * 		new value for 'size '
	 */
	public void setSize(int size) {
		this.size = size;
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
	 * Getter accessor for attribute 'bold'.
	 *
	 * @return
	 *       current value of 'bold'
	 */
	public boolean isBold() {
		return bold;
	}

	/**
	 * Setter accessor for attribute 'bold'.
	 * @param bold
	 * 		new value for 'bold '
	 */
	public void setBold(boolean bold) {
		this.bold = bold;
	}

	/**
	 * Getter accessor for attribute 'italic'.
	 *
	 * @return
	 *       current value of 'italic'
	 */
	public boolean isItalic() {
		return italic;
	}

	/**
	 * Setter accessor for attribute 'italic'.
	 * @param italic
	 * 		new value for 'italic '
	 */
	public void setItalic(boolean italic) {
		this.italic = italic;
	}

	/**
	 * Getter accessor for attribute 'underline'.
	 *
	 * @return
	 *       current value of 'underline'
	 */
	public boolean isUnderline() {
		return underline;
	}

	/**
	 * Setter accessor for attribute 'underline'.
	 * @param underline
	 * 		new value for 'underline '
	 */
	public void setUnderline(boolean underline) {
		this.underline = underline;
	}	
	
}
