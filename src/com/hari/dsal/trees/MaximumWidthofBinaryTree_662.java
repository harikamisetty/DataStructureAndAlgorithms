package com.hari.dsal.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthofBinaryTree_662 {
	public int widthOfBinaryTree(TreeNode root) {
		if (root == null)
			return 0;
		int width = 1;
		Queue<TreeNode> queue = new LinkedList<>();
		LinkedList<Integer> list = new LinkedList<>();
		queue.offer(root);
		list.add(1);
		while (!queue.isEmpty()) {
			int cnt = queue.size();
			for (int i = 0; i < cnt; ++i) {
				TreeNode node = queue.poll();
				int index = list.removeFirst();
				if (node.left != null) {
					queue.offer(node.left);
					list.add(2 * index);
				}
				if (node.right != null) {
					queue.offer(node.right);
					list.add(2 * index + 1);
				}
			}
			if (list.size() > 1)
				width = Math.max(width, list.getLast() - list.getFirst() + 1);
		}
		return width;
	}
}
