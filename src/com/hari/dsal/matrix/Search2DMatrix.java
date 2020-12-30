package com.hari.dsal.matrix;

public class Search2DMatrix {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };

		boolean result = search(matrix, 3);
		boolean f = searchMatrix(matrix, 3);
		Search2DMatrix sm = new Search2DMatrix();
		System.out.println(result);
		System.out.println(f);
		System.out.println(sm.searchMatrix1(matrix, 3));
	}

	private static boolean search(int[][] spiralMatrix, int target) {

		int m = spiralMatrix.length;
		int n = spiralMatrix[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (spiralMatrix[i][j] == target) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int m = matrix.length;
		int n = matrix[0].length;
		int start = 0;
		int end = m * n - 1;

		while (start <= end) {
			int mid = (start + end) / 2;
			int midX = mid / n;
			int midY = mid % n;
			if (matrix[midX][midY] == target)
				return true;
			if (matrix[midX][midY] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}

	public boolean searchMatrix1(int[][] matrix, int target) {

		int m = matrix.length;
		int n = matrix[0].length;
		int low = 0, high = m * n - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			int row = mid / n;
			int col = mid % n;

			if (matrix[row][col] == target)
				return true;
			if (matrix[row][col] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return false;
	}
}
