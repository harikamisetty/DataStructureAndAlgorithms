package com.hari.dsal.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeserializeBST {

	private static final String SEP = ",";
	private static final String NULL = "null";

	public TreeNode deserialize(String data) {
		if (data.equals(NULL))
			return null;

		String[] strs = data.split(SEP);
		Queue<Integer> q = new LinkedList<>();
		for (String s : strs) {
			q.offer(Integer.parseInt(s));
		}
		return getNode(q);
	}

	private TreeNode getNode(Queue<Integer> q) {
		if (q.isEmpty())
			return null;
		TreeNode root = new TreeNode(q.poll());

		Queue<Integer> smallerQueue = new LinkedList<>();
		while (!q.isEmpty() && q.peek() < root.val) {
			smallerQueue.offer(q.poll());
		}

		root.left = getNode(smallerQueue);
		root.right = getNode(q);
		return root;
	}

	public String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();

		if (root == null)
			return null;
		Stack<TreeNode> st = new Stack<>();
		st.push(root);

		while (!st.empty()) {
			root = st.pop();
			sb.append(root.val).append(SEP);
			if (root.right != null)
				st.push(root.right);
			if (root.left != null)
				st.push(root.left);
		}
		return sb.toString();
	}

}
