package binary_tree_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L102_BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {

	}

	public List<List<Integer>> levelOrderTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();

		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int count = queue.size();
			List<Integer> list = new ArrayList<>();
			while (count-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				list.add(node.val);
			}
			result.add(list);
		}
		return result;
	}
}
