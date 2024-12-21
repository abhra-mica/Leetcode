package binary_tree_general;

public class L129_SumRoottoLeafNumbers {
	int total = 0;
	public static void main(String[] args) {

	}

	public int sumNumbers(TreeNode root) {
		helper(root, 0);
		return total;
	}

	private void helper(TreeNode root, int sum) {
		if (root == null) {// When tree is null
			return;
		}
		sum = sum * 10 + root.val;

		if (root.left == null && root.right == null) {
			total = total + sum;
			return;
		}

		helper(root.left, sum);
		helper(root.right, sum);
	}
}
