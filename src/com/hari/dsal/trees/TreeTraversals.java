package com.hari.dsal.trees;

//Java program for different tree traversals

/* Class containing left and right child of current
Node_I and key value*/
class TreeTraversals {
	// Driver method
	public static void main(String[] args) {
		TreeTraversals tree = new TreeTraversals();
		tree.root = new Node_I(1);
		tree.root.left = new Node_I(2);
		tree.root.right = new Node_I(3);
		tree.root.left.left = new Node_I(4);
		tree.root.left.right = new Node_I(5);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder();

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder();

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder();
	}

	// Root of Binary Tree
	Node_I root;

	TreeTraversals() {
		root = null;
	}

	void printInorder() {
		printInorder(root);
	}

	/* Given a binary tree, print its Node_Is in inorder */
	void printInorder(Node_I Node_I) {
		if (Node_I == null)
			return;

		/* first recur on left child */
		printInorder(Node_I.left);

		/* then print the data of Node_I */
		System.out.print(Node_I.data + " ");

		/* now recur on right child */
		printInorder(Node_I.right);
	}

	// Wrappers over above recursive functions
	void printPostorder() {
		printPostorder(root);
	}

	/*
	 * Given a binary tree, print its Node_Is according to the "bottom-up" postorder
	 * traversal.
	 */
	void printPostorder(Node_I Node_I) {
		if (Node_I == null)
			return;

		// first recur on left subtree
		printPostorder(Node_I.left);

		// then recur on right subtree
		printPostorder(Node_I.right);

		// now deal with the Node_I
		System.out.print(Node_I.data + " ");
	}

	void printPreorder() {
		printPreorder(root);
	}

	/* Given a binary tree, print its Node_Is in preorder */
	void printPreorder(Node_I Node_I) {
		if (Node_I == null)
			return;

		/* first print data of Node_I */
		System.out.print(Node_I.data + " ");

		/* then recur on left sutree */
		printPreorder(Node_I.left);

		/* now recur on right subtree */
		printPreorder(Node_I.right);
	}
}
