package com.hari.dsal.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubTrees_652 {
	Map<String, Integer> s = new HashMap<>();
	List<TreeNode> ret = new ArrayList<>();

	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		findDuplicateSubtreesUtils(root);
		return ret;
	}

	public String findDuplicateSubtreesUtils(TreeNode node) {
		if (node == null) {
			return "-";
		}

		String l = findDuplicateSubtreesUtils(node.left);
		if (!l.equals("-")) {
			if (s.getOrDefault(l, 0) == 1) {
				ret.add(node.left);
			}
			s.put(l, s.getOrDefault(l, 0) + 1);
		}
		String r = findDuplicateSubtreesUtils(node.right);
		if (!r.equals("-")) {
			if (s.getOrDefault(r, 0) == 1) {
				ret.add(node.right);
			}
			s.put(r, s.getOrDefault(r, 0) + 1);
		}
		return "l=[" + l + "],root=[" + node.val + "],r=[" + r + "]";
	}
}
