package com.hari.dsal.DailyBite;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import com.hari.dsal.trees.TreeNode;

public class FindTheUnique_10172020 {

	private int getMaxOnEachLevel(TreeNode root) {
		int res = -1;
		if (root == null)
			return res;

		Map<Integer, Integer> map = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (queue.size() > 0) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				TreeNode node = queue.remove();
				if (map.containsKey(node.val)) {
					map.put(node.val, map.get(node.val) + 1);
				} else {
					map.put(node.val, 1);
				}

				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}
		LinkedHashMap<Integer, Integer> lmap = new LinkedHashMap<>();

		map.entrySet().parallelStream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> lmap.put(x.getKey(), x.getValue()));
		System.out.println(map);
		System.out.println(lmap);
		return (Integer)lmap.keySet().toArray()[0];
	}

	private TreeNode initiateTree() {

		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(1);
		root.right = new TreeNode(10);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(40);

		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);

		return root;
	}

	public static void main(String[] args) {
		FindTheUnique_10172020 mv = new FindTheUnique_10172020();
		int res = mv.getMaxOnEachLevel(mv.initiateTree());

		System.out.println(res);
	}
}
