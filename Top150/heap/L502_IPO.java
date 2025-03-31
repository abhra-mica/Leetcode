package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L502_IPO {
	static class Project {
		int capital;
		int profit;

		Project(int capital, int profit) {
			this.capital = capital;
			this.profit = profit;
		}
	}

	public static int findMaximizedCapital(int k, int w, int[] profits,
			int[] capital) {
		Project[] projects = new Project[profits.length];

		for (int i = 0; i < profits.length; i++) {
			projects[i] = new Project(capital[i], profits[i]);
		}

		Arrays.sort(projects, (a, b) -> a.capital - b.capital);
		PriorityQueue<Project> maxHeap = new PriorityQueue<>(
				(a, b) -> b.profit - a.profit);

		int i = 0;
		while (k-- > 0) {
			// We can have multiple capital which is under w, so this loop
			while (i < projects.length && projects[i].capital <= w) {
				maxHeap.add(projects[i++]);
			}

			if (maxHeap.isEmpty()) {
				break;
			}

			w += maxHeap.poll().profit;
		}
		return w;
	}
}
