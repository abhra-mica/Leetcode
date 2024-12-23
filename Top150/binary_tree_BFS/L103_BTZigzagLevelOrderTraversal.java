package binary_tree_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class L103_BTZigzagLevelOrderTraversal {
	public static void main(String[] args) {
		// TreeNode root = new TreeNode(3);
		// root.left = new TreeNode(9);
		// root.right = new TreeNode(20);

		// root.right.left = new TreeNode(15);
		// root.right.right = new TreeNode(7);

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		// List<List<Integer>> result = zigzagLevelOrder(root);
		// System.out.println("Result== " + result);

		List<List<Integer>> result = zigzagLevelOrderProper(root);
		System.out.println("Result== " + result);
	}

	public static List<List<Integer>> zigzagLevelOrderProper(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		Stack<Integer> reverseStack = new Stack<>();
		boolean flag = false;
		queue.add(root);

		while (!queue.isEmpty()) {
			int count = queue.size();
			List<Integer> list = new ArrayList<>();

			while (count-- > 0) {
				TreeNode node = queue.poll();

				if (flag) {
					reverseStack.add(node.val);
				} else {
					list.add(node.val);
				}

				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}

			while (!reverseStack.isEmpty()) {
				list.add(reverseStack.pop());
			}
			flag = !flag;
			result.add(list);
		}
		return result;
	}

	// Below method gives stale result
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean leftToRight = false;

		while (!queue.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			int count = queue.size();

			// Below while loop iterate one level
			while (count-- > 0) {
				TreeNode node = queue.poll();
				list.add(node.val);

				if (!leftToRight) {
					if (node.right != null) {
						queue.add(node.right);
					}
					if (node.left != null) {
						queue.add(node.left);
					}
				} else {
					if (node.left != null) {
						queue.add(node.left);
					}
					if (node.right != null) {
						queue.add(node.right);
					}
				}
			}
			leftToRight = !leftToRight;
			result.add(list);
		}
		return result;
	}
}
