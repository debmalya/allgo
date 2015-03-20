/**
 * Binary Search tree
 */
package dj.tree;

public class BST {
	private Comparable<?> value;
	private BST left;
	private BST right;
	
	public BST(BST right,BST left,Comparable<?> value) {
		this.value = value;
		this.right = right;
		this.left = left;
	}
	
	/**
	 * @return left node.
	 */
	public BST getLeft() {
		return left;
	}
	
	/**
	 * @return right node.
	 */
	public BST getRight() {
		return right;
	}
	
	/**
	 * 
	 * @return value.
	 */
	public Comparable<?> getValue() {
		return value;
	}
	
	/**
	 * Get tree height
	 * @param root
	 * @return height of the tree.
	 */
	public int treeHeight(BST root) {
		if (root == null) return 0;
		return 1 + Math.max(treeHeight(root.getLeft()),treeHeight(root.getRight()));
	}
	
	/**
	 * 
	 * @param root - from where search will be started
	 * @param searchValue value to be searched
	 * @return node if search value found, false otherwise.
	 */
	public BST search(BST root,Comparable searchValue) {
		if (root == null) return root;
		Comparable<?> value = root.getValue();
		if (searchValue.compareTo(value) == 0) {
			return root;
		} else if (searchValue.compareTo(value) > 0) {
			return search(root.getRight(),searchValue);
		} else {
			return search(root.getLeft(),searchValue);
		}
	}
	
	/**
	 * Pre order traversal, self->left->right.
	 * @param root
	 */
	public void preOrderTraversal(BST root) {
		if (root == null) return;
		System.out.println(root.getValue());
		preOrderTraversal(root.getLeft());
		preOrderTraversal(root.getRight());
	}
	
	/**
	 * In order traversal left->self->right.
	 * @param root
	 */
	public void inOrderTraversal(BST root) {
		if (root == null) return;
		inOrderTraversal(root.getLeft());
		System.out.println(root.getValue());
		inOrderTraversal(root.getRight());
	}
	/**
	 * Post order traversal right->left->self
	 * @param root
	 */
	public void postOrderTraversal(BST root) {
		if (root == null) return;
		postOrderTraversal(root.getRight());
		postOrderTraversal(root.getLeft());
		System.out.println(root.getValue());
		
	}
}
