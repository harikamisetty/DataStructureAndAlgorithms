package com.hari.dsal.trees;

//Java program for insertion in AVL Tree
class AVLTree {

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();

		/* Constructing tree given in the above figure */
		tree.root = tree.insert(tree.root, 10);
		tree.root = tree.insert(tree.root, 20);
		tree.root = tree.insert(tree.root, 30);
		tree.root = tree.insert(tree.root, 40);
		tree.root = tree.insert(tree.root, 50);
		tree.root = tree.insert(tree.root, 25);

		/*
		 * The constructed AVL Tree would be 30 / \ 20 40 / \ \ 10 25 50
		 */
		System.out.println("Preorder traversal" + " of constructed tree is : ");
		tree.preOrder(tree.root);
	}

	Node_I root;

	// Get Balance factor of Node_I N
	int getBalance(Node_I N) {
		if (N == null)
			return 0;

		return height(N.left) - height(N.right);
	}

	// A utility function to get the height of the tree
	int height(Node_I N) {
		if (N == null)
			return 0;

		return N.height;
	}

	Node_I insert(Node_I Node_I, int key) {

		/* 1. Perform the normal BST insertion */
		if (Node_I == null)
			return (new Node_I(key));

		if (key < Node_I.data)
			Node_I.left = insert(Node_I.left, key);
		else if (key > Node_I.data)
			Node_I.right = insert(Node_I.right, key);
		else // Duplicate keys not allowed
			return Node_I;

		/* 2. Update height of this ancestor Node_I */
		Node_I.height = 1 + max(height(Node_I.left), height(Node_I.right));

		/*
		 * 3. Get the balance factor of this ancestor Node_I to check whether this
		 * Node_I became unbalanced
		 */
		int balance = getBalance(Node_I);

		// If this Node_I becomes unbalanced, then there
		// are 4 cases Left Left Case
		if (balance > 1 && key < Node_I.left.data)
			return rightRotate(Node_I);

		// Right Right Case
		if (balance < -1 && key > Node_I.right.data)
			return leftRotate(Node_I);

		// Left Right Case
		if (balance > 1 && key > Node_I.left.data) {
			Node_I.left = leftRotate(Node_I.left);
			return rightRotate(Node_I);
		}

		// Right Left Case
		if (balance < -1 && key < Node_I.right.data) {
			Node_I.right = rightRotate(Node_I.right);
			return leftRotate(Node_I);
		}

		/* return the (unchanged) Node_I pointer */
		return Node_I;
	}

	// A utility function to left rotate subtree rooted with x
	// See the diagram given above.
	Node_I leftRotate(Node_I x) {
		Node_I y = x.right;
		Node_I T2 = y.left;

		// Perform rotation
		y.left = x;
		x.right = T2;

		// Update heights
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		// Return new root
		return y;
	}

	// A utility function to get maximum of two integers
	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	// A utility function to print preorder traversal
	// of the tree.
	// The function also prints height of every Node_I
	void preOrder(Node_I Node_I) {
		if (Node_I != null) {
			System.out.print(Node_I.data + " ");
			preOrder(Node_I.left);
			preOrder(Node_I.right);
		}
	}

	// A utility function to right rotate subtree rooted with y
	// See the diagram given above.
	Node_I rightRotate(Node_I y) {
		Node_I x = y.left;
		Node_I T2 = x.right;

		// Perform rotation
		x.right = y;
		y.left = T2;

		// Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		// Return new root
		return x;
	}
}
//This code has been contributed by Mayank Jaiswal
