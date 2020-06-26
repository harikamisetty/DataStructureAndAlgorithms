package com.hari.dsal.trees;

/*
 * 1) Create an empty stack S.
2) Initialize current Node_I as root
3) Push the current Node_I to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right
     c) Go to step 3.
5) If current is NULL and stack is empty then we are done.
 */

//non-recursive java program for inorder traversal
import java.util.Stack;

/* Class containing left and right child of
current Node_I and key value*/

/* Class to print the inorder traversal */
class DepthFirstTraverse_Stack {
	public static void main(String args[]) {

		/*
		 * creating a binary tree and entering the Node_Is
		 */
		DepthFirstTraverse_Stack tree = new DepthFirstTraverse_Stack();
		tree.root = new Node_I(1);
		tree.root.left = new Node_I(2);
		tree.root.right = new Node_I(3);
		tree.root.left.left = new Node_I(4);
		tree.root.left.right = new Node_I(5);
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
