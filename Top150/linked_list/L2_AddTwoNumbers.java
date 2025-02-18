package linked_list;

public class L2_AddTwoNumbers {
	public static void main(String[] args) {
		ListNode list1 = new ListNode(2);
		list1.next = new ListNode(4);
		list1.next.next = new ListNode(5);

		ListNode list2 = new ListNode(5);
		list2.next = new ListNode(6);
		list2.next.next = new ListNode(4);
		list2.next.next.next = new ListNode(9);

		ListNode resultHead = addTwoNumbers(list1, list2);
		System.out.println(resultHead);
	}

	public static ListNode addTwoNumbers(ListNode node1, ListNode node2) {
		ListNode dummy = new ListNode(-1);
		ListNode result = dummy;
		int carry = 0;
		while (node1 != null && node2 != null) {
			dummy.next = new ListNode((node1.val + node2.val + carry) % 10);
			carry = (node1.val + node2.val + carry) / 10;
			dummy = dummy.next;
			node1 = node1.next;
			node2 = node2.next;
		}
		// Any of the linkedlist may over
		while (node1 != null) {
			dummy.next = new ListNode((carry + node1.val) % 10);
			carry = (node1.val + carry) / 10;
			dummy = dummy.next;
			node1 = node1.next;
		}

		while (node2 != null) {
			dummy.next = new ListNode((carry + node2.val) % 10);
			carry = (node2.val + carry) / 10;
			dummy = dummy.next;
			node2 = node2.next;
		}
		// last digits say (8 + 9) == 17 so carry 1 will be present which we
		// need to add to the list
		if (carry != 0) {
			dummy.next = new ListNode(carry);
		}

		return result.next;
	}

	/*
	 * public static ListNode addTwoNumbers(ListNode l1, ListNode l2) { ListNode
	 * dummy = new ListNode(0); ListNode current = dummy; int carry = 0;
	 * 
	 * while (l1 != null || l2 != null || carry == 1) { int sum = carry;
	 * 
	 * if (l1 != null) { sum += l1.val; l1 = l1.next; }
	 * 
	 * if (l2 != null) { sum += l2.val; l2 = l2.next; }
	 * 
	 * carry = sum / 10; current.next = new ListNode(sum % 10); current =
	 * current.next; } return dummy.next; }
	 */
}
