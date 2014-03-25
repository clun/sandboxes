package fr.clunven.viz.samples;

import fr.clunven.domain.graph.Edge;
import fr.clunven.domain.graph.Vertex;
import fr.clunven.viz.graphdracula.EdgeStyle;
import fr.clunven.viz.graphdracula.GraphDecorator;
import fr.clunven.viz.graphdracula.VertexStyle;

public class CustomGraphDecorator implements GraphDecorator {

	private VertexStyle defaultVS = null;
	
	private VertexStyle redVS = null;
	
	@Override
	public VertexStyle getDefaultVertexStyle() {
		if (defaultVS == null) {
			defaultVS = new VertexStyle();
		}
		return defaultVS;
	}

	/** {@inheritDoc} */
	public boolean isDirected() {
		return false;
	}

	@Override
	public VertexStyle getVertexStyle(Vertex<String> vertex) {
		if (redVS == null) {
			redVS = new VertexStyle();
			redVS.getFont().setColor("#f00");
		}
		return vertex.getLabel().contains("A") ? redVS : defaultVS;
	}

	@Override
	public EdgeStyle getEdgeStyle(Edge<String> edge) {
		return new EdgeStyle();
	}
	

}
