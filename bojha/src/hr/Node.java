/**
 * 
 */
package hr;

import java.util.Stack;

/**
 * @author debmalyajash
 *
 */
public class Node {
	// --------------------------------------------------------------------------
	// Static members
	// --------------------------------------------------------------------------

	// -------------------------------------------------------------------------
	// Members
	// -------------------------------------------------------------------------
	int data;

	Node next;

	// -------------------------------------------------------------------------
	// Constructor
	// -------------------------------------------------------------------------

	// -------------------------------------------------------------------------
	// Implements interface <IMyInterface>
	// -------------------------------------------------------------------------

	// --------------------------------------------------------------------------
	// Methods
	// --------------------------------------------------------------------------
	Node InsertNth(Node head, int data, int position) {
		int pos = 0;
		Node next = head;
		if (position == 0) {
			Node newHead = new Node();
			newHead.data = data;
			newHead.next = head;
			head = newHead;
		} else {
			Node prev = null;
			boolean inserted = false;
			while (pos < position) {
				pos++;
				if (next == null) {
					next = new Node();
					if (prev != null) {
						prev.next = next;
					}
					next.data = data;
					inserted = true;
					break;
				}
				// System.out.println(pos+". " + next.data);
				prev = next;
				next = next.next;
			}
			if (!inserted) {
				if (next == null) {
					next = new Node();
					prev.next = next;
					next.data = data;
					next.next = null;
				} else {

					Node nextNode = new Node();
					prev.next = nextNode;
					nextNode.data = data;
					nextNode.next = next;
				}

			}

		}
		return head;
	}

	Node Delete(Node head, int position) {
		// Complete this method
		Node next = head;
		Node prev = null;
		int pos = 0;
		if (position == 0) {
			return head.next;
		}
		while (pos < position) {

			if (next == null) {
				return head;
			}
			prev = next;
			next = next.next;
			pos++;
		}
		prev.next = next.next;
		return head;
	}

	public String printNode(Node head) {
		Node next = head;
		StringBuilder me = new StringBuilder();
		while (next != null) {
			me.append(next.data);
			next = next.next;
		}
		return me.toString();
	}

	/**
	 * You are given the pointer to the head node of a linked list and you need
	 * to print all its elements in reverse order from tail to head, one element
	 * per line. The head pointer may be null meaning that the list is empty -
	 * in that case, do not print anything!
	 * 
	 * 
	 * @param head
	 */
	void ReversePrint(Node head) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		Node next = head;
		StringBuilder me = new StringBuilder();
		while (next != null) {
			me.append(next.data);
			next = next.next;
		}
		String reverse = me.reverse().toString();
		for (int i = 0; i < reverse.length(); i++) {
			System.out.println(reverse.charAt(i));
		}

	}

	
	Node Reverse(Node head) {
		Node next = head;
		Node prev = head;

		Stack<Node> nodeStack = new Stack<Node>();
		boolean firstEntry = true;
		while (next != null) {
			if (!nodeStack.empty()) {
				if (firstEntry) {
					firstEntry = false;
					nodeStack.peek().next = null;
				} else {
					nodeStack.peek().next = prev;
					prev = prev.next;
				}
			}
			nodeStack.push(next);
			next = next.next;
		}
		if (!nodeStack.empty())
			head=nodeStack.pop();
		if (!nodeStack.empty()) {
			head.next = nodeStack.pop();
		}		
		return head;
	}

	// --------------------------------------------------------------------------
	// Any other separator such as "Utility methods", etc.
	// --------------------------------------------------------------------------
}
