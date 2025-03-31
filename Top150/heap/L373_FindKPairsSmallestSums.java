package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class L373_FindKPairsSmallestSums {
	private static class Pair {
		int sum, i, j;
		Pair(int sum, int i, int j) {
			this.sum = sum;
			this.i = i;
			this.j = j;
		}
	}

	public static void main(String[] args) {
		int[] nums1 = {1, 7, 11};
		int[] nums2 = {2, 4, 6};
		int k = 3;

		List<List<Integer>> result = kSmallestPairs(nums1, nums2, k);
		System.out.println(result);
	}

	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2,
			int k) {
		List<List<Integer>> result = new ArrayList<>();

		PriorityQueue<Pair> minHeap = new PriorityQueue<>(
				(a, b) -> a.sum - b.sum);
		minHeap.add(new Pair(nums1[0] + nums2[0], 0, 0));

		Set<List<Integer>> visited = new HashSet<>();
		visited.add(Arrays.asList(0, 0));

		while (k-- > 0 && !minHeap.isEmpty()) {
			Pair curr = minHeap.poll();
			int i = curr.i;
			int j = curr.j;

			result.add(Arrays.asList(nums1[i], nums2[j]));

			if (i + 1 < nums1.length && visited.add(Arrays.asList(i + 1, j))) {
				minHeap.add(new Pair(nums1[i + 1] + nums2[j], i + 1, j));
			}

			if (j + 1 < nums2.length && visited.add(Arrays.asList(i, j + 1))) {
				minHeap.add(new Pair(nums1[i] + nums2[j + 1], i, j + 1));
			}
		}
		return result;
	}
}
