package linked_list;

public class L19_RemoveNthNodeFromEndofList {
	public static void main(String[] args) {

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode firstPtr = dummy;
		ListNode secondPtr = dummy;

		// Move second pointer n spaces ahead
		for (int i = 0; i < n; i++) {
			secondPtr = secondPtr.next;
		}

		// Move both pointer together until the secondPtr is null
		while (secondPtr.next != null) {
			firstPtr = firstPtr.next;
			secondPtr = secondPtr.next;
		}
		firstPtr.next = firstPtr.next.next;

		return dummy.next;
	}
}
