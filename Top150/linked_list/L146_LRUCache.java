package linked_list;

import java.util.HashMap;
import java.util.Map;

public class L146_LRUCache {

}

class LRUCache {
	private Map<Integer, Node> map = new HashMap<>();
	private Node head;
	private Node tail;
	private int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.head = new Node(-1, -1);
		this.tail = new Node(-1, -1);
		this.head.next = tail;
		this.tail.prev = head;
	}

	public void insert(Node node) {
		map.put(node.key, node);
		node.next = head.next;
		head.next = node;
		node.next.prev = node;
		node.prev = head;
	}

	public void remove(Node node) {
		map.remove(node.key);
		tail.prev = node.prev;
		tail.prev.next = tail;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			remove(map.get(key));
		}

		if (map.size() == capacity) {
			remove(tail.prev);
		}

		insert(new Node(key, value));
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null) {
			return -1;
		}

		remove(node);
		insert(node);
		return node.value;
	}

	class Node {
		Node next;
		Node prev;
		int key;
		int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
}
