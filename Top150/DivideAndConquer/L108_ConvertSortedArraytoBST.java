public class L108_ConvertSortedArraytoBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0) {
			return null;
		}
		return getBST(nums, 0, nums.length - 1);
	}

	private static TreeNode getBST(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}
		int mid = start + (end - start) / 2;

		TreeNode root = new TreeNode(nums[mid]);
		root.left = getBST(nums, start, mid - 1);
		root.right = getBST(nums, mid + 1, end);
		return root;
	}
}
