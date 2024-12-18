package linked_list;

public class L61_RotateList {
	public static void main(String[] args) {
		// 1->2->3->4->5->6->7
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || head.next == null || k == 0) {
			return head;
		}

		// Calculate size of the linkedList and connect the last node to head
		int length = 1;
		ListNode temp = head;

		while (temp.next != null) {
			temp = temp.next;
			length++;
		}
		temp.next = head;

		k = k % length;
		k = length - k;

		// temp = head; this is wrong, because temp is pointing just before the
		// head, so length reduction will be proper
		while (k-- > 0) {
			temp = temp.next;// temp is pointing now 5
		}

		head = temp.next; // head is pointing to 6
		temp.next = null; // 5->6 this connection is broken.
		return head;
	}
}
