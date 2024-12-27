package graph_general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class L133_CloneGraph {
	public static void main(String[] args) {

	}

	public static Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}

		Map<Node, Node> map = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();

		queue.add(node);
		map.put(node, new Node(node.val, new ArrayList<Node>()));

		while (!queue.isEmpty()) {
			Node h = queue.poll();

			for (Node neighbour : h.neighbors) {
				if (!map.containsKey(neighbour)) {
					map.put(neighbour,
							new Node(neighbour.val, new ArrayList<Node>()));
					queue.add(neighbour);
				}
				map.get(h).neighbors.add(map.get(neighbour));
			}
		}
		return map.get(node);
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
