package hashmap;

import linked_list.ListNode;

public class L21_MergeTwoSortedLists {
	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);

		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);

		ListNode result = mergeTwoLists(list1, list2);

	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode mergedList = new ListNode(-1);
		ListNode dummyNode = mergedList;

		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				mergedList.next = list1;
				list1 = list1.next;
			} else {
				mergedList.next = list2;
				list2 = list2.next;
			}
			mergedList = mergedList.next;
		}

		while (list1 != null) {
			mergedList.next = list1;
			list1 = list1.next;
			mergedList = mergedList.next;
		}

		while (list2 != null) {
			mergedList.next = list2;
			list2 = list2.next;
			mergedList = mergedList.next;
		}

		return dummyNode.next;
	}
}
