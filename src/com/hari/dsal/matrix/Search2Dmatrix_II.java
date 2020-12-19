package com.hari.dsal.matrix;

/*
 * Write an efficient algorithm that searches for a target value in an m x n integer matrix. T
 * he matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 */
public class Search2Dmatrix_II {

	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix == null || matrix.length == 0)
			return false;
		int m = matrix.length, n = matrix[0].length, cutrow = 0, curcol = n - 1;

		while (cutrow < m && curcol >= 0) {
			if (matrix[cutrow][curcol] == target)
				return true;

			if (matrix[cutrow][curcol] > target) {
				curcol--;
			} else {
				cutrow++;
			}
		}
		return false;
	}
}
