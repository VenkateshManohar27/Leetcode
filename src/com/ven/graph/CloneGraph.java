package com.ven.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Definition for a Node.
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

public class CloneGraph {
	/*
	 * public Node cloneGraph(Node node) { if (node == null) { return null; }
	 * 
	 * 
	 * Queue<Node> qGraph = new LinkedList<Node>(); Queue<Node> qCloneGraph = new
	 * LinkedList<Node>(); Set<Node> visited = new HashSet<>();
	 * 
	 * qGraph.add(node); Node res = new Node(node.val); qCloneGraph.add(res); //
	 * visited.add(node); while (!qGraph.isEmpty()) { Node n = qGraph.poll(); Node
	 * temp = qCloneGraph.poll(); if (!visited.contains(n)) { visited.add(n);
	 * List<Node> nghbrs = n.neighbors; List<Node> cloneNeighbors = new
	 * ArrayList<Node>(); for (Node neighbor : nghbrs) { Node clone = new
	 * Node(neighbor.val); cloneNeighbors.add(clone); qGraph.add(neighbor);
	 * qCloneGraph.add(clone); } temp.neighbors = cloneNeighbors;
	 * 
	 * }
	 * 
	 * }
	 * 
	 * return res;
	 * 
	 * 
	 * return copyNode(node, new HashMap<Node, Node>()); }
	 */

	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		return copyNode(node, new HashMap<Node, Node>());
	}

	private Node copyNode(Node original, HashMap<Node, Node> map) {
		if (map.containsKey(original))
			return map.get(original);
		Node copy = new Node(original.val);
		map.put(original, copy);
		for (Node neighbor : original.neighbors) {
			copy.neighbors.add(copyNode(neighbor, map));
		}

		return copy;
	}

	public Node cloneGraph2(Node node) {
		if (node == null) {
			return null;
		}
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		Queue<Node> nodes = new LinkedList<>();
		nodes.add(node);
		map.put(node, new Node(node.val));
		while (!nodes.isEmpty()) {
			Node temp = nodes.poll();
			for (Node neighbor : temp.neighbors) {
				if (!map.containsKey(neighbor)) {
					nodes.add(neighbor);
					map.put(neighbor, new Node(neighbor.val));
					
				}
				
				map.get(temp).neighbors.add(map.get(neighbor));
			}

		}

		return map.get(node);
	}

}
