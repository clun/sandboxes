package fr.clunven.domain.graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import fr.clunven.viz.graphdracula.VertexStyle;

/**
 * Data structure representing a Graphe.
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class Graph < N, E > {
	
	/**
	 * Store vertices as key/value.
	 */
	private Map < String, Vertex < N > > vertices = new LinkedHashMap<String, Vertex<N>>();
	
	/** Store edges as list. */
	private List < Edge < E > > edges = new ArrayList < Edge < E > >();
	
	/** Force all edges as directed. */
    private boolean directed = false;
	
	/**
	 * Constructor for Graph.
	 *
	 * @param edges
	 * 		edges
	 */
	public Graph() {
	}
	
	    /**
     * Constructor for Graph.
     * 
     * @param edges
     *            edges
     */
    public Graph(boolean d) {
        this.directed = d;
    }

    /**
     * Constructor for Graph.
     * 
     * @param edges
     *            edges
     */
	public Graph(List < Edge < E > > edges) {
		this.edges = edges;
	}
	
	/**
	 * Convenience method to add vertex.
	 * 
	 * @param v
	 * 	target vertex
	 */
	public void addVertex(Vertex<N> v) {
		vertices.put(v.getLabel(), v);
	}
	
	    /**
     * Convenience method to add vertex.
     * 
     * @param v
     *            target vertex
     */
    public void addVertex(Vertex<N> vn, VertexStyle vs) {
        vn.setStyle(vs);
        vertices.put(vn.getLabel(), vn);
    }

    /**
     * Convenience method to add edge.
     * 
     * @param v
     *            target vertex
     */
	
	public void addEdge(Edge<E> edge) {
		edges.add(edge);
	}
	
	/**
	 * Remove doublons of same Vertex.
	 */
	public void removeDoublon() {
		List <Edge<E> > edgestoDelete = new ArrayList<Edge<E>>();
		for (Edge<E> edge : edges) {
			Edge<E> alterEdge = new Edge<E>(edge.getTail(), edge.getHead());
			if (edges.contains(alterEdge) && !edgestoDelete.contains(alterEdge)) {
				edgestoDelete.add(edge);
			}
		}
		edges.removeAll(edgestoDelete);
	}

	/**
	 * If build only with edges it will create nodes.
	 */
	public void buildNodesFromEdges() {
        // vertices = new LinkedHashMap<String, Vertex<N>>();
		for (Edge<E> edge : edges) {
			if (!vertices.containsKey(edge.getHead())) {
				vertices.put(edge.getHead(), new Vertex<N>(edge.getHead()));
			}
			if (!vertices.containsKey(edge.getTail())) {
				vertices.put(edge.getTail(), new Vertex<N>(edge.getTail()));
			}
			vertices.get(edge.getHead()).getAdjacentVertices().add(edge.getTail());
		}
	}

	/**
	 * Getter accessor for attribute 'vertices'.
	 *
	 * @return
	 *       current value of 'vertices'
	 */
	public Map<String, Vertex<N>> getVertices() {
		return vertices;
	}

	/**
	 * Setter accessor for attribute 'vertices'.
	 * @param vertices
	 * 		new value for 'vertices '
	 */
	public void setVertices(Map<String, Vertex<N>> vertices) {
		this.vertices = vertices;
	}

	/**
	 * Getter accessor for attribute 'edges'.
	 *
	 * @return
	 *       current value of 'edges'
	 */
	public List<Edge<E>> getEdges() {
		return edges;
	}

	/**
	 * Setter accessor for attribute 'edges'.
	 * @param edges
	 * 		new value for 'edges '
	 */
	public void setEdges(List<Edge<E>> edges) {
		this.edges = edges;
	}

    /**
     * Getter accessor for attribute 'directed'.
     * 
     * @return current value of 'directed'
     */
    public boolean isDirected() {
        return directed;
    }

    /**
     * Setter accessor for attribute 'directed'.
     * 
     * @param directed
     *            new value for 'directed '
     */
    public void setDirected(boolean directed) {
        this.directed = directed;
    }
}
