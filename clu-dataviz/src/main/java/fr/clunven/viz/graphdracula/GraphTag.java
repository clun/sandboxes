package fr.clunven.viz.graphdracula;

import java.io.IOException;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import fr.clunven.domain.graph.Graph;
import fr.clunven.domain.graph.Vertex;

/**
 * Taglib to produce a Graph using GraphDracula library.
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class GraphTag extends TagSupport {

	/** serial. */
	private static final long serialVersionUID = -1339512982027687771L;
	
	/** Default decorator. */
	private static final GraphDecorator<?, ?> DEFAULT_DECORATOR = new DefaultGraphDecorator();
	
	/** width */
	private String width = "$(document).width() - 20";
	
	/** height */
	private String height = "$(document).height() - 20";
	
	/** Target DIV for this TAG. */
	private String target = "";
	
	/** Name of Graph Object contain in request. */
	private String paramName = "";
	
	/** Decorator. */
	private String decorator = "";
	
	/** {@inheritDoc} */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int doAfterBody() throws JspException {
		try {
			Graph myGraph = (Graph<?, ?>) pageContext.findAttribute(paramName);
			if (myGraph != null) {
				GraphDecorator<?,?> graphDecorator = this.getGraphDecorator();
				StringBuilder mainSB = new StringBuilder("<script>\n");
				mainSB.append("var redraw;\n");
				mainSB.append("window.onload = function() {\n");
				mainSB.append("  var width  = " + width  + ";\n");
				mainSB.append("  var height = " + height + ";\n");
				mainSB.append("  var g        = new Graph();\n");
				// Here Populating GRAPH
				Map<String, Vertex<?>> vertices = myGraph.getVertices();
				for (String vKey : vertices.keySet()) {
					Vertex v = vertices.get(vKey);
				}
				
				
				mainSB.append("  var layouter = new Graph.Layout.Spring(g);\n");
				mainSB.append("  var renderer = new Graph.Renderer.Raphael('" + target + "', g, width, height);\n\n");
				mainSB.append("  redraw = function() {\n");
				mainSB.append("     layouter.layout();\n");
				mainSB.append("     renderer.draw();\n");
				mainSB.append("  };\n");
				mainSB.append("};\n");
				mainSB.append("</script>\n");
			} else {
				pageContext.getOut().println("No attribute '" + paramName + "' found within page,session,request,application scope(s)....");
			}
		} catch (IOException ioe) {
			throw new JspException("An error occured when rendering GRAPH : ", ioe);
		}
		return SKIP_BODY;
	}
	
	
	/**
	 * Function to render node.
	 * @param vs
	 * 		vertex style
	 * @return
	 * 		style for Vertex
	 */
	private String getRenderFunction(VertexStyle vs) {
		StringBuilder sb = new StringBuilder("function(r, n) {\n");
		// compute width from text and et a minimum of 60
	    sb.append("var width = Math.max(n.label.length * 6 * 14/12, 60);\n");
	    sb.append("var set = r.set();\n");
	    sb.append("	   set.push(\n");
	    sb.append("r.rect(n.point[0]-width/2, n.point[1]-13, width, 44).attr({\n");
	    sb.append("\"fill\": \"" + vs.getFillColor() + "\",\n");
	    sb.append("r : \"" + vs.getFontSize() + "px\",\n");
	    sb.append("\"stroke\": \"" + vs.getBorderColor() + "\",");
	    sb.append("\"stroke-width\": \"" + vs.getBorderWidth() + "\"px");
	    sb.append("})).push(r.text(n.point[0], n.point[1] + 10, n.label).attr( {");
	    sb.append("\"stroke\": \"" + vs.getFontColor() + "\",");
	    sb.append("\"font-size\": " + vs.getFontSize() + ",");
	    sb.append("\"font-family\": \"" + vs.getFontFamily() + "\" }));");       
	    sb.append("return set;");
	    sb.append("};");
	    return sb.toString();
	}
	
	
	/**
	 * Retrieves {@link GraphDecorator} from attributes values.
	 *  
	 * @return
	 * 		target graph decorator
	 * @throws IOException
	 * 		error during instanciation
	 */
	private GraphDecorator<?,?> getGraphDecorator() throws IOException {
		if (!"".equals(decorator)) {
			try {
				return (GraphDecorator<?, ?>) Class.forName(decorator).newInstance();
			} catch (ClassNotFoundException e) {
				pageContext.getOut().println("'" + decorator + "' is not a valid decorator className : Class Not Found" + e.getMessage());
				throw new IOException(e);
			} catch (InstantiationException e) {
				pageContext.getOut().println("'" + decorator + "' is not a valid decorator className : Cannot instanciate (public constructor?)" + e.getMessage());
				throw new IOException(e);
			} catch (IllegalAccessException e) {
				pageContext.getOut().println("'" + decorator + "' is not a valid decorator className :" + e.getMessage());
				throw new IOException(e);
			}
		} else {
			return DEFAULT_DECORATOR;
		}
	}
	
	/**
	 * Allow to declare a node within graph.
	 * @param nodeName
	 * 		target node
	 * @return
	 * 		string for this node
	 */
	private String addNode(String nodeName) {
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

	/**
	 * Getter accessor for attribute 'paramName'.
	 *
	 * @return
	 *       current value of 'paramName'
	 */
	public String getParamName() {
		return paramName;
	}

	/**
	 * Setter accessor for attribute 'paramName'.
	 * @param paramName
	 * 		new value for 'paramName '
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	/**
	 * Getter accessor for attribute 'decorator'.
	 *
	 * @return
	 *       current value of 'decorator'
	 */
	public String getDecorator() {
		return decorator;
	}

	/**
	 * Setter accessor for attribute 'decorator'.
	 * @param decorator
	 * 		new value for 'decorator '
	 */
	public void setDecorator(String decorator) {
		this.decorator = decorator;
	}
	/**
	 * Getter accessor for attribute 'target'.
	 *
	 * @return
	 *       current value of 'target'
	 */
	public String getTarget() {
		return target;
	}
	/**
	 * Setter accessor for attribute 'target'.
	 * @param target
	 * 		new value for 'target '
	 */
	public void setTarget(String target) {
		this.target = target;
	}

}
