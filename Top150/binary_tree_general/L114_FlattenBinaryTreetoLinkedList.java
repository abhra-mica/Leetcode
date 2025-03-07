package binary_tree_general;

public class L114_FlattenBinaryTreetoLinkedList {
	private static TreeNode prev = null;
	public static void main(String[] args) {

	}

	public static void flatten(TreeNode root) {
		if (root == null) {
			return;
		}

		flatten(root.right);
		flatten(root.left);

		root.right = prev;
		root.left = null;
		prev = root;
	}
}
