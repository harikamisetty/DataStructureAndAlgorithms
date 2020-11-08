package com.hari.dsal.DailyBite;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hari.dsal.trees.TreeNode;

public class GatherLevels_10182020 {

	private List<List<Integer>> getEachLevel(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);

		while (queue.size() >0) {
			int len = queue.size();
			List<Integer> temp = new ArrayList<>();

			for (int i = 0; i < len; i++) {
				TreeNode node = queue.remove();
				temp.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			if(!temp.isEmpty())
				res.add(temp);
		}
		return res;
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
		GatherLevels_10182020 mv = new GatherLevels_10182020();
		List<List<Integer>> res = mv.getEachLevel(mv.initiateTree());
		
		for(List val : res) {
			System.out.println(val);
		}
	}


}
