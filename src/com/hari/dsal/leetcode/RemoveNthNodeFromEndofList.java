package com.hari.dsal.leetcode;

import com.hari.dsal.linkedlist.ListNode;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {

		int count = 1;

		while (head.next != null) {
			count++;
			head = head.next;
		}
		System.out.println(count);
		if (count < n)
			return null;

		return null;
	}

	public ListNode removeNthFromEnd1(ListNode head, int n) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int length = 0;
		ListNode first = head;
		while (first != null) {
			length++;
			first = first.next;
		}
		// Total Length - Node number
		length -= n;
		first = dummy;
		while (length > 0) {
			length--;
			first = first.next;
		}
		first.next = first.next.next;
		return dummy.next;
	}

	public static void main(String[] args) {
		RemoveNthNodeFromEndofList rnfl = new RemoveNthNodeFromEndofList();
		ListNode head = new ListNode(2);
		ListNode node1 = new ListNode(4);
		head.next = node1;

		ListNode node2 = new ListNode(3);
		node1.next = node2;

		node2.next = null;

		ListNode heada = new ListNode(5);
		ListNode nodea1 = new ListNode(6);
		heada.next = nodea1;

		ListNode nodea2 = new ListNode(4);
		nodea1.next = nodea2;

		nodea2.next = null;
		System.out.println(rnfl.removeNthFromEnd(head, 4));

	}
}
