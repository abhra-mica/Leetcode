package linked_list;

public class L141_LinkedListCycle {
	public static void main(String[] args) {

	}

	public static boolean hasCycle(ListNode head) {
		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while (fastPtr != null && fastPtr.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;

			if (slowPtr == fastPtr) {
				return true;
			}
		}
		return false;
	}
}
