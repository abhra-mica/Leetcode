package linked_list;

public class L86_PartitionList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);

		ListNode result = partition(head, 3);
		System.out.println(result);
	}

	public static ListNode partition(ListNode head, int x) {
		ListNode left = new ListNode(-1);
		ListNode right = new ListNode(-1);

		ListNode lHead = left;
		ListNode rHead = right;

		while (head != null) {
			if (head.val < x) {
				left.next = head;
				left = left.next;
			} else {
				right.next = head;
				right = right.next;
			}
			head = head.next;
		}
		left.next = rHead.next;
		right.next = null;

		return lHead.next;// Else it will be connected to some node with the
				  // original list which gives us Error- Found
				  // cycle in the ListNode
    		}
	}
}
