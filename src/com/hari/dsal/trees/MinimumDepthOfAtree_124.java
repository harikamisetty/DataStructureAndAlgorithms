package com.hari.dsal.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfAtree_124 {

	public static void main(String[] args) {
		MinimumDepthOfAtree_124 mdt = new MinimumDepthOfAtree_124();
		System.out.println(mdt.minDepth(mdt.initiateTree()));
	}

	private TreeNode initiateTree() {

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);

		// root.left.left = new TreeNode(5);
		// root.left.right = new TreeNode(8);

		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);

		return root;

	}

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int depth = 0;
		while (!queue.isEmpty()) {
			++depth;
			int size = queue.size();

			for (int i = 0; i < size; i++) {
				TreeNode node = queue.remove();

				if (node.left == null && node.right == null) {
					return depth;
				}

				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
		return depth;
	}
}
