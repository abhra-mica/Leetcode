package binary_tree_general;

import java.util.LinkedList;
import java.util.Queue;

public class L117_PopulatingNextRightPointersinEachNodeII {
	public static void main(String[] args) {

	}

	public static Node connect(Node root) {
		if (root == null) {
			return root;
		}

		Queue<Node> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int count = queue.size();
			Node dummy = new Node(-1);
			while (count-- > 0) {
				Node node = queue.remove();
				dummy.next = node;
				dummy = dummy.next;

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}

		return root;
	}
}

class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}
