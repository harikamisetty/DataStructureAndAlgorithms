package com.hari.dsal.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree_655 {
	public List<List<String>> printTree(TreeNode root) {
		List<List<String>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		int rows = Depth(root);
		int cols = (int) Math.pow(2, rows) - 1;

		for (int i = 0; i < rows; i++) {
			List<String> list = new ArrayList<>();

			for (int j = 0; j < cols; j++) {
				list.add("");
			}
			res.add(list);
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		Queue<int[]> index = new LinkedList<>();
		index.offer(new int[] { 0, cols - 1 });
		int row = -1;

		while (!queue.isEmpty()) {
			int size = queue.size();
			row++;

			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				int[] indexes = index.poll();
				int left = indexes[0];
				int right = indexes[1];

				int mid = (right + left) / 2;
				res.get(row).set(mid, String.valueOf(cur.val));

				if (cur.left != null) {
					queue.offer(cur.left);
					index.offer(new int[] { left, mid - 1 });
				}

				if (cur.right != null) {
					queue.offer(cur.right);
					index.offer(new int[] { mid + 1, right });
				}
			}
		}
		return res;
	}

	public int Depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(Depth(root.left), Depth(root.right));
	}
}
