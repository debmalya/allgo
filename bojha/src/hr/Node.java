/**
 * 
 */
package hr;

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
			prev=next;
			next=next.next;
			pos++;
		}
		prev.next=next.next;
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

	// --------------------------------------------------------------------------
	// Any other separator such as "Utility methods", etc.
	// --------------------------------------------------------------------------
}
