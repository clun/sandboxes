package fr.clunven.viz.tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A tree node will allow to represent hierarchical DATA.
 * 
 * @author <a href="mailto:cedrick.lunven@gmail.com">Cedrick LUNVEN</a>
 */
public class TreeNode < DATA > implements Serializable {

	/** serial. */
	private static final long serialVersionUID = 5173453559519890691L;

	/** Unique identifier of the Graph. */
	private String name = "";
	
	/** Embedded DATA of tree node. */
	private DATA data = null;
	
	/** Parent of node. */
	private TreeNode parent = null;
	
	/** Childer of the node. */
	private List < TreeNode < DATA > > children = new ArrayList<TreeNode<DATA>>();
	
	/**
	 * Default constructor.
	 */
	public TreeNode() {
	}
	
	/**
	 * Constructor.
	 * @param name
	 * 		name of the node
	 */
	public TreeNode(String name) {
		this.name = name;
	}
	
	/**
	 * Constructor.
	 * @param name
	 * 		name of the node
	 * @param d
	 * 		data embedded by node
	 */
	public TreeNode(String name, DATA d) {
		this(name);
		this.data = d;
	}
	
	/**
	 * Add child.
	 *
	 * @param tn
	 * 		child reference
	 */
	public void addChild(TreeNode<DATA> tn) {
		tn.setParent(this);
		children.add(tn);
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
	 * Getter accessor for attribute 'children'.
	 *
	 * @return
	 *       current value of 'children'
	 */
	public List<TreeNode<DATA>> getChildren() {
		return children;
	}

	/**
	 * Setter accessor for attribute 'children'.
	 * @param children
	 * 		new value for 'children '
	 */
	public void setChildren(List<TreeNode<DATA>> children) {
		this.children = children;
	}

	/**
	 * Getter accessor for attribute 'parent'.
	 *
	 * @return
	 *       current value of 'parent'
	 */
	public TreeNode getParent() {
		return parent;
	}

	/**
	 * Setter accessor for attribute 'parent'.
	 * @param parent
	 * 		new value for 'parent '
	 */
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
}
