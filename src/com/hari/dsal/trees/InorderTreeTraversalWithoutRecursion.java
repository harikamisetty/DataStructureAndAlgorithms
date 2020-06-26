package com.hari.dsal.trees;

//non-recursive java program for inorder traversal
import java.util.Stack;

/* Class containing left and right child of
current Node_I and key value*/
/* Class to print the inorder traversal */
class InorderTreeTraversalWithoutRecursion {
	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the Node_Is
		 */
		InorderTreeTraversalWithoutRecursion tree = new InorderTreeTraversalWithoutRecursion();
		Node_I rootNode_I = new Node_I(1);
		rootNode_I.left = new Node_I(2);
		rootNode_I.right = new Node_I(3);
		rootNode_I.left.left = new Node_I(4);
		rootNode_I.left.right = new Node_I(5);
		tree.inorder();
	}

	Node_I root;

	void inorder() {
		if (root == null)
			return;

		Stack<Node_I> s = new Stack<Node_I>();
		Node_I curr = root;

		// traverse the tree
		while (curr != null || s.size() > 0) {

			/*
			 * Reach the left most Node_I of the curr Node_I
			 */
			while (curr != null) {
				/*
				 * place pointer to a tree Node_I on the stack before traversing the Node_I's
				 * left subtree
				 */
				s.push(curr);
				curr = curr.left;
			}

			/* Current must be NULL at this point */
			curr = s.pop();

			System.out.print(curr.data + " ");

			/*
			 * we have visited the Node_I and its left subtree. Now, it's right subtree's
			 * turn
			 */
			curr = curr.right;
		}
	}
}
