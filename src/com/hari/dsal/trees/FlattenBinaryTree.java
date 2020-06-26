package com.hari.dsal.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FlattenBinaryTree {
	
	private static void flattenTheTree(TreeNode root) {
		Queue results = new LinkedList<>();
		Stack tempStack = new Stack();

		tempStack.push(root);
		System.out.println("\n Flatten TREE Results ............");
		while (!tempStack.isEmpty()) {

			TreeNode curr = (TreeNode) tempStack.pop();
			results.add(curr);
			if (curr != null) {
				if (curr.left != null) {
					tempStack.push(curr.left);
				}

				if (curr.right != null) {
					tempStack.push(curr.right);
				}
				if (curr.left != null) {
					TreeNode rChild = curr.right;
					curr.right = curr.left;
					curr.left = null;

					// find the right most child
					TreeNode rightMostChild = curr.right;

					while (rightMostChild.right != null) {
						rightMostChild = rightMostChild.right;
					}

					rightMostChild.right = rChild;
				}
			}
		}

		// Print Queue Values
		while (!results.isEmpty()) {
			TreeNode printNode = (TreeNode) results.poll();
			System.out.print(printNode.val + " ");
		}
	}
}
