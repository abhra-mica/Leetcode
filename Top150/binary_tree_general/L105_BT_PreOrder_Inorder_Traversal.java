package binary_tree_general;

import java.util.HashMap;
import java.util.Map;

public class L105_BT_PreOrder_Inorder_Traversal {
	public static void main(String[] args) {

	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inorderIndexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}

		TreeNode root = splitTree(preorder, inorderIndexMap, 0, 0,
				inorder.length - 1);
		return root;
	}

	private static TreeNode splitTree(int[] preorder,
			Map<Integer, Integer> inorderIndexMap, int rootIndex, int left,
			int right) {
		TreeNode root = new TreeNode(preorder[rootIndex]);
		int mid = inorderIndexMap.get(preorder[rootIndex]);

		if (mid > left) {
			root.left = splitTree(preorder, inorderIndexMap, rootIndex + 1,
					left, mid - 1);

		}
		if (mid < right) {
			root.right = splitTree(preorder, inorderIndexMap,
					rootIndex + mid - left + 1, mid + 1, right);

		}
		return root;
	}
}
