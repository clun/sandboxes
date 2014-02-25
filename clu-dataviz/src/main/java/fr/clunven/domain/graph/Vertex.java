package fr.clunven.domain.graph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Proposal for a Node in a Graph.
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 *
 * @param <DATA>
 * 		embedded DATA to renderer (could be anything).
 */
public class Vertex < DATA > implements Serializable {
	
	/** serial. */
	private static final long serialVersionUID = 1385869011309741342L;

	/** Label of the node. */
	private String label = "";
	
	/** Embedded Data for this Graph. */
	private transient DATA data = null;
	
	/** List of adjacent nodes. */
	private List < String > adjacentVertices = new ArrayList< String >();

	/**
	 * Constructor with empty data.
	 * @param label
	 * 		unique identifier of node
	 */
	public Vertex(String label) {
		this.label = label;
	}
	
	/**
	 * Constructor with both label and DATA.
	 * @param label
	 * 		current vertex label
	 * @param data
	 * 		embedded data
	 */
	public Vertex(String label, DATA data) {
		this(label);
		this.data = data;
	}

	/**
	 * Getter accessor for attribute 'label'.
	 *
	 * @return
	 *       current value of 'label'
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Setter accessor for attribute 'label'.
	 * @param label
	 * 		new value for 'label '
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Getter accessor for attribute 'data'.
	 *
	 * @return
	 *       current value of 'data'
	 */
	public DATA getData() {
		return data;
	}

	/**
	 * Setter accessor for attribute 'data'.
	 * @param data
	 * 		new value for 'data '
	 */
	public void setData(DATA data) {
		this.data = data;
	}

	/**
	 * Getter accessor for attribute 'adjacentVertices'.
	 *
	 * @return
	 *       current value of 'adjacentVertices'
	 */
	public List<String> getAdjacentVertices() {
		return adjacentVertices;
	}

	/**
	 * Setter accessor for attribute 'adjacentVertices'.
	 * @param adjacentVertices
	 * 		new value for 'adjacentVertices '
	 */
	public void setAdjacentVertices(List<String> adjacentVertices) {
		this.adjacentVertices = adjacentVertices;
	}

}
