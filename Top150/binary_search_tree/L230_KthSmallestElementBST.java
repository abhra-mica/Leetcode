package TEST;
import binary_tree_general.TreeNode;

public class Test {
	static int count = 0;
	static int kthSmallest = 0;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.right = new TreeNode(3);

		int result = kthSmallest(root, 2);
		System.out.println(result);
	}

	public static int kthSmallest(TreeNode root, int k) {
		if (root == null) {
			return count;
		}

		kthSmallest(root.left, k);
		count++;
		if (count == k) {
			kthSmallest = root.val;
		}

		kthSmallest(root.right, k);
		return kthSmallest;
	}
}
