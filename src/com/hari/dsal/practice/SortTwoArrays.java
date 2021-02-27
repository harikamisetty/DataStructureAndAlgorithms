package com.hari.dsal.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.hari.dsal.linkedlist.ListNode;

public class SortTwoArrays {

	// Merge LinkedLists
	public ListNode mergeKLists(ListNode[] lists) {
		return mergeKLists3(Arrays.asList(lists));
	}

	public ListNode mergeKLists3(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		if (lists.size() == 1)
			return lists.get(0);

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new ListNodeComparator());

		// Add first element of each list into the queue
		for (ListNode x : lists) {
			if (x != null)
				pq.add(x);
		}

		// retrive the minimum element from the queue and insert the next one
		ListNode head = new ListNode(0);
		ListNode p = head;
		while (pq.size() > 0) {
			ListNode temp = pq.poll();
			p.next = temp;

			if (temp.next != null)
				pq.add(temp.next);
			p = p.next;
		}
		return head.next;
	}

	private class ListNodeComparator implements Comparator<ListNode> {
		public int compare(ListNode l1, ListNode l2) {
			return l1.val - l2.val;
		}
	}

	// Merge Lists
	private List<Integer> mergeLists(List<List<Integer>> lists) {
		List<Integer> res = new ArrayList<>();

		return res;
	}

	// Merge Arrays
	private int[] mergeArrays() {

		return null;
	}

	private int[] sortArrays(int[] a, int[] b) {
		int[] res = new int[a.length + b.length];
		int i = 0, j = 0, k = 0;

		if (a == null || a.length == 0)
			return b;

		if (b == null || b.length == 0)
			return a;

		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				res[k++] = a[i++];
			} else if (a[i] > b[j]) {
				res[k++] = b[j++];
			} else {
				res[k++] = a[i++];
				res[k++] = b[j++];
			}
		}

		if (i < a.length) {
			while (i < a.length) {
				res[k++] = a[i++];
			}
		}

		if (j < b.length) {
			while (j < b.length) {
				res[k++] = b[j++];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		SortTwoArrays sta = new SortTwoArrays();
		int[] a = { 2, 3, 4, 5, 90 };
		int[] b = { 3, 4, 6, 8, 78 };

		for (int val : sta.sortArrays(a, b)) {
			System.out.print(val + ",");
		}
	}
}
