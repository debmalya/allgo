package dj.tree;

public abstract class Node {
	private Node[] children;

	/**
	 * Constructor.
	 * @param children 
	 */
	public Node(Node[] children) {
		this.children = children;
	}

	/**
	 * Get child for the passed index.
	 * @param index 
	 * @return children at the index, or null if index out of bound.
	 */
	public Node getChild(int index) {
		if (index < children.length) {
			return children[index];
		} 
		return null;
	}
	
	/**
	 * 
	 * @return number of children.
	 */
	public int getNumberOfChildren() {
		if (children != null) { 
			return children.length;
		}
		return 0;		
		
	}
}
