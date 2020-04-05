package com.practice.datastructures.trees;

// Each node contains reference to its left child node and right child node, which 
// will be null if it is a leaf node
class Node {
	Node left;
	Node right;
	int data;
}

class BST {

	// method to insert Node in BST
	public Node insert(Node root, int val) {
		if (root == null) {
			return createNewNode(val);
		}

		// check on which side of BST the node needs to be inserted : left or right
		if (val < root.data) { // refer to comments point A and point B, since root is passed into every insert
								// method call, and is updated with the returned value, taht is why here the
								// root passed is either root.left or root.right recursively, and assigned backc
								// with the returned value
			root.left = insert(root.left, val);
		} else if (val > root.data) {
			root.right = insert(root.right, val);
		}
		return root;
	}

	// Create New Node
	private Node createNewNode(int val) {
		Node node = new Node();
		node.data = val;
		node.left = null;
		node.right = null;
		return node;
	}

	// Method to delete node from binary search tree
	// Takes root as input, deletes the Node and updates the root, and returns root
	public Node delete(Node root, int val) {
		if (root == null) {
			return root;
		}

		// check from which side the node needs to be deleted, left or right
		if (val < root.data) {
			root.left = delete(root.left, val);
		} else if (val > root.data) {
			root.right = delete(root.right, val);
		} else { // when element is found, check if it contains child nodes or not and act
					// accordingly
			if (root.left == null || root.right == null) { // either left child is null or right is null
				Node temp = root.left != null ? root.left : root.right; // temp is left if right is null and vide versa
				if (temp == null) { // i.e both left and right are null
					return null;
				} else {
					return temp; // returned the child node of the node which had to be deleted, so hierarchy is
									// changed and the node to be deleted is gone.. now the child node of the node
									// to be deleted is assigned directly to the parent of the node to be deleted
				}
			} else {
				// This means the node to be deleted has child nodes on both sides
				Node successor = getSuccessor(root);
				root.data = successor.data; // copy successor node into node to delete and delete successor node from
											// its position
				root.right = delete(root.right, successor.data);
				return root;
			}
		}
		return root;
	}

	// This method will find the successor node to be assigned to the place of the
	// deleted node.
	// This is required when the node to be deleted contains children on both sides.
	// In this case, we find the first child node on the right side, and then from
	// the first child on right, we go to find the left child till the last one is
	// found
	private Node getSuccessor(Node root) {
		if (root == null) {
			return null;
		}
		Node temp = root.right; // find the first right child

		while (temp.left != null) {
			temp = temp.left;
		}

		return temp;
	}

	public void inOrder(Node root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public void preOrder(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	public void postOrder(Node root) {
		if(root == null) {
		      return;
		    }
		    
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+ " ");		
	}
}

public class BSTApp {

	public static void main(String[] args) {
		BST bst = new BST();
		Node root = null;

		// Point A : root is passed everytime so that the function knows what is the
		// root element,
		// and root element contains links to all further elements for traversal
		root = bst.insert(root, 8);
		root = bst.insert(root, 3);
		root = bst.insert(root, 6);
		root = bst.insert(root, 10);
		root = bst.insert(root, 4);
		root = bst.insert(root, 7);
		root = bst.insert(root, 1);
		root = bst.insert(root, 14);
		root = bst.insert(root, 13);
		// Point B// after every method call, insertion/deletion, root is updated with
		// the
		// inserted/deleted value, and that is why root is assigned to whatever is
		// returned from the method

		// Traverse the tree and print elements in sorted order using Inorder depth
		// first algo
		// Left --> Root --> Right
		System.out.println("Tree sorted by InOrder algo:");
		bst.inOrder(root);
		System.out.println("");

		// Traverse the tree and print elements in PRE order using PREorder depth first
		// algo

		// Root --> Left --> Right
		System.out.println("Tree sorted by PreOrder algo:");
		bst.preOrder(root);
		System.out.println("");
		
		
		// Traverse the tree and print elements in POST order using POSTorder depth first
				// algo
		// Left --> Right --> Root
		System.out.println("Tree sorted by postOrder algo:");
		bst.postOrder(root);
		System.out.println("");

		// Now, we will look how to delete Node from BST
		root = bst.delete(root, 14);
		root = bst.delete(root, 3);

		System.out.println("After deletion of elements");
		bst.inOrder(root);
	}
}

//Reference : https://www.youtube.com/watch?v=JsgqnTLjfps&list=PLt4nG7RVVk1jqwwQUTByTcTcHxIlMllfy&index=2
//Reference : https://www.youtube.com/watch?v=81PpYQ0AN_w&list=PLt4nG7RVVk1jqwwQUTByTcTcHxIlMllfy&index=1
