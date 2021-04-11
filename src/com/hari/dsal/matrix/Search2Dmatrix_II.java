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

	public static void main(String[] args) {
		Search2Dmatrix_II sd = new Search2Dmatrix_II();
		int[][] matrix = { 
				{ 1, 4, 7, 11, 15 }, 
				{ 2, 5, 8, 12, 19 }, 
				{ 3, 6, 9, 16, 22 }, 
				{ 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 }
				};

		System.out.println(sd.searchMatrix(matrix, 9));
	}
}
