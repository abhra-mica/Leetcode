package binary_tree_general;

import java.util.LinkedList;
import java.util.Queue;

public class L222_CountCompleteTreeNodes {
	public static void main(String[] args) {
	}

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
