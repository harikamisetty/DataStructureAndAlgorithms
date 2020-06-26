package com.hari.dsal.linkedlist;

public class SwapThePairs {

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode helper = new ListNode(0);
		helper.next = head;

		ListNode pre = helper;
		ListNode p = null;
		ListNode q = null;
		ListNode post = head;

		while (post != null) {
			p = post;
			q = post.next;
			if (q == null)
				break;

			post = post.next.next;
			pre.next = q;
			q.next = p;
			p.next = post;

			pre = p;
		}

		return helper.next;
	}

	public ListNode swapPairs2(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode helper = new ListNode(0);
		helper.next = head;

		ListNode pre = helper;
		ListNode cur = pre.next;

		while (cur != null && cur.next != null) {
			pre.next = cur.next;
			cur.next = cur.next.next;
			pre.next.next = cur;

			pre = cur;
			cur = pre.next;
		}

		return helper.next;
	}

	public ListNode swapPairs3(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummyNode = new ListNode(0);
		dummyNode.next = head;

		ListNode prev = dummyNode;
		ListNode curr = head;

		int count = 0;

		while (curr != null) {
			count++;
			if (count % 2 == 1) {
				curr = curr.next;
			} else {
				ListNode next = curr.next;
				curr.next = prev.next;
				prev.next.next = next;
				prev.next = curr;

				prev = curr.next;
				curr = next;
			}
		}

		return dummyNode.next;
	}

}
