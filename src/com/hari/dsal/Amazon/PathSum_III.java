package com.hari.dsal.Amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import com.hari.dsal.trees.TreeNode;

public class PathSum_III {

	// ARRAY as input
	public int subarraySum(int[] nums, int k) {
		int count = 0, currSum = 0;
		HashMap<Integer, Integer> h = new HashMap<>();

		for (int num : nums) {
			// current prefix sum
			currSum += num;

			// situation 1:
			// continuous subarray starts
			// from the beginning of the array
			if (currSum == k)
				count++;

			// situation 2:
			// number of times the curr_sum − k has occured already,
			// determines the number of times a subarray with sum k
			// has occured upto the current index
			count += h.getOrDefault(currSum - k, 0);

			// add the current sum
			h.put(currSum, h.getOrDefault(currSum, 0) + 1);
		}

		return count;
	}

	public static void main(String[] args) {
		int a[] = { 3, 4, 1, 6, -3 };
		PathSum_III p3 = new PathSum_III();
		System.out.println(p3.subarraySum(a, 7));
	}

	// TREE as input
	public int pathSum(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		Queue<Tuple> q = new LinkedList<>();
		q.offer(new Tuple(0, root, true));
		int count = 0;
		while (!q.isEmpty()) {
			Tuple t = q.poll();

			if (t.node == null) {
				continue;
			}

			int currSum = t.currSum + t.node.val;

			if (currSum == sum) {
				count++;
			}

			q.offer(new Tuple(currSum, t.node.left, t.first));
			q.offer(new Tuple(currSum, t.node.right, t.first));

			if (t.first) {
				q.offer(new Tuple(0, t.node.left, false));
				q.offer(new Tuple(0, t.node.right, false));
			}
		}
		return count;
	}
}

class Tuple {
	int currSum;
	TreeNode node;
	boolean first; // if this is first traversal to avoid duplicate counts

	public Tuple(int currSum, TreeNode node, boolean first) {
		this.currSum = currSum;
		this.node = node;
		this.first = first;
	}
}
