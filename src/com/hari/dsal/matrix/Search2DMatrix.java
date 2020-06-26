package com.hari.dsal.matrix;

public class Search2DMatrix {
	public static void main(String[] args) {
		int[][] spiralMatrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		boolean result = search(spiralMatrix, 3);
		boolean f = searchMatrix(spiralMatrix, 3);

		System.out.println(result);
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

}
