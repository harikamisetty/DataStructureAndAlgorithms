package com.hari.dsal.trees;

public class ConvertSortedArraytoBinarySearchTree_108 {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null)
			return null;
		return subArrayBuilder(nums, 0, nums.length - 1);

	}

	private TreeNode subArrayBuilder(int[] nums, int left, int right) {
		if (left > right)
			return null;
		if (left == right)
			return new TreeNode(nums[left]);

		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = subArrayBuilder(nums, left, mid - 1);
		root.right = subArrayBuilder(nums, mid + 1, right);

		return root;
	}
}
