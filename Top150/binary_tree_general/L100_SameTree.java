package binary_tree_general;

public class L100_SameTree {
	public static void main(String[] args) {

	}
	/*
	 * We can do it by Level order traversal where taking all values of every
	 * node including null values StringBuilder sb = new StringBuilder("^"); in
	 * case of null values append null like sb.append("null")
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}

		if (p == null || q == null) {
			return false;
		}

		if (p.val != q.val) {
			return false;
		}

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}
