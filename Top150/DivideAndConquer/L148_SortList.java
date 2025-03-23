package DivideAndConquer;

public class L148_SortList {

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode fast = head, slow = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;
		ListNode left = sortList(head);
		ListNode right = sortList(slow);
		return merge(left, right);
	}

	private static ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(-1), temp = dummy;
		while (left != null && right != null) {
			if (left.val < right.val) {
				temp.next = left;
				left = left.next;
			} else {
				temp.next = right;
				right = right.next;
			}
			temp = temp.next;
		}
		// Next two if block is enough, no need of while loop because nodes
		// divided into equl half and we keep merging , so alwyas be divided in
		// equal half
		if (left != null) {
			temp.next = left;
		}

		if (right != null) {
			temp.next = right;
		}

		return dummy.next;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode() {
	}
	ListNode(int val) {
		this.val = val;
	}
	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
