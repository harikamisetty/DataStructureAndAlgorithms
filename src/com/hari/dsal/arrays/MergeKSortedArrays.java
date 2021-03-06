package com.hari.dsal.arrays;

import java.util.PriorityQueue;

public class MergeKSortedArrays {
	private class HeapNode {
		public int rowNum;
		public int index;
		public int value;

		public HeapNode(int rowNum, int index, int value) {
			this.rowNum = rowNum;
			this.index = index;
			this.value = value;
		}
	}

	public int[] mergeKSortedArrays(int[][] arrays) {

		if (arrays == null)
			return null;

		PriorityQueue<HeapNode> minHeap = new PriorityQueue<>(arrays.length,
				(HeapNode a, HeapNode b) -> a.value - b.value);

		int size = 0;
		for (int i = 0; i < arrays.length; i++) {
			size += arrays[i].length;
		}
		int[] result = new int[size]; // k * n

		// add first elements in the array to this heap
		for (int i = 0; i < arrays.length; i++) {
		if(arrays[i].length != 0)
			minHeap.add(new HeapNode(i, 0, arrays[i][0]));
		}

		// Complexity O(n * k * log k)
		for (int i = 0; i < size; i++) {
			// Take the minimum value and put into result
			HeapNode node = minHeap.poll();

			if (node != null) {
				result[i] = node.value;
				if (node.index + 1 < arrays[node.rowNum].length) {
					// Complexity of O(log k)
					minHeap.add(new HeapNode(node.rowNum, node.index + 1, arrays[node.rowNum][node.index + 1]));
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		/*int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11,12 };
		int[][] matrix = new int[][] { arr1, arr2, arr3 };*/
		
		int[][] matrix = {
		         {},
		         {},
		         {10, 12},
		         {},
		         {3, 3, 13},
		         {3},
		         {10},
		         {0, 7}
		};
		
		MergeKSortedArrays mksa = new MergeKSortedArrays();
		for(int val : mksa.mergeKSortedArrays(matrix)) {
			System.out.print(val+",");
		}
	}
}
