package com.hari.dsal.trees;

//Recursive Java program for level order traversal of Binary Tree

/* Class containing left and right child of current
Node_I and key value*/
class BreadthFirstTraverse {
	/* Driver program to test above functions */
	public static void main(String args[]) {
		BreadthFirstTraverse tree = new BreadthFirstTraverse();
		tree.root = new Node_I(1);
		tree.root.left = new Node_I(2);
		tree.root.right = new Node_I(3);
		tree.root.left.left = new Node_I(4);
		tree.root.left.right = new Node_I(5);

		System.out.println("Level order traversal of binary tree is ");
		tree.printLevelOrder();
	}

	// Root of the Binary Tree
	Node_I root;

	public BreadthFirstTraverse() {
		root = null;
	}

	/*
	 * Compute the "height" of a tree -- the number of Node_Is along the longest
	 * path from the root Node_I down to the farthest leaf Node_I.
	 */
	int height(Node_I root) {
		if (root == null)
			return 0;
		else {
			/* compute height of each subtree */
			int lheight = height(root.left);
			int rheight = height(root.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print Node_Is at the given level */
	void printGivenLevel(Node_I root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.data + " ");
		else if (level > 1) {
			printGivenLevel(root.left, level - 1);
			printGivenLevel(root.right, level - 1);
		}
	}

	/* function to print level order traversal of tree */
	void printLevelOrder() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}
}
