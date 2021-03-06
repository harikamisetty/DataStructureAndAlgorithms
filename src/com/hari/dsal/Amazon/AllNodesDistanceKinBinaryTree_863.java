package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodesDistanceKinBinaryTree_863 {
	Map<TreeNode, TreeNode> parent;
	
	
	// BFS with QUEUE with SET
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		parent = new HashMap<>();
		dfs(root, null);

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(null); // Add null to avoid K=0 condition
		queue.add(target);

		Set<TreeNode> seen = new HashSet<>();
		seen.add(target);
		seen.add(null);

		int dist = 0;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			
			if (node == null) {
			
				if (dist == K) {
					List<Integer> ans = new ArrayList<>();
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
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
