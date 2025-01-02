package graph_general;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class L207_CourseSchedule {
	public static void main(String[] args) {
		int[][] prerequsites = {{2, 5}, {3, 2}, {1, 3}, {1, 4}, {0, 5}, {0, 4}};
		int numCourses = 6;

		boolean result = canFinish(numCourses, prerequsites);
		System.out.println("Can finish== " + result);
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
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

		// If queue is empty that means a cycle is available,so not possible to
		// complete all the courses
		if (queue.isEmpty()) {
			return false;
		}

		// Fetch from queue and decrease it's dependent courses in-degree by 1,
		// if we find any courses in-degree is 0 then add it to the queue
		int count = 0;
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			for (int i : adj.get(course)) {
				if (--indegrees[i] == 0) {
					queue.add(i);
				}
			}
		}

		if (count != numCourses) {
			return false;
		}

		return true;
	}
}
