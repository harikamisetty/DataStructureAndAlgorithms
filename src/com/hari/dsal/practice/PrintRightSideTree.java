package com.hari.dsal.practice;

import java.util.ArrayList;
import java.util.List;

public class PrintRightSideTree {

	public static void main(String[] args) {
		PrintRightSideTree btl = new PrintRightSideTree();
		List<Integer> retList = new ArrayList<>();
		btl.printRightTree(retList, btl.initiateTree().right);

		retList.forEach(list -> {
			System.out.println("\n");

			System.out.print(list + ",");
		});
	}

	private TreeNode initiateTree() {

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);

		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(8);

		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);

		return root;

	}

	private void printRightTree(List<Integer> list, TreeNode root) {

		if (root != null) {
			list.add(root.val);
		}

		if (root.right == null && root.left == null) {
			return;
		}
		printRightTree(list, root.right);
		printRightTree(list, root.left);
	}
}
