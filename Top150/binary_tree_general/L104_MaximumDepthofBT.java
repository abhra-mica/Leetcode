package binary_tree_general;

public class L104_MaximumDepthofBT {
	public static void main(String[] args) {

	}

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int lHeight = maxDepth(root.left);
		int rHeight = maxDepth(root.right);
		return Math.max(lHeight, rHeight) + 1;
	}
}
