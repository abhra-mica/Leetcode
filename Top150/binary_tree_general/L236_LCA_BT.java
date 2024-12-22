package binary_tree_general;

public class L236_LCA_BT {
	public static void main(String[] args) {

	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		if (root == null) {
			return null;
		}

		if (root.equals(p) || root.equals(q)) {
			return root;
		}

		TreeNode lans = lowestCommonAncestor(root.left, p, q);
		TreeNode rans = lowestCommonAncestor(root.right, p, q);

		if (lans == null) {
			return rans;
		}
		if (rans == null) {
			return lans;
		}

		return root;
	}
}
