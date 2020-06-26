package com.hari.dsal.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TreTraversalDynamic {

	private static void inOrderTraversal(Node_I Node_I) {

	}

	public static void main(String[] args) {
		System.out.println("Hello ............");
		Node_I Node_I = new Node_I("A");
		Node_I.left = new Node_I("B");
		Node_I.right = new Node_I("C");
		Node_I.left.left = new Node_I("D");
		Node_I.left.right = new Node_I("E");
		Node_I.right.left = new Node_I("F");
		Node_I.right.right = new Node_I("G");

		treeTraverseDyn(Node_I);
	}

	private static void postOrderTraversal(Node_I Node_I) {

		Node_I tempNode_I = Node_I;
		Node_I root = Node_I;
		List<Node_I> Node_IList = new ArrayList<>();
		Node_IList.add(tempNode_I);

		while (tempNode_I.left != null) {
			tempNode_I = tempNode_I.left;
			Node_IList.add(tempNode_I);
		}

		Collections.reverse(Node_IList);

		for (Node_I Node_I1 : Node_IList) {

			if (Node_I1.left != null) {
				System.out.print(Node_I1.left.getStrData() + " -> ");
			}
			if (Node_I1.right != null && Node_I1 != root) {
				System.out.print(Node_I1.right.getStrData() + " -> ");
			}
		}

		tempNode_I = root;
		Node_IList = new ArrayList<>();
		while (tempNode_I.right != null) {
			tempNode_I = tempNode_I.right;
			Node_IList.add(tempNode_I);
		}

		Collections.reverse(Node_IList);

		for (Node_I Node_I1 : Node_IList) {
			if (Node_I1.left != null) {
				System.out.print(Node_I1.left.getStrData() + " -> ");
			}

			if (Node_I1.right != null && Node_I1 != root) {
				System.out.print(Node_I1.right.getStrData() + " -> ");
			}

		}
		System.out.print(root.right.getStrData() + " -> ");
		System.out.print(root.getStrData());
	}

	private static void preOrderTraversal(Node_I Node_I) {
		// TODO Auto-generated method stub

	}

	private static void treeTraverseDyn(Node_I Node_I) {

		inOrderTraversal(Node_I);
		preOrderTraversal(Node_I);
		postOrderTraversal(Node_I);

	}

}
