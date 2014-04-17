package fr.clunven.viz.graphdracula;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.clunven.domain.graph.Edge;
import fr.clunven.domain.graph.Graph;
import fr.clunven.domain.graph.Vertex;
import fr.clunven.viz.graphdracula.bam.BAMGraphBuilder;

/**
 * Taglib to produce a Graph using GraphDracula library.
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class GraphTag extends TagSupport {

	/** serial. */
	private static final long serialVersionUID = -1339512982027687771L;
	
	/** logger */
	private static Logger LOGGER = LoggerFactory.getLogger(GraphTag.class);
	
	/** width */
	private String width = "$(document).width() - 20";
	
	/** height */
	private String height = "$(document).height() - 20";
	
	/** Target DIV for this TAG. */
	private String divId = "";
	
	/** Name of Graph Object contain in request. */
	private String paramName = "";
	
	/** Decorator. */
	private String decorator = "";
	
	/** Style of div */
	private String cssStyle = "";
	
	/** Style of dev. */
	private String cssClass = "";
	
	/** {@inheritDoc} */
	@Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int doStartTag() throws JspException {
		try {
			LOGGER.debug("Initializing GRAPH");
			
			Graph myGraph = (Graph<?, ?>) pageContext.findAttribute(paramName);
            myGraph = BAMGraphBuilder.getGraph();
			
            StringBuilder mainSB = new StringBuilder("<script>\n");
            mainSB.append("var redraw;\n");
            mainSB.append("window.onload = function() {\n");
            mainSB.append("  var width  = " + width + ";\n");
            mainSB.append("  var height = " + height + ";\n\n");

			if (myGraph != null) {
				GraphDecorator deco = null;
				if (!"".equals(decorator)) {
					Class decoClazz = Class.forName(decorator);
					deco = (GraphDecorator) decoClazz.newInstance();
                    if (deco.getDefaultVertexStyle() != null) {
                        mainSB.append("  var defaultRender = " + getVertexRenderFunction(deco.getDefaultVertexStyle()) + ";\n\n");
                    } else {
                        mainSB.append("  var defaultRender = " + getVertexRenderFunction(new VertexStyle()) + ";\n\n");
                    }
                }

                mainSB.append("  var g = new Graph();\n");
                if (myGraph != null && myGraph.isDirected()) {
					mainSB.append(" g.edgeFactory.template.style.directed = true;\n");
				}
				Map<String, Vertex<?>> vertices = myGraph.getVertices();
				for (String vKey : vertices.keySet()) {
					Vertex v = vertices.get(vKey);
					mainSB.append("   g.addNode(\"" + v.getLabel() + "\", { label : \"" );
					mainSB.append(v.getLabel() + "\"");

                    // Fixed Position
                    if (v.getCoordX() > 0 && v.getCoordY() > 0) {
                        mainSB.append(", x: " + v.getCoordX());
                        mainSB.append(", y: " + v.getCoordY());
                    }

					if (deco == null) {
						mainSB.append(", render:defaultRender ");
						mainSB.append("} );\n");
					} else {
						mainSB.append(", render:" + getVertexRenderFunction(deco.getVertexStyle(v)).replaceAll("\\n", ""));
						mainSB.append("} );\n");
					}
				}
				
				List <Edge> edges = myGraph.getEdges();
				for (Edge edge : edges) {
					mainSB.append("   g.addEdge(\"" + edge.getHead() + "\", \"" + edge.getTail() + "\");\n");
				}
				
                // if (fixedLayout) {
                // mainSB.append("  var layouter = new Graph.Layout.Spring(g);\n");
                // } else {
                    mainSB.append("  var layouter = new Graph.Layout.Fixed(g);\n");
                // }
				mainSB.append("  var renderer = new Graph.Renderer.Raphael('" + divId + "', g, width, height);\n\n");
				mainSB.append("  redraw = function() {\n");
				mainSB.append("     layouter.layout();\n");
				mainSB.append("     renderer.draw();\n");
				mainSB.append("  };\n");
				mainSB.append("};\n");
				mainSB.append("</script>\n");
				mainSB.append("<div id=\"" + divId + "\"");
				mainSB.append(" style=\"");
				mainSB.append("width:" + width + "px;");
				mainSB.append("height:" + height + "px;");
				if (!"".equals(cssStyle)) {
					mainSB.append(cssStyle);
				}
				mainSB.append("\"");
				if (!"".equals(cssClass)) {
					mainSB.append(" class=\"" + cssClass + "\"");
				}
				
			 	mainSB.append("></div>\n");
				
				pageContext.getOut().println(mainSB.toString());
			
			}// else {
			//	pageContext.getOut().println("No attribute '" + paramName + "' found within page,session,request,application scope(s)....");
			//}
		} catch (IOException ioe) {
			throw new JspException("An error occured when rendering GRAPH : ", ioe);
		} catch (ClassNotFoundException e) {
			throw new JspException("Cannot find class for decorator '" + decorator + "', please check classpath.", e);
		} catch (InstantiationException e) {
			throw new JspException("Cannot instanciate decorator '" + decorator + "', please check existence of default constructor.", e);
		} catch (IllegalAccessException e) {
			throw new JspException("Cannot use decorator '" + decorator + "', please check classpath.", e);
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
	private String getVertexRenderFunction(VertexStyle vs) {
		StringBuilder sb = new StringBuilder("function(r, n) {\n");
		// compute width from text and et a minimum of 60
	    sb.append("    var fwidth = Math.max(n.label.length * 6 * 14/12, 60);\n");
	    sb.append("    return r.set().push(\n");
	    sb.append("      r.rect(n.point[0]-fwidth/2, n.point[1]-13, fwidth, 44).attr({");
        sb.append("\"fill\": \"" + vs.getFillColor() + "\",\"fill-opacity\":1,");
	    sb.append("r : \"" + vs.getFont().getSize() + "px\",");
	    sb.append("\"stroke\": \"" + vs.getBorderColor() + "\",");
	    sb.append("\"stroke-width\": \"" + vs.getBorderWidth() + "px\"");
	    sb.append("})).push(\n      r.text(n.point[0], n.point[1] + 10, n.label).attr( {");
	    sb.append("\"stroke\": \"" + vs.getFont().getColor() + "\",");
	    sb.append("\"font-size\": " + vs.getFont().getSize() + ",");
	    sb.append("\"font-family\": \"" + vs.getFont().getFamily() + "\" }));\n");
	    sb.append("  }");
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
	 * Getter accessor for attribute 'divId'.
	 *
	 * @return
	 *       current value of 'divId'
	 */
	public String getDivId() {
		return divId;
	}

	/**
	 * Setter accessor for attribute 'divId'.
	 * @param divId
	 * 		new value for 'divId '
	 */
	public void setDivId(String divId) {
		this.divId = divId;
	}


	/**
	 * Getter accessor for attribute 'cssStyle'.
	 *
	 * @return
	 *       current value of 'cssStyle'
	 */
	public String getCssStyle() {
		return cssStyle;
	}


	/**
	 * Setter accessor for attribute 'cssStyle'.
	 * @param cssStyle
	 * 		new value for 'cssStyle '
	 */
	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}


	/**
	 * Getter accessor for attribute 'cssClass'.
	 *
	 * @return
	 *       current value of 'cssClass'
	 */
	public String getCssClass() {
		return cssClass;
	}


	/**
	 * Setter accessor for attribute 'cssClass'.
	 * @param cssClass
	 * 		new value for 'cssClass '
	 */
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	

}
