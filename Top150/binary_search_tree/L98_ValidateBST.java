package binary_search_tree;

import binary_tree_general.TreeNode;

public class L98_ValidateBST {
	static boolean isValid = true;
	static Integer prev = null;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);

		boolean result = isValidBST(root);
		System.out.println("Result= " + result);

	}

	public static boolean isValidBST(TreeNode root) {
		if (root == null) {
			return isValid;
		}

		isValidBST(root.left);

		if (prev != null && isValid) {
			isValid = prev < root.val ? true : false;
		}

		if (root != null) {
			prev = root.val;
		}

		isValidBST(root.right);
		return isValid;
	}
}
