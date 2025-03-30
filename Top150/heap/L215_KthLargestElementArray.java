package heap;

import java.util.PriorityQueue;

public class L215_KthLargestElementArray {
	public static void main(String[] args) {
		// int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6}; k =9;
		int[] nums = {1};
		int k = 1;
		int result = findKthLargestQuick(nums, k);
		System.out.println("Kth largest element= " + result);
	}

	public static int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int count = 0;
		for (int num : nums) {
			pq.add(num);
			count++;
			if (count > k) {
				pq.remove();
			}
		}
		return pq.peek();
	}
	// Failing for some test cases
	public static int findKthLargestQuick(int[] nums, int k) {
		if (nums.length == 0) {
			return -1;
		}
		int index = helper(nums, k, 0, nums.length - 1);
		return nums[index];
	}

	private static int helper(int[] nums, int k, int i, int j) {
		int pivot = nums[i];
		int pivotPos = i;

		while (i <= j) {
			if (nums[i] < pivot && nums[j] > pivot) {
				swap(i, j, nums);
				i++;
				j--;
			}

			if (nums[i] >= pivot) {
				i++;
			}

			if (nums[j] < pivot) {
				j--;
			}
		}

		swap(pivotPos, j, nums);

		if (j == k - 1) {
			return j;
		} else if (j < k) {
			pivotPos = helper(nums, k, j + 1, nums.length - 1);
		} else {
			pivotPos = helper(nums, k, 0, j - 1);
		}
		return pivotPos;
	}

	private static void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
