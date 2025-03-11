package graph_general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class L133_CloneGraph {
	Map<Node, Node> cloneMap = new HashMap<>();
	public static void main(String[] args) {

	}

	public Node cloneGraphDFS(Node node) {
		if (node == null) {
			return null;
		}

		Node newNode = new Node(node.val);
		cloneMap.put(node, newNode); // Node is not present, checked through neighour check

		for (Node neighbour : node.neighbors) {
			if (cloneMap.get(neighbour) == null) {
				newNode.neighbors.add(cloneGraphDFS(neighbour));
			} else {
				newNode.neighbors.add(cloneMap.get(neighbour)); // This is the recursion break condition
			}
		}

		return cloneMap.get(node);
	}

	public Node cloneGraphBFS(Node node) {
		if (node == null) {
			return null;
		}

		Map<Node, Node> cloneMap = new HashMap<>();
		cloneMap.put(node, new Node(node.val, new ArrayList<>()));

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			Node currNode = queue.poll();

			for (Node neighbour : currNode.neighbors) {
				if (cloneMap.get(neighbour) == null) {
					cloneMap.put(neighbour,
							new Node(neighbour.val, new ArrayList<>()));
					queue.add(neighbour);// THis should noe be outside the if the condition, otherwise
					                      // infinite loop happens because the queue is always adding nodes
				}

				cloneMap.get(currNode).neighbors.add(cloneMap.get(neighbour));
			}
		}
		return cloneMap.get(node);
	}
}

class Node {
	public int val;
	public List<Node> neighbors;
	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}
	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}
