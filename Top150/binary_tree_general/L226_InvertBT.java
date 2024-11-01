package binary_tree_general;

public class L226_InvertBT {
	public static void main(String[] args) {

	}

	public static TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return root;
		}
		invertTree(root.left);
		invertTree(root.right);

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		return root;
	}
}
