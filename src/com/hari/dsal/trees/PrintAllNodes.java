package com.hari.dsal.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*	 POINTS
 *
 * - BFT is always with Queue / LinkedList
 * - DFT is with recursive or with Stack
 * - http://buttercola.blogspot.com/search?q=Flatten+Binary+Tree+to+Linked+List
 * - http://buttercola.blogspot.com/search?q=Symmetric+Tree
 * - http://buttercola.blogspot.com/2014/12/data-structure-algorithms-binary-search.html
 * - http://buttercola.blogspot.com/search?q=Binary+Tree+Inorder+Traversal
 * - http://buttercola.blogspot.com/search?q=Binary+Tree+Maximum+Path+Sum
 *
 *
 */

public class PrintAllNodes {

	private static List<Integer> vals;

	private static int maxSum = Integer.MIN_VALUE;

	private static int min = Integer.MIN_VALUE;

	private static void BFT(Node_I root) {

		if (root == null) {
			System.out.println(" Tree is EMPTY ...........");
			return;
		}

		System.out.println(" Berth First Traversal .........");
		Queue queue = new LinkedList<Node_I>();
		queue.add(root);

		while (!queue.isEmpty()) {
			Node_I temp = (Node_I) queue.poll();
			System.out.print(temp.data + " ");

			if (temp.left != null)
				queue.add(temp.left);
			if (temp.right != null)
				queue.add(temp.right);
		}
	}

	private static void binaryTreeMaximumPathSum(Node_I root) {
		maxPathSum(root);
	}

	/*
	 * public boolean isUnivalTree(TreeNode_I root) { boolean left_correct =
	 * (root.left == null || (root.val == root.left.val &&
	 * isUnivalTree(root.left))); boolean right_correct = (root.right == null ||
	 * (root.val == root.right.val && isUnivalTree(root.right))); return
	 * left_correct && right_correct; }
	 */

	private static void convertSortedListToBinarySearchTree(ListNode_I head) {

		Node_I root = sortedListToBST(head);
		preOrderTraversal(root);
	}

	public static void dfs(Node_I Node_I) {
		if (Node_I != null) {
			vals.add(Node_I.data);
			dfs(Node_I.left);
			dfs(Node_I.right);
		}
	}

	private static void DFSWithStack(Node_I root) {
		if (root == null)
			System.out.println(" Tree is EMPTY........");
		Stack results = new Stack();
		Stack stack = new Stack();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node_I temp = (Node_I) stack.pop();
			results.push(temp);
			if (temp != null) {
				if (temp.left != null) {
					stack.push(temp.left);
				}

				if (temp.right != null) {
					stack.push(temp.right);
				}
			}
		}

		System.out.println("\n DFT POSTORDER Traversal using STACK ............");
		while (!results.isEmpty()) {
			Node_I res = (Node_I) results.pop();
			System.out.print(res.data + " ");
		}
	}

	private static void DFT(Node_I root) {

		if (root == null)
			System.out.println(" Tree is EMPTY ...........");
		System.out.println(" \n In Order Traversal........");
		inOrderTraversal(root);
		System.out.println("\n Pre Order Traversal........");
		preOrderTraversal(root);
		System.out.println("\n Post Order Traversal........");
		postOrderTraversal(root);
	}

	private static void flattenTheTree(Node_I root) {
		Queue results = new LinkedList<>();
		Stack tempStack = new Stack();

		tempStack.push(root);
		System.out.println("\n Flatten TREE Results ............");
		while (!tempStack.isEmpty()) {

			Node_I curr = (Node_I) tempStack.pop();
			results.add(curr);
			if (curr != null) {
				if (curr.left != null) {
					tempStack.push(curr.left);
				}

				if (curr.right != null) {
					tempStack.push(curr.right);
				}
				if (curr.left != null) {
					Node_I rChild = curr.right;
					curr.right = curr.left;
					curr.left = null;

					// find the right most child
					Node_I rightMostChild = curr.right;

					while (rightMostChild.right != null) {
						rightMostChild = rightMostChild.right;
					}

					rightMostChild.right = rChild;
				}
			}
		}

		// Print Queue Values
		while (!results.isEmpty()) {
			Node_I printNode_I = (Node_I) results.poll();
			System.out.print(printNode_I.data + " ");
		}
	}

	private static int heightOfTree(Node_I root) {
		if (root == null)
			return -1;

		int leftHeight = heightOfTree(root.left);
		int rightHeight = +heightOfTree(root.right);

		if (leftHeight > rightHeight)
			return leftHeight + 1;
		else
			return rightHeight + 1;
	}

	private static int heightOfTree1(Node_I root) {
		if (root == null)
			return 0;

		int left = heightOfTree1(root.left) + 1;
		int right = heightOfTree1(root.right) + 1;

		if (left > right)
			return left;
		else
			return right;
	}

	private static int[] initializeArray() {
		int a[] = { 2, 4, 6, 8, 9, 12, 14, 18 };
		return a;
	}

	private static ListNode_I initiateListNode_I() {
		ListNode_I head = new ListNode_I(2);
		ListNode_I first = new ListNode_I(4);
		head.next = first;
		ListNode_I second = new ListNode_I(6);
		first.next = second;
		ListNode_I third = new ListNode_I(8);
		second.next = third;
		ListNode_I four = new ListNode_I(9);
		third.next = four;
		ListNode_I five = new ListNode_I(12);
		four.next = five;
		ListNode_I six = new ListNode_I(14);
		five.next = six;
		ListNode_I seven = new ListNode_I(18);
		six.next = seven;

		return head;
	}

	private static Node_I initiateTree() {

		Node_I root = new Node_I(20);
		root.left = new Node_I(10);
		root.right = new Node_I(30);

		root.left.left = new Node_I(5);
		root.left.right = new Node_I(8);

		root.right.left = new Node_I(25);
		root.right.right = new Node_I(35);

		return root;

	}

	private static ArrayList<Integer> inOrderTraversal(Node_I root) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		if (root == null)
			return result;

		Stack<Node_I> stack = new Stack<Node_I>();

		Node_I p = root;
		while (!stack.empty() || p != null) {
			if (p != null) {
				stack.push(p);
				p = p.left;
			} else {
				Node_I temp = stack.pop();
				result.add(temp.data);
				p = temp.right;
			}
		}
		return result;

	}

	private static void inOrderTraversalRecursive(Node_I root) {
		if (root != null) {
			inOrderTraversalRecursive(root.left);
			System.out.print(root.data + " ");
			inOrderTraversalRecursive(root.right);
		}
	}

	public static boolean inOrderTraverse(Node_I Node_I) {
		if (Node_I == null)
			return true;

		if (inOrderTraverse(Node_I.left) == false)
			return false;

		if (Node_I.data > min) {
			min = Node_I.data;
		} else
			return false;

		if (inOrderTraverse(Node_I.right) == false)
			return false;

		return true;
	}

	private static Node_I InvertBinaryTree(Node_I root) {

		Queue<Node_I> queue = new LinkedList<Node_I>();
		if (root == null) {
			return null;
		}

		queue.offer(root);

		while (!queue.isEmpty()) {
			Node_I curr = queue.poll();

			if (curr.left != null) {
				queue.offer(curr.left);
			}

			if (curr.right != null) {
				queue.offer(curr.right);
			}

			Node_I temp = curr.left;
			curr.left = curr.right;
			curr.right = temp;
		}

		return root;

	}

	private static Node_I InvertBinaryTreeRecursive(Node_I root) {
		if (root == null) {
			return null;
		}

		Node_I temp = root.left;

		root.left = InvertBinaryTreeRecursive(root.right);
		root.right = InvertBinaryTreeRecursive(temp);

		return root;
	}

	private static boolean isMirrorTree(Node_I root) {
		return isSameTree1(root.left, root.right);
	}

	private static boolean isMirrorTreeRecursive(Node_I root) {
		boolean res = isSameTree1(root.left, root.right);
		return isSameTree(root.left, root.right);
	}

	private static boolean isSame(Node_I p, Node_I q) {
		if (p == null)
			return q == null;
		if (q == null)
			return false;

		if (p.data != q.data)
			return false;

		if (isSame(p.left, q.left) == false)
			return false;
		if (isSame(p.right, q.right) == false)
			return false;

		return true;
	}

	public static boolean isSameTree(Node_I p, Node_I q) {
		return isSame(p, q);
	}

	public static boolean isSameTree1(Node_I p, Node_I q) {
		if (p == null && q == null)
			return true;

		Queue<Node_I> lQueue = new LinkedList<Node_I>();
		Queue<Node_I> rQueue = new LinkedList<Node_I>();

		lQueue.offer(p);
		rQueue.offer(q);
		if (lQueue.isEmpty() || rQueue.isEmpty())
			return false;

		while (!lQueue.isEmpty() && !rQueue.isEmpty()) {
			Node_I lCurr = lQueue.poll();
			Node_I rCurr = rQueue.poll();

			if (lCurr == null && rCurr == null)
				continue;
			if (lCurr == null || rCurr == null)
				return false;

			if (lCurr.data != rCurr.data)
				return false;

			lQueue.offer(lCurr.left);
			lQueue.offer(lCurr.right);
			rQueue.offer(rCurr.left);
			rQueue.offer(rCurr.right);
		}

		return true;
	}

	public static boolean isUnivalTree(Node_I root) {
		vals = new ArrayList();
		dfs(root);
		for (int v : vals)
			if (v != vals.get(0))
				return false;
		return true;
	}

	public static boolean isValidBST(Node_I root) {
		if (root == null)
			return true;

		return inOrderTraverse(root);
	}

	public static void main(String[] args) {
		// printAllNode_Is(initiateTree());
		convertSortedListToBinarySearchTree(initiateListNode_I());
		System.out.println("\n hghdghdghh");
		Node_I finalRoot = mergeTrees(initiateTree(), initiateTree());
		preOrderTraversal(finalRoot);
		System.out.println("\n hghdghdghh");
		Node_I finalRoot1 = mergeTrees(initiateTree(), null);
		preOrderTraversal(finalRoot1);
		System.out.println("\n hghdghdghh");
		Node_I finalRoot2 = mergeTrees(null, initiateTree());
		preOrderTraversal(finalRoot2);
		System.out.println("\n isUnivalTree");
		System.out.println(isUnivalTree(initiateTree()));
		System.out.println("Height os tree is :" + heightOfTree1(initiateTree()));
	}

	public static int maxPathSum(Node_I root) {
		if (root == null) {
			return 0;
		}
		maxPathSumHelper(root);
		return maxSum;
	}

	private static int maxPathSumHelper(Node_I root) {
		if (root == null) {
			return 0;
		}

		int left = maxPathSumHelper(root.left);
		int right = maxPathSumHelper(root.right);

		int arch = left + right + root.data;
		// To resolve Negative numbers
		int pathSum = Math.max(root.data, Math.max(left, right) + root.data);

		maxSum = Math.max(maxSum, Math.max(arch, pathSum));

		return pathSum;
	}

	private static Node_I mergeTrees(Node_I root1, Node_I root2) {

		if (root1 == null && root2 == null)
			return null;

		if (root1 == null && root2 != null)
			return root2;

		if (root1 != null && root2 == null)
			return root1;
		Node_I root = new Node_I((root1 != null ? root1.data : 0) + (root2 != null ? root2.data : 0));

		root.left = mergeTrees(root1 != null ? root1.left : null, root2 != null ? root2.left : null);
		root.right = mergeTrees(root1 != null ? root1.right : null, root2 != null ? root2.right : null);

		return root;
	}

	private static void pathSum(Node_I root, int sum) {

		if (root == null || sum <= 0) {
			System.out.println(" Operation Can't be Completed.........");
		}
		Node_I tempNode_I = root;
		int resSum = root.data;
		while (tempNode_I != null) {
			Node_I rootleft = tempNode_I.left;
			while (rootleft != null) {
				resSum = resSum + rootleft.data;
				rootleft = rootleft.left;
			}
			if (resSum == sum) {
				System.out.println("\n Found....SUM...........");
			}
		}
	}

	private static boolean pathSum2(Node_I root, int sum) {
		if (root == null)
			return false;

		Stack<Node_I> Node_IStack = new Stack<Node_I>();
		Stack<Integer> sumStack = new Stack<Integer>();

		Node_IStack.push(root);
		sumStack.push(root.data);

		while (!Node_IStack.empty()) {
			Node_I curr = Node_IStack.pop();
			int pathSum = sumStack.pop();

			if (curr.left == null && curr.right == null && pathSum == sum)
				return true;

			if (curr.right != null) {
				Node_IStack.push(curr.right);
				sumStack.push(pathSum + curr.right.data);
			}

			if (curr.left != null) {
				Node_IStack.push(curr.left);
				sumStack.push(pathSum + curr.left.data);
			}
		}
		return false;
	}

	public static ArrayList<ArrayList<Integer>> pathSum3(Node_I root, int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> Node_Is = new ArrayList<Integer>();

		preOrderTraversal(root, 0, sum, result, Node_Is);

		return result;
	}

	private static void postOrderTraversal(Node_I root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}

	private static void preOrderTraversal(Node_I root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}

	private static void preOrderTraversal(Node_I root, int pathSum, int sum, ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> Node_Is) {
		if (root == null)
			return;

		Node_Is.add(root.data);
		pathSum += root.data;

		// root is leaf
		if (root.left == null && root.right == null && pathSum == sum) {
			result.add(Node_Is);
		}

		preOrderTraversal(root.left, pathSum, sum, result, new ArrayList<Integer>(Node_Is));
		preOrderTraversal(root.right, pathSum, sum, result, new ArrayList<Integer>(Node_Is));
	}

	private static void printAllNode_Is(Node_I root) {

		BFT(root);
		DFT(initiateTree());
		DFSWithStack(initiateTree());
		flattenTheTree(initiateTree());
		// pathSum(initiateTree(), 35);
		System.out.println(pathSum2(initiateTree(), 38)); // http://buttercola.blogspot.com/search?q=Path+Sum
		ArrayList<ArrayList<Integer>> results = pathSum3(initiateTree(), 38); // Recursive
		System.out.println("\n Height of the Tree :" + heightOfTree(initiateTree()));
		InvertBinaryTreeRecursive(initiateTree());
		InvertBinaryTree(initiateTree());// BFT
		isMirrorTreeRecursive(initiateTree()); // Symmetric Tree
		isMirrorTree(initiateTree());
		printZigZagTree1(initiateTree());
		printZigZagTree2(initiateTree());
		inOrderTraversalRecursive(initiateTree());
		inOrderTraversal(initiateTree());
		validateBinarySearchTree(initiateTree());
		binaryTreeMaximumPathSum(initiateTree());// Using PostOrderTraversal
		sortedArrayToBinarySearchTree(); // PretOrderTraversal
		convertSortedListToBinarySearchTree(initiateListNode_I());

		Node_I finalRoot = mergeTrees(initiateTree(), initiateTree());
		preOrderTraversal(finalRoot);

		isUnivalTree(initiateTree());
		heightOfTree1(initiateTree());
	}

	private static List<List<Integer>> printZigZagTree1(Node_I root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}

		Queue<Node_I> queue = new LinkedList<Node_I>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> levelList = new ArrayList<Integer>();
			if (result.size() % 2 == 0) {
				for (int i = 0; i < size; i++) {
					Node_I curr = queue.poll();
					levelList.add(curr.data);

					if (curr.left != null) {
						queue.offer(curr.left);
					}

					if (curr.right != null) {
						queue.offer(curr.right);
					}
				}
			} else {
				Stack<Integer> stack = new Stack<Integer>();
				for (int i = 0; i < size; i++) {
					Node_I curr = queue.poll();
					stack.push(curr.data);

					if (curr.left != null) {
						queue.offer(curr.left);
					}

					if (curr.right != null) {
						queue.offer(curr.right);
					}
				}

				while (!stack.isEmpty()) {
					levelList.add(stack.pop());
				}
			}
			result.add(levelList);
		}

		return result;

	}

	private static void printZigZagTree2(Node_I root) {
		zigzagLevelOrder(root);
	}

	private static void sortedArrayToBinarySearchTree() {
		sortedArrayToBST(initializeArray());
	}

	public static Node_I sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0)
			return null;

		return toBST(num, 0, num.length - 1);
	}

	public static Node_I sortedListToBST(ListNode_I head) {

		return toBSTHelper(head);
	}

	private static Node_I toBST(int[] num, int lo, int hi) {
		if (lo > hi)
			return null;

		int mid = (lo + hi) / 2;

		Node_I root = new Node_I(num[mid]);
		root.left = toBST(num, lo, mid - 1);
		root.right = toBST(num, mid + 1, hi);

		return root;
	}

	private static Node_I toBSTHelper(ListNode_I head) {
		if (head == null) {
			return null;
		}

		if (head.next == null) {
			return new Node_I(head.val);
		}

		// Find middle minus one Node_I of the linked list
		ListNode_I slow = head;
		ListNode_I fast = head;
		while (fast != null && fast.next != null && fast.next.next != null && fast.next.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode_I mid = slow.next;
		Node_I root = new Node_I(mid.val);

		slow.next = null;

		root.left = toBSTHelper(head);
		root.right = toBSTHelper(mid.next);

		return root;
	}

	/*
	 * Assume a BST is defined as follows:
	 *
	 * The left subtree of a Node_I contains only Node_Is with keys less than the
	 * Node_I's key. The right subtree of a Node_I contains only Node_Is with keys
	 * greater than the Node_I's key. Both the left and right subtrees must also be
	 * binary search trees.
	 */
	private static void validateBinarySearchTree(Node_I root) {

		isValidBST(root);
	}

	public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node_I root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		zigzagLevelOrder(root, result, 1);

		return result;
	}

	private static void zigzagLevelOrder(Node_I root, ArrayList<ArrayList<Integer>> result, int level) {
		if (root == null)
			return;

		if (result.size() < level) {
			ArrayList<Integer> levelList = new ArrayList<Integer>();
			if ((level % 2) == 1) {
				levelList.add(root.data);
			} else {
				levelList.add(0, root.data);
			}
			result.add(levelList);
		} else {
			if ((level % 2) == 1) {
				result.get(level - 1).add(root.data);
			} else {
				result.get(level - 1).add(0, root.data);
			}
		}

		zigzagLevelOrder(root.left, result, level + 1);
		zigzagLevelOrder(root.right, result, level + 1);
	}
}
