package dj.tree;

public class IntNode extends Node {

	private int value;

	public IntNode(Node[] children, int value) {
		super(children);
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
