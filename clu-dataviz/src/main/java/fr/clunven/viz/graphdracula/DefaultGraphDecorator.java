package fr.clunven.viz.graphdracula;

import fr.clunven.domain.graph.Edge;
import fr.clunven.domain.graph.Vertex;

/**
 * A default implementation to render Nodes and Edges of a Graph.
 * 
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class DefaultGraphDecorator implements GraphDecorator<String, Integer > {
	
	/** default vertex style. */
	private static VertexStyle DEFAULT_VERTEX_STYLE = new VertexStyle();
	
	/** default vertex style. */
	private static EdgeStyle DEFAULT_EDGE_STYLE = new EdgeStyle();
	
	/** {@inheritDoc} */
	public VertexStyle getVertexStyle(Vertex<String> vertex) {
		return DEFAULT_VERTEX_STYLE;
	}

	/** {@inheritDoc} */
	public EdgeStyle getEdgeStyle(Edge<Integer> edge) {
		return DEFAULT_EDGE_STYLE;
	}

}
