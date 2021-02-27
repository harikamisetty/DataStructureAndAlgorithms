package com.hari.dsal.facebook;

import java.util.ArrayList;
import java.util.List;

import com.hari.dsal.trees.TreeNode;

public class BinaryTreeRightAndLeftSideView {

	private List<Integer> sideView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		rightView(root, result, 0);
		leftView(root, result, 0);
		return result;
	}
	// Right Recurssion First
	private void rightView(TreeNode root, List<Integer> result, int currDepth) {
		if (root == null)
			return;
		if (currDepth == result.size()) {
			result.add(root.val);
		}

		rightView(root.right, result, currDepth + 1);
		rightView(root.left, result, currDepth + 1);
	}
	
	// Left Recurssion First
	private void leftView(TreeNode root, List<Integer> result, int currDepth) {
		if (root == null)
			return;
		if (currDepth == result.size()) {
			result.add(root.val);
		}
		leftView(root.left, result, currDepth + 1);
		leftView(root.right, result, currDepth + 1);
	}

	private TreeNode initiateTree() {

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);

		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(8);

		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);

		root.right.left.right = new TreeNode(45);

		return root;

	}

	public static void main(String[] args) {
		BinaryTreeRightAndLeftSideView btrv = new BinaryTreeRightAndLeftSideView();
		List<Integer> res = btrv.sideView(btrv.initiateTree());

		for (Integer val : res) {
			System.out.println(val + ",");
		}
	}
}
