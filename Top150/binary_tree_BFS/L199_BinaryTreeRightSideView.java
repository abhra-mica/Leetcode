package binary_tree_general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L199_BinaryTreeRightSideView {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(5);

		List<Integer> list = rightSideView(root);

		list.stream().forEach(i -> System.out.print(i + " "));
	}

	public static List<Integer> rightSideView(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}

		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int count = queue.size();
			TreeNode candidate = null;
			for (int i = 0; i < count; i++) {
				candidate = queue.poll();
				if (candidate.left != null) {
					queue.add(candidate.left);
				}
				if (candidate.right != null) {
					queue.add(candidate.right);
				}
			}
			result.add(candidate.val);
		}
		return result;
	}
}
