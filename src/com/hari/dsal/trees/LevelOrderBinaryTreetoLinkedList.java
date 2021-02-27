package com.hari.dsal.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBinaryTreetoLinkedList {
	public LLNode solve(Tree root) {

		Queue<Tree> queue = new LinkedList<>();
		queue.add(root);
		LLNode dummy = new LLNode(0);
		LLNode head = dummy;
		
		// Queue empty
		while (!queue.isEmpty()) {
			// Queue Size
			for (int i = 0; i < queue.size(); i++) {
				Tree tempTre = queue.remove();
				LLNode temp = new LLNode(tempTre.val);
				head.next = temp;
				head = temp;

				if (tempTre.left != null)
					queue.add(tempTre.left);
				if (tempTre.right != null)
					queue.add(tempTre.right);

			}

		}
		return dummy.next;
	}
}

class LLNode {
	public LLNode(int i) {
		this.val = i;
	}

	int val;
	LLNode next;
}

class Tree {
	int val;
	Tree left;
	Tree right;
}
