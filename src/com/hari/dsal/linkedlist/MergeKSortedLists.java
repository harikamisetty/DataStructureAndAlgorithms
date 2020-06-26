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
}
