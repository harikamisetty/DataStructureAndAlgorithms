package com.hari.dsal.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST_449 {
	// BST
	private static final String SEP = ",";
	private static final String NULL = "null";

	public TreeNode deserialize(String data) {
		if (data.equals(NULL))
			return null;

		String[] strs = data.split(SEP);
		Queue<String> q = new LinkedList<>();
		for (String s : strs) {
			q.offer(s);
		}
		return getNode(q);
	}

	private TreeNode getNode(Queue<String> q) {
		if (q.isEmpty())
			return null;
		String val = q.remove();

		if (val.equals(NULL)) {
			return null;
		} else {
			TreeNode node = new TreeNode(Integer.valueOf(val));
			node.left = getNode(q);
			node.right = getNode(q);
			return node;
		}
	}

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();

		if (root == null)
			return sb.append(NULL).append(SEP).toString();
		buildString(root, sb);
		return sb.toString();
	}

	private void buildString(TreeNode root, StringBuilder sb) {
		if (root == null) {
			sb.append(NULL).append(SEP);
			return;
		} else {
			sb.append(root.val).append(SEP);
			buildString(root.left, sb);
			buildString(root.right, sb);
		}
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
		SerializeAndDeserializeBST_449 sdbst = new SerializeAndDeserializeBST_449();
		String str = sdbst.serialize(sdbst.initiateTree());
		System.out.println(str);
		TreeNode root = sdbst.deserialize(str);
	}
}