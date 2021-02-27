package com.hari.dsal.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversalIterative {
	
	public int[] solve(Tree root) {

		if (root == null)
			return new int[0];

		Stack<Tree> s = new Stack<Tree>();
		Tree curr = root;
		List<Integer> res = new ArrayList<>();

		// traverse the tree
		while (curr != null || s.size() > 0) {

			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			res.add(curr.val);
			curr = curr.right;
		}
		return res.stream().mapToInt(Integer::intValue).toArray();
	}
}
