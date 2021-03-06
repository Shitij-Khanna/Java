package com.practice.datastructures.linkedlist;

public class LinkedList {

	public Node head; // head of list

	static class Node {

		int data;
		Node next;

		// Constructor
		// next is set to null be default
		Node(int d) {
			data = d;
			next = null;
		}
	}

	// Method to insert a new node
	public static LinkedList insert(LinkedList list, int data) {
		// Create a new node with given data
		Node new_node = new Node(data);
		// If the Linked List is empty,
		// then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			Node lastNode = list.head;
			while (lastNode.next != null) {
				lastNode = lastNode.next;
			}
			// Insert the new_node at last node
			lastNode.next = new_node;
		}

		// Return the list by head
		return list;
	}

	// Method to print the LinkedList.
	public static void printList(LinkedList list) {
		Node currentnode = list.head;
		System.out.print("LinkedList: ");
		while (currentnode.next != null) {
			 // Print the data at current node 
			System.out.println(currentnode.data);
			// Go to next node 
			currentnode = currentnode.next;
		}
	}
	
	// Driver code 
    public static void main(String[] args) 
    { 
        /* Start with the empty list. */
        LinkedList list = new LinkedList(); 
  
        // 
        // ******INSERTION****** 
        // 
  
        // Insert the values 
        list = insert(list, 1); 
        list = insert(list, 2); 
        list = insert(list, 3); 
        list = insert(list, 4); 
        list = insert(list, 5); 
        list = insert(list, 6); 
        list = insert(list, 7); 
        list = insert(list, 8); 
  
        // Print the LinkedList 
        printList(list); 
    } 
}

