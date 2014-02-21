package fr.clunven.viz.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import fr.clunven.viz.domain.graph.Graph;

public class GraphDraculaTagRender extends TagSupport {

	/** serial. */
	private static final long serialVersionUID = -1339512982027687771L;
	
	/** width */
	private String width = "$(document).width() - 20";
	
	/** height */
	private String height = "$(document).height() - 20";
	
	/** Name of Graph Object contain in request. */
	private String paramName = "";

	/** {@inheritDoc} */
	@Override
	public int doAfterBody() throws JspException {
		try {
			Graph<?, ?> myGraph = (Graph<?, ?>) pageContext.findAttribute(paramName);
			if (myGraph != null) {
				
				
			} else {
				pageContext.getOut().println("No attribute '" + paramName + "' found within page,session,request,application scope(s)....");
			}
		} catch (IOException ioe) {
			throw new JspException("Error occur when processing TAG FF4J", ioe);
		}
		return SKIP_BODY;
	}
	
	/**
	 * Allow to declare a node within graph.
	 * @param nodeName
	 * 		target node
	 * @return
	 * 		string for this node
	 */
	public String addNode(String nodeName) {
		StringBuilder sb = new StringBuilder("g.addNode(\"");
		sb.append(nodeName);
		sb.append("\")");
		return sb.toString();
	}

	/**
	 * Getter accessor for attribute 'width'.
	 *
	 * @return
	 *       current value of 'width'
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * Setter accessor for attribute 'width'.
	 * @param width
	 * 		new value for 'width '
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * Getter accessor for attribute 'height'.
	 *
	 * @return
	 *       current value of 'height'
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * Setter accessor for attribute 'height'.
	 * @param height
	 * 		new value for 'height '
	 */
	public void setHeight(String height) {
		this.height = height;
	}

}
