package com.hari.dsal.facebook;

import com.hari.dsal.trees.TreeNode;

public class ClosestBinarySearchTreeValue_270 {
	public int closestValue(TreeNode root, double target) {

		if (target < root.val && root.left != null) {
			int left = closestValue(root.left, target);
			if (Math.abs(left - target) < Math.abs(root.val - target))
				return left;
		}

		if (target > root.val && root.right != null) {
			int right = closestValue(root.right, target);
			if (Math.abs(right - target) < Math.abs(root.val - target)) {
				return right;
			}
		}
		return root.val;
	}
}
