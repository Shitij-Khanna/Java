package com.practice.datastructures.graph.dijkstra;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraph {

	ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

	public WeightedGraph(ArrayList<WeightedNode> nodeList) {
		this.nodeList = nodeList;
	}

	void dijkstra(WeightedNode node) {

		PriorityQueue<WeightedNode> queue = new PriorityQueue<WeightedNode>();
		node.distance = 0;
		queue.addAll(nodeList);

		while (!queue.isEmpty()) {
			WeightedNode currentNode = queue.remove();

			for (WeightedNode neighbor : currentNode.getNeighbours()) {
				if (!queue.contains(neighbor)) {
					if (neighbor.distance > currentNode.distance + currentNode.getWeightMap().get(neighbor)) {
						neighbor.distance = (currentNode.distance + currentNode.getWeightMap().get(neighbor));
						neighbor.setParent(currentNode);
						queue.remove(neighbor);
						queue.add(neighbor); // refresh queue, as weight of the node has changed, so its priority in the
												// queue will change based on that, hence it is removed and added again
					}
				}
			}
		}

		for (WeightedNode nodeToCheck : nodeList) {
			System.out.print("Node " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", Path: ");
			pathPrint(nodeToCheck);
			System.out.println();
		}
	}

	public static void pathPrint(WeightedNode node) {
		if (node.getParent() != null) {
			pathPrint(node.getParent());
		}
		System.out.print(node.getName() + " ");
	}

	public void addWeightedEdge(int i, int j, int d) {
		WeightedNode first = nodeList.get(i);
		WeightedNode second = nodeList.get(j);
		first.getNeighbours().add(second);
		first.weightMap.put(second, d);
	}

}
