package binary_tree_BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import binary_tree_general.TreeNode;

public class L637_AverageofLevelsinBT {
	public static void main(String[] args) {
	}

	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new ArrayList<>();

		if (root == null) {
			return list;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			double sum = 0;
			int nodes = queue.size();
			int count = nodes;

			while (count != 0) {
				TreeNode curr = queue.poll();
				if (curr.left != null) {
					queue.add(curr.left);
				}
				if (curr.right != null) {
					queue.add(curr.right);
				}

				sum += curr.val;
				count--;
			}
			list.add(sum / nodes);
		}
		return list;
	}
}
