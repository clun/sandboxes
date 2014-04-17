package fr.clunven.viz.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Object to be serialized as JSON to be displayed by D3
 *
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
@XmlRootElement
public class TreeNode {
	
	/** Unique identifier of the Graph. */
	private String name;
	
	/** Custom property. */
	private Integer size = null;
	
	/** List of children. */
	private List < TreeNode > children = new ArrayList<TreeNode>();
	
	/**
	 * Constructor with uid.
	 * @param name
	 * 		uid for the node
	 */
	public TreeNode(String name) {
		this.name = name;
	}
	
	/**
	 * Constructor with uid.
	 * @param name
	 * 		uid for the node
	 */
	public TreeNode(String name, int size) {
		this.name = name;
		this.size = size;
	}
	
	/**
	 * Convenience method to add subnode
	 * @param child
	 * 		subnode
	 */
	public void addChild(TreeNode child) {
		children.add(child);
	}
	
	/**
	 * Convenience method to add subnode
	 * @param child
	 * 		subnode
	 */
	public void addChild(String childName) {
		children.add(new TreeNode(childName));
	}
	
	/**
	 * Convenience method to add subnode
	 * @param child
	 * 		subnode
	 */
	public void addChild(String childName, int size) {
		children.add(new TreeNode(childName, size));
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
	public List<TreeNode> getChildren() {
		return children;
	}

	/**
	 * Setter accessor for attribute 'children'.
	 * @param children
	 * 		new value for 'children '
	 */
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
	

}
