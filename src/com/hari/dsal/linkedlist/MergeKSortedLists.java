package com.hari.dsal.linkedlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	// #1
	public ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;
		if (lists.size() == 1)
			return lists.get(0);
		int numLists = lists.size();

		return merge(lists, 0, numLists - 1);
	}

	private ListNode merge(ArrayList<ListNode> lists, int lo, int hi) {
		if (lo == hi)
			return lists.get(lo);

		int mid = (lo + hi) / 2;
		ListNode l1 = merge(lists, lo, mid);
		ListNode l2 = merge(lists, mid + 1, hi);

		return mergeTwoLists(l1, l2);
	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;

		ListNode head = new ListNode(0);
		ListNode p = head;

		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}
		if (p1 != null)
			p.next = p1;
		else if (p2 != null)
			p.next = p2;

		return head.next;
	}

	// #2
	public ListNode mergeKLists2(ArrayList<ListNode> lists) {

		if (lists == null || lists.size() == 0)
			return null;
		if (lists.size() == 1)
			return lists.get(0);

		int numLists = lists.size();
		ListNode newHead = new ListNode(0);
		ListNode l1, l2;

		for (int i = 1; i < numLists; i++) {
			if (i == 1) {
				l1 = lists.get(0);
			} else {
				l1 = newHead;
			}
			l2 = lists.get(i);

			newHead = mergeTwoLists(l1, l2);
		}
		return newHead;
	}

// Merge two sorted linked lists
	private ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode head = new ListNode(0);
		ListNode p = head;

		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}

		if (p1 != null)
			p.next = p1;
		else if (p2 != null)
			p.next = p2;

		return head.next;
	}

// #3
	public ListNode mergeKLists3(ArrayList<ListNode> lists) {
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

	// Array merges
	public int[] mergeKSortedArray(int[][] arr) {
		// PriorityQueue is heap in Java
		PriorityQueue<ArrayContainer> queue = new PriorityQueue<ArrayContainer>();
		int total = 0;

		// add arrays to heap
		for (int i = 0; i < arr.length; i++) {
			queue.add(new ArrayContainer(arr[i], 0));
			total = total + arr[i].length;
		}

		int m = 0;
		int result[] = new int[total];

		// while heap is not empty
		while (!queue.isEmpty()) {
			ArrayContainer ac = queue.poll();
			result[m++] = ac.arr[ac.index];

			if (ac.index < ac.arr.length - 1) {
				queue.add(new ArrayContainer(ac.arr, ac.index + 1));
			}
		}

		return result;
	}

	class ArrayContainer implements Comparable<ArrayContainer> {
		int[] arr;
		int index;

		public ArrayContainer(int[] arr, int index) {
			this.arr = arr;
			this.index = index;
		}

		@Override
		public int compareTo(ArrayContainer o) {
			return this.arr[this.index] - o.arr[o.index];
		}
	}

	// Recursive Solution
	public ListNode mergeTwoLists_rec(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return l1 == null ? l2 : l1;

		if (l1.val > l2.val) {
			ListNode temp = l1;
			l1 = l2;
			l2 = temp;
		}
		l1.next = mergeTwoLists(l1.next, l2);

		return l1;
	}

	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };
		int[][] matrix = new int[][] { arr1, arr2, arr3 };

		MergeKSortedLists msl = new MergeKSortedLists();
		for (int val : msl.mergeKSortedArray(matrix)) {
			System.out.println(val + ",");
		}
	}

}
