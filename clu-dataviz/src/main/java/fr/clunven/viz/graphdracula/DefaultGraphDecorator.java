package fr.clunven.viz.graphdracula;

import fr.clunven.domain.graph.Edge;
import fr.clunven.domain.graph.Vertex;

/**
 * A default implementation to render Nodes and Edges of a Graph.
 * 
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class DefaultGraphDecorator implements GraphDecorator<String, Integer > {

	/** {@inheritDoc} */
	public VertexStyle getVertexStyle(Vertex<String> vertex) {
		return new VertexStyle();
	}

	/** {@inheritDoc} */
	public EdgeStyle getEdgeStyle(Edge<Integer> edge) {
		return null;
	}

}
