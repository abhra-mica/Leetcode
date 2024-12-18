package linked_list;

public class L86_PartitionList {
	public static void main(String[] args) {

	}

	public static ListNode partition(ListNode head, int x) {
		ListNode beforeNode = new ListNode(-1);
		ListNode afterNode = new ListNode(-1);
		ListNode afterHead = afterNode;
		ListNode beforeHead = beforeNode;

		while (head != null) {
			if (head.val < x) {
				beforeNode.next = head;
				beforeNode = beforeNode.next;
			} else {
				afterNode.next = head;
				afterNode = afterNode.next;
			}
			head = head.next;
		}
		beforeNode.next = afterHead.next;
		afterNode.next = null;// Else it will be connected to some node with the
								// original list which gives us Error- Found
								// cycle in the ListNode
		return beforeHead.next;
	}
}
