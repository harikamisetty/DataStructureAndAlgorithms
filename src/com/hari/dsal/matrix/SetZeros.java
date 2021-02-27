package com.hari.dsal.matrix;

public class SetZeros {
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;

		int m = matrix.length;
		int n = matrix[0].length;

		boolean firstRowZero = false;
		boolean firstColZero = false;

		// check if the first row contains zero
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				firstRowZero = true;
			}
		}

		// check if the first col contains zero
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				firstColZero = true;
			}
		}

		// check the rest of the matrix elements
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		// set the corresponding row and col as zero
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		// check and set the first row and col as zeros, if necessary
		if (firstRowZero) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}

		if (firstColZero) {
			for (int j = 0; j < m; j++) {
				matrix[j][0] = 0;
			}
		}

	}
}
