package com.hari.dsal.linkedlist;

public class DeleteDuplictaeNodes {
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode helper = new ListNode(0);
		helper.next = head;
		head = helper;

		ListNode p = head;
		ListNode q = head.next;

		while (q != null) {
			while (q.next != null && q.val == q.next.val) {
				q = q.next;
			}
			if (p.next != q) {
				p.next = q.next;
				if (q != null)
					q = q.next;
			} else {
				p = p.next;
				q = q.next;
			}
		}
		return head.next;
	}

	public static ListNode deleteDuplicates1(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
		dummyNode.next = head;

		ListNode prev = dummyNode;
		ListNode curr = head;

		while (curr != null && curr.next != null) {
			ListNode next = curr.next;
			if (curr.val == next.val) {
				while (curr.next != null && curr.val == next.val) {
					curr = curr.next;
					next = next.next;
				}

				prev.next = next;
				curr = next;
			} else {
				prev = prev.next;
				curr = curr.next;
			}
		}

		return dummyNode.next;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(0);
		ListNode node1 = new ListNode(2);
		head.next = node1;

		ListNode node2 = new ListNode(3);
		node1.next = node2;

		ListNode node3 = new ListNode(5);
		node2.next = node3;

		ListNode node4 = new ListNode(2);
		node3.next = node4;

		ListNode node5 = new ListNode(2);
		node4.next = node5;

		ListNode node6 = new ListNode(6);
		node5.next = node6;

		ListNode node7 = new ListNode(2);
		node6.next = node7;

		ListNode node8 = new ListNode(6);
		node7.next = node8;

		ListNode node9 = new ListNode(2);
		node8.next = node9;

		ListNode node10 = new ListNode(2);
		node9.next = node10;

		ListNode resNode = deleteDuplicates1(head);

		ListNode resNodeRecursive = deleteDuplicatesRecursive(head);

		while (resNode.next != null) {
			System.out.println(resNode.val);
			resNode = resNode.next;
			resNode.next = resNode.next.next;
		}

		System.out.println(resNode.val);

	}

	private static ListNode deleteDuplicatesRecursive(ListNode head) {
		if (head == null || head.next == null)
			return head;

		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;
	}

}
