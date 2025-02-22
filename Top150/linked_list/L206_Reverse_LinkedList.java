package linked_list;

public class L206_Reverse_LinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ListNode result = reverseList(head);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}

	}

	public static ListNode reverseList(ListNode head) {
		if (head == null) {
			return head;
		}

		ListNode prev = null;
		ListNode curr = head;
		ListNode nextEle = null;

		while (curr != null) {
			nextEle = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextEle;
		}

		head = prev;
		return head;
	}
}
