package com.hari.dsal.trees;

//Java program to find height of tree

//A binary tree Node_I
class TreeHeight {
	/* Driver program to test above functions */
	public static void main(String[] args) {
		TreeHeight tree = new TreeHeight();

		tree.root = new Node_I(1);
		tree.root.left = new Node_I(2);
		tree.root.right = new Node_I(3);
		tree.root.left.left = new Node_I(4);
		tree.root.left.right = new Node_I(5);

		System.out.println("Height of tree is : " + tree.maxDepth(tree.root));
	}

	Node_I root;

	/*
	 * Compute the "maxDepth" of a tree -- the number of Node_Is along the longest
	 * path from the root Node_I down to the farthest leaf Node_I.
	 */
	int maxDepth(Node_I Node_I) {
		if (Node_I == null)
			return 0;
		else {
			/* compute the depth of each subtree */
			int lDepth = maxDepth(Node_I.left);
			int rDepth = maxDepth(Node_I.right);

			/* use the larger one */
			if (lDepth > rDepth)
				return (lDepth + 1);
			else
				return (rDepth + 1);
		}
	}
}

//This code has been contributed by Mayank Jaiswal(mayank_24) 
