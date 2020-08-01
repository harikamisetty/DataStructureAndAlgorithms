package com.hari.dsal.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS {
	public void BFT(TreeNode root) {

		if (root == null) {
			System.out.println(" Tree is EMPTY ...........");
			return;
		}

		System.out.println(" Berth First Traversal .........");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.val + " ");

			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}
	}

}
