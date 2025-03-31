package heap;

import java.util.PriorityQueue;

public class L295_FindMedianfromDataStream {
	public static void main(String[] args) {
		MedianFinder mf = new MedianFinder();
		mf.addNum(1);
		mf.addNum(2);

		double median = mf.findMedian();
		System.out.println("Median= " + median);
	}
}

class MedianFinder {
	PriorityQueue<Integer> minHeap = null;
	PriorityQueue<Integer> maxHeap = null;

	public MedianFinder() {
		minHeap = new PriorityQueue<>();
		maxHeap = new PriorityQueue<>((a, b) -> b - a);
	}

	public void addNum(int num) {
		if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
			maxHeap.add(num);
		} else {
			minHeap.add(num);
		}

		// either both of heap have equal no of elements or maxHeap will have
		// one more number than minHeap
		if (maxHeap.size() > minHeap.size() + 1) {
			minHeap.add(maxHeap.poll());
		}
		if (maxHeap.size() < minHeap.size()) {
			maxHeap.add(minHeap.poll());
		}
	}

	public double findMedian() {
		if (maxHeap.size() == minHeap.size()) {
			// Instead of 2.0 if we use 2 then 1.5 will change to 1
			return (maxHeap.peek() + minHeap.peek()) / 2.0;
		}
		return maxHeap.peek(); // For odd numbers, maxHeap have 1 more element
	}
}
