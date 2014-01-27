package fr.clunven.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Data structure representing a Graphe.
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class Graph < N, E > {
	
	/**
	 * Store vertices as key/value.
	 */
	private Map < String, Vertex < N > > mapOfVertices = new LinkedHashMap<String, Vertex<N>>();
	
	/**
	 * Store edges as list.
	 */
	private List < Edge < E > > listOfEdges = new ArrayList < Edge < E > >();
	
	/**
	 * Constructor for Graph.
	 *
	 * @param edges
	 * 		edges
	 */
	public Graph(List < Edge < E > > edges) {
		this.listOfEdges = edges;
	}
	
	/**
	 * Remove doublons of same Vertex.
	 */
	public void removeDoublon() {
		List <Edge<E> > edgestoDelete = new ArrayList<Edge<E>>();
		for (Edge<E> edge : listOfEdges) {
			Edge<E> alterEdge = new Edge<E>(edge.getTail(), edge.getHead());
			if (listOfEdges.contains(alterEdge) && !edgestoDelete.contains(alterEdge)) {
				edgestoDelete.add(edge);
			}
		}
		listOfEdges.removeAll(edgestoDelete);
	}

	/**
	 * If build only with edges it will create nodes.
	 */
	public void buildNodesFromEdges() {
		mapOfVertices = new LinkedHashMap<String, Vertex<N>>();
		for (Edge<E> edge : listOfEdges) {
			if (!mapOfVertices.containsKey(edge.getHead())) {
				mapOfVertices.put(edge.getHead(), new Vertex<N>(edge.getHead()));
			}
			if (!mapOfVertices.containsKey(edge.getTail())) {
				mapOfVertices.put(edge.getTail(), new Vertex<N>(edge.getTail()));
			}
			mapOfVertices.get(edge.getHead()).getAdjacentVertices().add(edge.getTail());
		}
	}
}
