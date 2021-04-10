package com.hari.dsal.linkedlist;

public class AddTwoNumbers_II_445 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// reverse lists
		l1 = reverseList(l1);
		l2 = reverseList(l2);

		ListNode head = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			// get the current values
			int x1 = l1 != null ? l1.val : 0;
			int x2 = l2 != null ? l2.val : 0;

			// current sum and carry
			int val = (carry + x1 + x2) % 10;
			carry = (carry + x1 + x2) / 10;

			// update the result: add to front
			ListNode curr = new ListNode(val);
			curr.next = head;
			head = curr;

			// move to the next elements in the lists
			l1 = l1 != null ? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}

		if (carry != 0) {
			ListNode curr = new ListNode(carry);
			curr.next = head;
			head = curr;
		}

		return head;
	}

	private ListNode reverseList(ListNode head) {
		ListNode current = head;
		ListNode prev = null;

		while (current != null) {
			ListNode newhead = current.next;
			current.next = prev;
			prev = current;
			current = newhead;
		}
		return prev;
	}
}
