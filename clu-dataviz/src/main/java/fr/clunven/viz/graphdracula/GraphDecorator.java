package fr.clunven.viz.graphdracula;

import fr.clunven.domain.graph.Edge;
import fr.clunven.domain.graph.Vertex;

public interface GraphDecorator<VERTEX, EDGE> {
	
	VertexStyle getVertexStyle(Vertex<VERTEX> vertex);
	
	EdgeStyle getEdgeStyle(Edge<EDGE> edge);

}
