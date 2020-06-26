package com.hari.dsal.trees;

//Java implementation of a O(n) time
//method for Zigzag order traversal
import java.util.Stack;

class BinaryTree {
	Node_I rootNode_I;

//function to print the
//zigzag traversal
	void printZigZagTraversal() {

		// if null then return
		if (rootNode_I == null) {
			return;
		}

		// declare two stacks
		Stack<Node_I> currentLevel = new Stack<>();
		Stack<Node_I> nextLevel = new Stack<>();

		// push the root
		currentLevel.push(rootNode_I);
		boolean leftToRight = true;

		// check if stack is empty
		while (!currentLevel.isEmpty()) {

			// pop out of stack
			Node_I Node_I = currentLevel.pop();

			// print the data in it
			System.out.print(Node_I.data + " ");

			// store data according to current
			// order.
			if (leftToRight) {
				if (Node_I.left != null) {
					nextLevel.push(Node_I.left);
				}

				if (Node_I.right != null) {
					nextLevel.push(Node_I.right);
				}
			} else {
				if (Node_I.right != null) {
					nextLevel.push(Node_I.right);
				}

				if (Node_I.left != null) {
					nextLevel.push(Node_I.left);
				}
			}

			if (currentLevel.isEmpty()) {
				leftToRight = !leftToRight;
				Stack<Node_I> temp = currentLevel;
				currentLevel = nextLevel;
				nextLevel = temp;
			}
		}
	}
}

public class ZigZagTreeTraversal {

//driver program to test the above function
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.rootNode_I = new Node_I(1);
		tree.rootNode_I.left = new Node_I(2);
		tree.rootNode_I.right = new Node_I(3);
		tree.rootNode_I.left.left = new Node_I(7);
		tree.rootNode_I.left.right = new Node_I(6);
		tree.rootNode_I.right.left = new Node_I(5);
		tree.rootNode_I.right.right = new Node_I(4);

		System.out.println("ZigZag Order traversal of binary tree is");
		tree.printZigZagTraversal();
	}
}

//This Code is contributed by Harikrishnan Rajan.
