package linked_list;

public class L82_RemoveDuplicatesFromSortedListII {
	public static void main(String[] args) {

	}

	public static ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode prev = dummy;
		ListNode curr = head;

		while (curr != null) {
			if (curr.next != null && curr.val == curr.next.val) {
				while (curr.next != null && curr.val == curr.next.val) {
					curr = curr.next;
				}
				prev.next = curr.next;

			} else {
				prev = prev.next;
			}
			curr = curr.next;
		}
		return dummy.next;
	}
}
