package com.practice.datastructures.graph;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author x000254
 *  https://www.youtube.com/watch?v=D21-XVw6nYw&t=1127s
 */
public class GraphImplementation {

	private LinkedList<Integer> adjacencyList[];

	public GraphImplementation(int noOfVertices) {
		adjacencyList = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			  adjacencyList[i] = new LinkedList<Integer>();
		}
	}

	
	private void addEdge(int source, int destination) {
		LinkedList<Integer> neighboursOfSource = adjacencyList[source];
		neighboursOfSource.add(destination);
		
		LinkedList<Integer> neighboursOfDestination = adjacencyList[destination];
		neighboursOfSource.add(source);
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter no of vertices and edges:");
		
		int v = sc.nextInt();
		
		int e = sc.nextInt();
		
		GraphImplementation graph = new GraphImplementation(5);
		
		System.out.println("Enter " +e+ " edges:");
			for (int i = 0; i< e; i ++) {
				int source = sc.nextInt();
				int destination = sc.nextInt();
				
				graph.addEdge(source, destination);
			}

		
		
	
	}
	
	
}
