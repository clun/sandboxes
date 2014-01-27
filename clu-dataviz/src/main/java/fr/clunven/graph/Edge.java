package fr.clunven.graph;

import java.io.Serializable;

/**
 * Structure to store Egdes.
 * 
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 *
 * @param <EDGEDATA>
 */
public class Edge < EDGE > implements Serializable {
	
	/** serial for the class. */
	private static final long serialVersionUID = -4318363021960999456L;

	/** if the edge is oriented or not. */
	private boolean directed = false;
	
	/** head of the edge. */
	private String head;
	
	/** tail of the Edge. */
	private String tail;
	
	/** weight of the edge. */
	private double weight = 0.0;
	
	/** Embedded Data for this Graph. */
	private transient EDGE data = null;

	/** Default constructor. */
	public Edge(String head, String tail) {
		this.head = head;
		this.tail = tail;
	}
	
	/**
	 * Full constructor.
	 *
	 * @param head
	 * 		head of the edge
	 * @param tail
	 * 		tail of the edge
	 * @param edge
	 * 		data embedde for this edge
	 * @param direct
	 * 		nature of graph (oriented)
	 */
	public Edge(String head, String tail, EDGE edge, boolean direct) {
		this(head, tail);
		this.data = edge;
		this.directed = direct;
	}

	/**
	 * Getter accessor for attribute 'directed'.
	 *
	 * @return
	 *       current value of 'directed'
	 */
	public boolean isDirected() {
		return directed;
	}

	/**
	 * Setter accessor for attribute 'directed'.
	 * @param directed
	 * 		new value for 'directed '
	 */
	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	/**
	 * Getter accessor for attribute 'head'.
	 *
	 * @return
	 *       current value of 'head'
	 */
	public String getHead() {
		return head;
	}

	/**
	 * Setter accessor for attribute 'head'.
	 * @param head
	 * 		new value for 'head '
	 */
	public void setHead(String head) {
		this.head = head;
	}

	/**
	 * Getter accessor for attribute 'tail'.
	 *
	 * @return
	 *       current value of 'tail'
	 */
	public String getTail() {
		return tail;
	}

	/**
	 * Setter accessor for attribute 'tail'.
	 * @param tail
	 * 		new value for 'tail '
	 */
	public void setTail(String tail) {
		this.tail = tail;
	}

	/**
	 * Getter accessor for attribute 'weight'.
	 *
	 * @return
	 *       current value of 'weight'
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Setter accessor for attribute 'weight'.
	 * @param weight
	 * 		new value for 'weight '
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * Getter accessor for attribute 'data'.
	 *
	 * @return
	 *       current value of 'data'
	 */
	public EDGE getData() {
		return data;
	}

	/**
	 * Setter accessor for attribute 'data'.
	 * @param data
	 * 		new value for 'data '
	 */
	public void setData(EDGE data) {
		this.data = data;
	}
}
