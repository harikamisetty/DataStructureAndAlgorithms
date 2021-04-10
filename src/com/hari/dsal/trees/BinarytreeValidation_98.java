package com.hari.dsal.trees;

import java.util.ArrayList;

public class BinarytreeValidation_98 {
	public boolean solve_1(Tree root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean checkBST(Tree root, int min, int max) {
		if (root == null)
			return true;

		if (root.val < min || root.val > max) {
			return false;
		}

		if (root.left != null && root.val < root.left.val)
			return false;
		if (root.right != null && root.val > root.right.val)
			return false;
		return checkBST(root.left, min, root.val) && checkBST(root.right, root.val, max);
	}

	// #2
	ArrayList<Integer> list = new ArrayList<>();

	public void inorder(Tree root) {
		if (root == null)
			return;
		inorder(root.left);
		list.add(root.val);
		inorder(root.right);
	}

	public boolean solve(Tree root) {
		inorder(root);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) < list.get(i - 1))
				return false;
		}
		return true;
	}
}
