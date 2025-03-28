package binary_tree_general;

public class L112_PathSum {
	public static void main(String[] args) {
	}

	public static boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		} else if (root.left == null && root.right == null
				&& targetSum - root.val == 0) {
			return true;
		}
		return hasPathSum(root.left, targetSum - root.val)
				|| hasPathSum(root.right, targetSum - root.val);
	}
}
