package binary_search_tree;

public class L530_MinimumAbsoluteDifferenceinBST {
	int minDiff = Integer.MAX_VALUE;
	Integer prev = null;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		root.right = new TreeNode(48);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(49);
		new L530_MinimumAbsoluteDifferenceinBST().getMinimumDifference(root);
	}

	public int getMinimumDifference(TreeNode root) {
		if (root == null) {
			return minDiff;
		}
		// Process Left
		getMinimumDifference(root.left);

		// Process Root
		if (prev != null) {
			minDiff = Math.min(minDiff, Math.abs(root.val - prev));
		}

		if (root != null) {
			prev = root.val;
		}
		// Process right
		getMinimumDifference(root.right);
		return minDiff;
	}
}

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	TreeNode() {
	}
	TreeNode(int val) {
		this.val = val;
	}
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
