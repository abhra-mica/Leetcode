package binary_tree_general;

import java.util.LinkedList;
import java.util.Queue;

public class L101_SymmetricTree {
	public static void main(String[] args) {

	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		Queue<TreeNode> leftSide = new LinkedList<>();
		Queue<TreeNode> rightSide = new LinkedList<>();

		leftSide.add(root.left);
		rightSide.add(root.right);

		while (!leftSide.isEmpty() && !rightSide.isEmpty()) {
			TreeNode leftNode = leftSide.poll();
			TreeNode rightNode = rightSide.poll();

			if (leftNode == null && rightNode == null) {
				continue;
			}
			if (leftNode == null || rightNode == null) {
				return false;
			}
			if (leftNode.val != rightNode.val) {
				return false;
			}

			leftSide.add(leftNode.left);
			leftSide.add(leftNode.right);
			rightSide.add(rightNode.right);
			rightSide.add(rightNode.left);
		}
		return true;
	}
}
