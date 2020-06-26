package com.hari.dsal.trees;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorBinaryTree {
	
	private boolean isMirrorTreeRecursive(TreeNode root) {
		boolean res = isSameTree1(root.left, root.right);
		return isSameTree(root.left, root.right);
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		return isSame(p, q);
	}

	private boolean isSame(TreeNode p, TreeNode q) {
		if (p == null)
			return q == null;
		if (q == null)
			return false;

		if (p.val != q.val)
			return false;

		if (isSame(p.left, q.left) == false)
			return false;
		if (isSame(p.right, q.right) == false)
			return false;

		return true;
	}

	private boolean isMirrorTree(TreeNode root) {
		return isSameTree1(root.left, root.right);
	}

	public boolean isSameTree1(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;

		Queue<TreeNode> lQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> rQueue = new LinkedList<TreeNode>();

		lQueue.offer(p);
		rQueue.offer(q);
		if (lQueue.isEmpty() || rQueue.isEmpty())
			return false;

		while (!lQueue.isEmpty() && !rQueue.isEmpty()) {
			TreeNode lCurr = lQueue.poll();
			TreeNode rCurr = rQueue.poll();

			if (lCurr == null && rCurr == null)
				continue;
			if (lCurr == null || rCurr == null)
				return false;

			if (lCurr.val != rCurr.val)
				return false;

			lQueue.offer(lCurr.left);
			lQueue.offer(lCurr.right);
			rQueue.offer(rCurr.left);
			rQueue.offer(rCurr.right);
		}

		return true;
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

	public static void main(String[] args) {
		MirrorBinaryTree vbst = new MirrorBinaryTree();
		System.out.println(vbst.isMirrorTree(vbst.initiateTree()));
	}
}
