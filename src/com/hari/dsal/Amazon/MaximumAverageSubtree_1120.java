package com.hari.dsal.Amazon;

import com.hari.dsal.trees.TreeNode;

public class MaximumAverageSubtree_1120 {
	double res = 0;

	public double maximumAverageSubtree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		maximumAverageSubtreeUtil(root);
		return res;
	}

	private Avg maximumAverageSubtreeUtil(TreeNode node) {

		// Base case
		if (node == null) {
			return new Avg(0, 0);
		}
		// Root
		int sum = node.val;
		int n = 1;
		// Left
		Avg left = maximumAverageSubtreeUtil(node.left);
		// Right
		Avg right = maximumAverageSubtreeUtil(node.right);
		// Subtree = Left + Right + Root -> Pre order tranversal
		sum += left.sum + right.sum;
		n += left.n + right.n;

		res = Math.max(res, (double) sum / (double) n);
		return new Avg(sum, n);

	}
	
	private TreeNode initiateTree1() {

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(10);
		root.right = new TreeNode(30);

		/*root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(8);

		root.right.left = new TreeNode(25);
		root.right.right = new TreeNode(35);*/

		return root;

	}
	
	public static void main(String[] args) {
		MaximumAverageSubtree_1120 ms = new MaximumAverageSubtree_1120();
		System.out.println(ms.maximumAverageSubtree(ms.initiateTree1()));
	}
}



class Avg {
	int sum;
	int n;

	Avg(int sum, int n) {
		this.sum = sum;
		this.n = n;
	}
}
