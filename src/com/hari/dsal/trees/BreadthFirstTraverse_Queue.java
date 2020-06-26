package com.hari.dsal.trees;

import java.util.LinkedList;

//Iterative Queue based Java program to do level order traversal
//of Binary Tree

/* importing the inbuilt java classes required for the program */
import java.util.Queue;

/* Class to print Level Order Traversal */
class BreadthFirstTraverse_Queue {

	public static void main(String args[]) {
		/*
		 * creating a binary tree and entering the Node_Is
		 */
		BreadthFirstTraverse_Queue tree_level = new BreadthFirstTraverse_Queue();
		tree_level.root = new Node_I(1);
		tree_level.root.left = new Node_I(2);
		tree_level.root.right = new Node_I(3);
		tree_level.root.left.left = new Node_I(4);
		tree_level.root.left.right = new Node_I(5);

		System.out.println("Level order traversal of binary tree is - ");
		tree_level.printLevelOrder();
	}

	Node_I root;

	/*
	 * Given a binary tree. Print its Node_Is in level order using array for
	 * implementing queue
	 */
	void printLevelOrder() {
		Queue<Node_I> queue = new LinkedList<Node_I>();
		queue.add(root);
		while (!queue.isEmpty()) {

			/*
			 * poll() removes the present head. For more information on poll() visit
			 * http://www.tutorialspoint.com/java/util/linkedlist_poll.htm
			 */
			Node_I tempNode_I = queue.poll();
			System.out.print(tempNode_I.data + " ");

			/* Enqueue left child */
			if (tempNode_I.left != null) {
				queue.add(tempNode_I.left);
			}

			/* Enqueue right child */
			if (tempNode_I.right != null) {
				queue.add(tempNode_I.right);
			}
		}
	}
}
