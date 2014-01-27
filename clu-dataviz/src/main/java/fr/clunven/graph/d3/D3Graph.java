package fr.clunven.graph.d3;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class D3Graph {
	
	/** Unique identifier of the Graph. */
	private String name;
	
	/** Custom property. */
	private Integer size = null;
	
	/** List of children. */
	private List < D3Graph > children = new ArrayList<D3Graph>();
	
	/**
	 * Constructor with uid.
	 * @param name
	 * 		uid for the node
	 */
	public D3Graph(String name) {
		this.name = name;
	}
	
	/**
	 * Constructor with uid.
	 * @param name
	 * 		uid for the node
	 */
	public D3Graph(String name, int size) {
		this.name = name;
		this.size = size;
	}
	
	/**
	 * Convenience method to add subnode
	 * @param child
	 * 		subnode
	 */
	public void addChild(D3Graph child) {
		children.add(child);
	}
	
	/**
	 * Convenience method to add subnode
	 * @param child
	 * 		subnode
	 */
	public void addChild(String childName) {
		children.add(new D3Graph(childName));
	}
	
	/**
	 * Convenience method to add subnode
	 * @param child
	 * 		subnode
	 */
	public void addChild(String childName, int size) {
		children.add(new D3Graph(childName, size));
	}

	/**
	 * Getter accessor for attribute 'name'.
	 *
	 * @return
	 *       current value of 'name'
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter accessor for attribute 'name'.
	 * @param name
	 * 		new value for 'name '
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter accessor for attribute 'size'.
	 *
	 * @return
	 *       current value of 'size'
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * Setter accessor for attribute 'size'.
	 * @param size
	 * 		new value for 'size '
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Getter accessor for attribute 'children'.
	 *
	 * @return
	 *       current value of 'children'
	 */
	public List<D3Graph> getChildren() {
		return children;
	}

	/**
	 * Setter accessor for attribute 'children'.
	 * @param children
	 * 		new value for 'children '
	 */
	public void setChildren(List<D3Graph> children) {
		this.children = children;
	}
	

}
