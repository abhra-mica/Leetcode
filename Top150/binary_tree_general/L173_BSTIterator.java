package binary_tree_general;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L173_BSTIterator {
	public static void main(String[] args) {

	}
}

class BSTIteratorStack {
	Stack<TreeNode> stack = new Stack<>();

	public BSTIteratorStack(TreeNode root) {
		partialInorder(root);
	}

	public int next() {
		TreeNode node = stack.pop();
		partialInorder(node.right);
		return node.val;
	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	private void partialInorder(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
}

class BSTIterator {
	List<Integer> list = new ArrayList<>();
	int index = 0;

	public BSTIterator(TreeNode root) {
		inorder(root);
	}

	public int next() {
		return list.get(index++);
	}

	public boolean hasNext() {
		return index < list.size();
	}

	private void inorder(TreeNode root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		list.add(root.val);
		inorder(root.right);
	}
}
