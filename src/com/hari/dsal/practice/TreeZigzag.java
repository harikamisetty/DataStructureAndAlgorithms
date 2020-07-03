package com.hari.dsal.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class TreeZigzag {

	public static void main(String[] args) {
		TreeZigzag btl = new TreeZigzag();
		List<Integer> retList = new ArrayList<>();
		btl.getZigzagTree(retList, btl.initiateTree());

		retList.forEach(list -> {
			System.out.println("\n");

			System.out.print(list + ",");
		});
	}

	private TreeNode getZigzagTree(List<Integer> res, TreeNode root) {

		Queue queue = new LinkedList<>();
		Stack stack = new Stack();

		queue.add(root.val);
		int level = 1;
		while (!queue.isEmpty()) {
			if (level % 2 != 0) {
				res.add((Integer) (queue.poll()));
			} else {
				stack.add(queue.poll());
			}

		}

		return null;
	}

	private TreeNode initiateTree() {

		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(20);

		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(7);

		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(30);

		root.left.left.right = new TreeNode(1);
		root.left.left.left = new TreeNode(4);

		root.left.right.left = new TreeNode(6);
		root.left.right.right = new TreeNode(9);

		return root;

	}
}
