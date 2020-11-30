package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import com.hari.dsal.trees.TreeNode;

public class DistanceBetweenNodes_863 {

	Map<TreeNode, TreeNode> parent;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		parent = new HashMap();
		dfs(root, null);

		Queue<TreeNode> queue = new LinkedList();
		queue.add(null);
		queue.add(target);

		Set<TreeNode> seen = new HashSet();
		seen.add(target);
		seen.add(null);

		int dist = 0;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				if (dist == K) {
					List<Integer> ans = new ArrayList();
					for (TreeNode n : queue)
						ans.add(n.val);
					return ans;
				}
				queue.offer(null);
				dist++;
			} else {
				if (!seen.contains(node.left)) {
					seen.add(node.left);
					queue.offer(node.left);
				}
				if (!seen.contains(node.right)) {
					seen.add(node.right);
					queue.offer(node.right);
				}
				TreeNode par = parent.get(node);
				if (!seen.contains(par)) {
					seen.add(par);
					queue.offer(par);
				}
			}
		}

		return new ArrayList<Integer>();
	}

	public void dfs(TreeNode node, TreeNode par) {
		if (node != null) {
			parent.put(node, par);
			dfs(node.left, node);
			dfs(node.right, node);
		}
	}

	private TreeNode getTarget(TreeNode root, TreeNode target) {
		Queue<TreeNode> queue = new LinkedList<>();
		if (root != null) {
			queue.offer(root);
		}
		while (queue.size() > 0) {
			TreeNode tempNode = queue.poll();
			if (tempNode.right != null)
				queue.offer(tempNode.right);
			if (tempNode.left != null)
				queue.offer(tempNode.left);
			if (tempNode.val == target.val)
				return tempNode;
		}

		return null;
	}
	
	private TreeNode initiateTree1() {

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

		DistanceBetweenNodes_863 db = new DistanceBetweenNodes_863();
		TreeNode target = new TreeNode(25);
		List<Integer> res = db.distanceK(db.initiateTree1(), db.getTarget(db.initiateTree1(), target), 2);

		for (int val : res) {
			System.out.println(val);
		}
	}
}
