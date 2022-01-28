package com.practice.datastructures.graph.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNode implements Comparable<WeightedNode> {

	private String name;

	private int index;

	private ArrayList<WeightedNode> neighbours = new ArrayList<WeightedNode>();

	// map which represents the distance / weight of the current node with different
	// nodes
	// key of this map is the node from which the distance of the current node is
	// being maintained
	// value is the distance of that node from the current node.
	public HashMap<WeightedNode, Integer> weightMap = new HashMap<WeightedNode, Integer>();

	private boolean isVisited = false;

	public WeightedNode parent;

	// This is the shortest distance of the current node from the source node
	public int distance;

	public WeightedNode(String name, int index) {
		this.name = name;
		distance = Integer.MAX_VALUE;
		this.index = index;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(WeightedNode o) {
		return this.distance - o.distance;
	}

	public ArrayList<WeightedNode> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(ArrayList<WeightedNode> neighbours) {
		this.neighbours = neighbours;
	}

	public WeightedNode getParent() {
		return parent;
	}

	public void setParent(WeightedNode parent) {
		this.parent = parent;
	}

	public HashMap<WeightedNode, Integer> getWeightMap() {
		return weightMap;
	}

	public void setWeightMap(HashMap<WeightedNode, Integer> weightMap) {
		this.weightMap = weightMap;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
