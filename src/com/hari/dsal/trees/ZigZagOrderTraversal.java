package com.hari.dsal.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigZagOrderTraversal {
	private static void printZigZagTree2(TreeNode root) {
		zigzagLevelOrder(root);
	}

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		zigzagLevelOrder(root, result, 1);

		return result;
	}

	private static void zigzagLevelOrder(TreeNode root, ArrayList<ArrayList<Integer>> result, int level) {
		if (root == null)
			return;

		if (result.size() < level) {
			ArrayList<Integer> levelList = new ArrayList<Integer>();
			if ((level % 2) == 1) {
				levelList.add(root.val);
			} else {
				levelList.add(0, root.val);
			}
			result.add(levelList);
		} else {
			if ((level % 2) == 1) {
				result.get(level - 1).add(root.val);
			} else {
				result.get(level - 1).add(0, root.val);
			}
		}

		zigzagLevelOrder(root.left, result, level + 1);
		zigzagLevelOrder(root.right, result, level + 1);
	}

	private static List<List<Integer>> printZigZagTree1(TreeNode root) {
		// Whole logic based on results list size.
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelList = new ArrayList<Integer>();
			if (result.size() % 2 == 0) {
				for (int i = 0; i < size; i++) {
					TreeNode curr = queue.poll();
					levelList.add(curr.val);

					if (curr.left != null) {
						queue.offer(curr.left);
					}

					if (curr.right != null) {
						queue.offer(curr.right);
					}
				}
			} else {
				Stack<Integer> stack = new Stack<Integer>();
				for (int i = 0; i < size; i++) {
					TreeNode curr = queue.poll();
					stack.push(curr.val);

					if (curr.left != null) {
						queue.offer(curr.left);
					}

					if (curr.right != null) {
						queue.offer(curr.right);
					}
				}

				while (!stack.isEmpty()) {
					levelList.add(stack.pop());
				}
			}
			result.add(levelList);
		}
		return result;
	}
}
