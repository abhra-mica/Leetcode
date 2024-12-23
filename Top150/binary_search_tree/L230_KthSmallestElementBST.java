package binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class L230_KthSmallestElementBST {
	private static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(5);
		root.left.right = new TreeNode(3);

		int result = kthSmallest(root, 1);
		System.out.println(1 + "th smallest = " + result);
	}

	public static int kthSmallest(TreeNode root, int k) {
		inorder(root);
		return list.get(k - 1);
	}

	private static void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		list.add(root.val);
		inorder(root.right);
	}
}
