package com.hari.dsal.number;

import com.hari.dsal.leetcode.ListNode;

public class AddTwoNumbers {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// check if the linked list is null
		if (l1 == null && l2 == null)
			return null;

		int carry = 0;

		ListNode p1 = l1;
		ListNode p2 = l2;
		ListNode p3 = new ListNode(0);
		ListNode head = p3;

		while (p1 != null || p2 != null) {
			if (p1 != null) {
				carry += p1.val;
				p1 = p1.next;
			}

			if (p2 != null) {
				carry += p2.val;
				p2 = p2.next;
			}

			int d3 = carry % 10;
			carry /= 10;

			head.next = new ListNode(d3);
			head = head.next;
		}

		if (carry == 1) {
			head.next = new ListNode(1);
			head = head.next;
		}

		return p3.next;
	}

	public static void main(String[] args) {

	}
}
