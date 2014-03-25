package fr.clunven.viz.graphdracula;

import fr.clunven.domain.graph.Edge;
import fr.clunven.domain.graph.Vertex;

/**
 * Renderer of a graph.
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public interface GraphDecorator {
	
	/**
	 * This default style will be applied if no custom style defined. 
	 * @return
	 * 		default Style
	 */
	VertexStyle getDefaultVertexStyle();
	
	/**
	 * If set to true all.
	 *
	 * @return
	 * 		tell if graph is directed
	 */
	boolean isDirected();
	
	VertexStyle getVertexStyle(Vertex<String> vertex);
	
	EdgeStyle getEdgeStyle(Edge < String > edge);

}
