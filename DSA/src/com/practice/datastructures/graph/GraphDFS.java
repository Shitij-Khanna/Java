package com.practice.datastructures.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Graph {

	private List<List<Integer>> adjList;

	private boolean visited[];

	public Graph(int nodes) {
		adjList = new ArrayList<List<Integer>>();
		visited = new boolean[nodes];
		
		for (int i=0 ; i<nodes; i++) {
			adjList.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int source, int dest) {
		adjList.get(source).add(dest);
		adjList.get(dest).add(source);
	}
	
	public void dfs(int startNode) {
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(startNode);
		visited[startNode] = true;
		
		while(!stack.isEmpty()) {
			Integer node = stack.pop();
			System.out.print(node + " ");
			 
			List<Integer> neighbours =  adjList.get(node);
			
			for(Integer neighbour : neighbours) {
				if(!visited[neighbour]) {
					stack.push(neighbour);
					visited[neighbour] = true;
				}
			}
		}
	}
}

public class GraphDFS {

	  public static void main(String[] args) {
	    int nodes = 7;
	    
	    Graph a = new Graph(nodes);
	    
	    a.addEdge(0, 1);
	    a.addEdge(0, 2);
	    a.addEdge(1, 3);
	    a.addEdge(2, 4);
	    a.addEdge(3, 5);
	    a.addEdge(4, 5);
	    a.addEdge(4, 6);

	    a.dfs(0);
	  }

	}
