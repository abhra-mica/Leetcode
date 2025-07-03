package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Heap {
	public List<Integer> heap = null;// With array cant go seamlessly

	public static void main(String[] args) {
		Integer[] heap = {5, 7, 9, 8, 11, 12, 14, 13, 10};
		List<Integer> nums = new ArrayList<>(Arrays.asList(heap));
		Heap myheap = new Heap(nums);
		myheap.insert(2);
		System.out.println(myheap.heap);
		myheap.remove();
		System.out.println(myheap.heap);
		myheap.remove();
		System.out.println(myheap.heap);
	}

	public Heap(List<Integer> heap) {
		this.heap = heap;
	}

	private int getParentIdx(int index) {
		return (index - 1) / 2;
	}

	private int getLeftChildIdx(int pIndex) {
		return pIndex * 2 + 1;
	}

	private int getRightChildIdx(int pIndex) {
		return pIndex * 2 + 2;
	}

	public void insert(int val) {
		heap.add(val);
		upheap(heap.size() - 1);
	}

	private void upheap(int index) {
		if (index == 0) {
			return;
		}

		int pIndex = getParentIdx(index);
		// Recursively calling its parent index
		if (heap.get(pIndex) > heap.get(index)) {
			swap(pIndex, index);
			upheap(pIndex);
		}
	}

	private void swap(int firstIdx, int secondIdx) {
		int temp = heap.get(firstIdx);
		heap.set(firstIdx, heap.get(secondIdx));
		heap.set(secondIdx, temp);
	}

	public int remove() {
		if (heap.isEmpty()) {
			throw new RuntimeException("No elements");
		}

		int lastEle = heap.remove(heap.size() - 1);
		int removedEle = heap.get(0);
		heap.set(0, lastEle);

		if (!heap.isEmpty()) {
			downheap(0);
		}
		return removedEle;
	}

	private void downheap(int index) {
		if (index >= heap.size()) {
			return;
		}
		int minIdx = index;
		int leftIndex = getLeftChildIdx(index);
		int rightIndex = getRightChildIdx(index);

		if (leftIndex < heap.size() && heap.get(leftIndex) < heap.get(minIdx)) {
			minIdx = leftIndex;
		}

		if (rightIndex < heap.size()
				&& heap.get(rightIndex) < heap.get(minIdx)) {
			minIdx = rightIndex;
		}

		if (minIdx != index) {// base condition for recursion
			swap(minIdx, index);
			downheap(minIdx);
		}
	}

	public List<Integer> heapSort() throws Exception {
		List<Integer> data = new ArrayList<>();
		while (!heap.isEmpty()) {
			data.add(remove());
		}
		return data;
	}
}
