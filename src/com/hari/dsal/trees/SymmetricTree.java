package com.hari.dsal.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		Queue<TreeNode> lQueue = new LinkedList<TreeNode>();
		Queue<TreeNode> rQueue = new LinkedList<TreeNode>();

		lQueue.offer(root.left);
		rQueue.offer(root.right);

		while (!lQueue.isEmpty()) {
			TreeNode a = lQueue.poll();
			TreeNode b = rQueue.poll();

			if (a == null && b != null) {
				return false;
			}

			if (b == null && a != null) {
				return false;
			}

			if (a != null && b != null && a.val != b.val) {
				return false;
			}

			if (a != null) {
				lQueue.offer(a.left);
				lQueue.offer(a.right);
			}

			if (b != null) {
				rQueue.offer(b.right);
				rQueue.offer(b.left);
			}
		}
		return true;
	}
	
	private TreeNode initiateTree() {

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);

		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);

		return root;

	}
	public static void main(String[] args) {
		SymmetricTree st = new SymmetricTree();
		System.out.println(st.isSymmetric(st.initiateTree()));		
	}
}
