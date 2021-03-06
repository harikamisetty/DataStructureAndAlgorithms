package com.hari.dsal.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01_542 {
	public int[][] solve(int[][] matrix) {

		final int m = matrix.length;
		final int n = matrix[0].length;
		final int[] dirs = new int[] { 0, 1, 0, -1, 0 };

		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				if (matrix[i][j] == 0)
					q.offer(new int[] { i, j });
				else
					matrix[i][j] = Integer.MAX_VALUE;

		while (!q.isEmpty()) {
			final int i = q.peek()[0];
			final int j = q.poll()[1];
			for (int k = 0; k < 4; ++k) {
				final int x = i + dirs[k];
				final int y = j + dirs[k + 1];
				if (x < 0 || x == m || y < 0 || y == n)
					continue;
				if (matrix[x][y] <= matrix[i][j] + 1)
					continue;
				q.offer(new int[] { x, y });
				matrix[x][y] = matrix[i][j] + 1;
			}
		}

		return matrix;

	}
	
	public static void main(String[] args) {
		int [][] matrix = {
		                   {1, 1, 1},
		                   {1, 0, 1},
		                   {0, 0, 0}
	};
		
		Matrix01_542 ma = new Matrix01_542();
		ma.solve(matrix);
		
		final int m = matrix.length;
		final int n = matrix[0].length;
		
		for (int i = 0; i < m; ++i) {
			System.out.println("\n");
			for (int j = 0; j < n; ++j) {
				System.out.print(matrix[i][j]+" ");
			}
		}
	}
}
