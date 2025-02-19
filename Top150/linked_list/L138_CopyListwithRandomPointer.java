package linked_list;

public class L138_CopyListwithRandomPointer {
	public static void main(String[] args) {
		Node head = new Node(7);
		head.next = new Node(13);

	}

	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}
		Node dummy = head;

		// 1.Create nodes with same value inbetween original nodes
		while (dummy != null) {
			Node newNode = new Node(dummy.val);
			newNode.next = dummy.next;
			dummy.next = newNode;
			dummy = newNode.next;
		}

		// 2.Attach random pointers to clone nodes.
		dummy = head;
		while (dummy != null) {
			dummy.next.random = dummy.random == null ? null : dummy.random.next;
			dummy = dummy.next.next;
		}

		// 3.Separate two lists
		Node newHead = head.next;
		Node curr = head;
		Node clone = head.next;

		while (curr != null) {
			curr.next = clone.next;
			curr = curr.next;
			clone.next = curr == null ? null : curr.next;
			clone = clone.next;
		}

		return newHead;
	}
}

class Node {
	int val;
	Node next;
	Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}
