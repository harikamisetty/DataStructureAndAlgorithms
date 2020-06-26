package com.hari.dsal.trees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
	
	private static TreeNode InvertBinaryTree(TreeNode root) {

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (root == null) {
			return null;
		}

		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();

			if (curr.left != null) {
				queue.offer(curr.left);
			}

			if (curr.right != null) {
				queue.offer(curr.right);
			}

			TreeNode temp = curr.left;
			curr.left = curr.right;
			curr.right = temp;
		}

		return root;
	}

	private static TreeNode InvertBinaryTreeRecursive(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode temp = root.left;

		root.left = InvertBinaryTreeRecursive(root.right);
		root.right = InvertBinaryTreeRecursive(temp);

		return root;
	}
}
