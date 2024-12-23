package binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class L98_ValidateBST {
	private static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		boolean result = isValidBST(root);
		System.out.println("Valid Binary Search Tree= " + result);
	}

	// Code is working fine in eclipse but in leetcode it is failing for [0]
	// node saying return false.
	public static boolean isValidBST(TreeNode root) {
		inorder(root);
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > list.get(i + 1)) {
				return false;
			}
		}
		return true;
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
