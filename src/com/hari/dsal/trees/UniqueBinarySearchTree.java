package com.hari.dsal.trees;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTree {
	
	private int getUniqueBinaryTrees(int num) {
		int[] G = new int[num+1];
		G[0] = G[1] = 1;
		
		for(int i =2; i<=num; i++) {
			for(int j = 1; j <=i; ++j) {
				G[i] = G[i]+ G[j-1] * G[i - j]; // fORMULA
			}
		}
		return G[num];
	}
	
	private static List<TreeNode> generateTrees(int num) {
		return genTrees(1, num);
	}
	
	private static List<TreeNode> genTrees(int start, int end) {
		
		List<TreeNode> list = new ArrayList<>();
		
		if(start > end) {
			list.add(null);
			return list;
		}
		
		for(int i = start; i<=end; i++) {
			List<TreeNode> left = genTrees(start,i-1);
			List<TreeNode> right = genTrees(i+1, end);
			
			for(TreeNode lnode: left) {
				for(TreeNode rnode : right) {
					TreeNode  root = new TreeNode(i);
					root.left = lnode;
					root.right = rnode;
					list.add(root);
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		UniqueBinarySearchTree ubst = new UniqueBinarySearchTree();
		//System.out.println(ubst.getUniqueBinaryTrees(3));
		
		// Best Approch
		List<TreeNode> results = generateTrees(3);
		
		System.out.println(results.size());
	}
}
