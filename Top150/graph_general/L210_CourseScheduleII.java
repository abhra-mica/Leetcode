package graph_general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L210_CourseScheduleII {
	public static void main(String[] args) {
		// int[][] prerequsites = {{2, 5}, {3, 2}, {1, 3}, {1, 4}, {0, 5}, {0,
		// 4}};
		int[][] prerequsites = {{0, 1}, {1, 0}};
		int numCourses = 2;

		int[] result = findOrder(numCourses, prerequsites);
		Arrays.stream(result).forEach(i -> System.out.print(i + " "));
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] result = new int[numCourses];
		List<List<Integer>> adj = new ArrayList<>();
		// Fill the all node neighbors as empty list
		for (int i = 0; i < numCourses; i++) {
			adj.add(new ArrayList<>());
		}

		// populate the must complete course for every course, means all
		// dependent courses
		for (int[] arr : prerequisites) {
			adj.get(arr[1]).add(arr[0]);
		}

		// Create and populate the in-degree array
		// To do that we need to traverse through the adjacency list.
		int[] indegrees = new int[numCourses];
		for (int i = 0; i < adj.size(); i++) {
			for (int x : adj.get(i)) {
				indegrees[x]++;
			}
		}

		// Add elements with in-degree 0 in the queue.
		Queue<Integer> queue = new LinkedList<>();
		for (int idx = 0; idx < indegrees.length; idx++) {
			if (indegrees[idx] == 0) {
				queue.add(idx);
			}
		}

		// Fetch from queue and decrease it's dependent courses in-degree by 1,
		// if we find any courses in-degree is 0 then add it to the queue
		int count = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			result[count] = course;
			count++;
			for (int i : adj.get(course)) {
				if (--indegrees[i] == 0) {
					queue.add(i);
				}
			}
		}

		return count != numCourses ? new int[]{} : result;
	}
}
