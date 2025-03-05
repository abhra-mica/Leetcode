package binary_tree_general;

import java.util.LinkedList;
import java.util.Queue;

public class L222_CountCompleteTreeNodes {
	private static int count = 0;
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.left = new TreeNode(6);

		int result = countNodes(root);
		System.out.println("Total Nodes= " + result);
	}


	//Recursive way
	public static int countNodes(TreeNode root) {
		if (root == null) {
			return count;
		}

		countNodes(root.left);
		countNodes(root.right);
		return ++count;
	}

	//BFS Approach
	public static int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if (curr.left != null) {
				queue.add(curr.left);
			}
			if (curr.right != null) {
				queue.add(curr.right);
			}
			count++;
		}
		return count;
	}
}
