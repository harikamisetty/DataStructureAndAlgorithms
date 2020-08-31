package com.hari.dsal.mislanious;

import java.util.Arrays;
import java.util.List;

public class NodeDistance {
	
	public static  int foo(List<Integer> values, int node1, int node2) {
	    // Write your code here
		 TreeNode root = buildBST(values, node1, node2);
		    if (root == null) return -1;
		    TreeNode lca = lca(root, node1, node2);
		    return getDistance(lca, node1) + getDistance(lca, node2);
	  }
	private static int getDistance(TreeNode src, int dest) {
	    if (src.val == dest) return 0;
	    TreeNode node = src.left;
	    if (src.val < dest) {
	        node = src.right;
	    }
	    return 1 + getDistance(node, dest);
	}

	private static TreeNode lca(TreeNode root, int node1, int node2) {
	    while (true) {
	        if (root.val > node1 && root.val > node2) {
	            root = root.left;
	        } else if (root.val < node1 && root.val < node2) {
	            root = root.right;
	        } else {
	            return root;
	        }
	    }
	}

	private static TreeNode buildBST(List<Integer> nums, int node1, int node2) {
	    TreeNode root = null;
	    boolean found1 = false;
	    boolean found2 = false;
	    for (int val : nums) {
	        if (val == node1) found1 = true;
	        if (val == node2) found2 = true;
	        NodeDistance x = new NodeDistance();
	        TreeNode node = x.new TreeNode(val);
	        if (root == null) {
	            root = node;
	            continue;
	        }
	        addToBST(root, node);
	    }
	    if (!found1 || !found2) return null;
	    return root;
	}

	private static void addToBST(TreeNode root, TreeNode node) {
	    for (TreeNode curr = root; true; ) {
	        if (curr.val > node.val) {
	            if (curr.left == null) {
	                curr.left = node;
	                break;
	            } else {
	                curr = curr.left;
	            }
	        } else {
	            if (curr.right == null) {
	                curr.right = node;
	                break;
	            } else {
	                curr = curr.right;
	            }
	        }
	    }
	}
	
	public static void main(String[] args) {
		NodeDistance nd= new NodeDistance();
		List<Integer> input = Arrays.asList(5,7,8,9,3,5);
		System.out.println(nd.foo(input, 5, 8));
	}
	
	class TreeNode {

		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int x) {
			val = x;
		}
	}
}
