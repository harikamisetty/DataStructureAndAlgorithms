package com.hari.dsal.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix_BFS {
	int[] dx = { 0, 1, 0, -1 };
	int[] dy = { 1, 0, -1, 0 };

	private void BFS_matrix(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] b = new boolean[m][n];

		Queue<String> stack = new LinkedList<>();
		String item = 0 + "," + 0;
		stack.add(item);

		while (stack.size() > 0) {
			String element = stack.poll();
			int x = Integer.parseInt(element.split(",")[0]);
			int y = Integer.parseInt(element.split(",")[1]);

			if (x < 0 || y < 0 || x >= m || y >= n || b[x][y])
				continue;

			System.out.print(matrix[x][y] + " ");
			b[x][y] = true;
			// insertIntoStack(stack,x,y,m,n,b);
			for (int i = 0; i < dx.length; i++) {
				int k = x + dx[i];
				int l = y + dy[i];
				stack.add(k + "," + l);
			}
		}
	}

	private void BFS_recursive(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[][] visited = new boolean[m][n];

		Queue<Integer> queue = new LinkedList<>();
		bfs_recur_helper(matrix, 0, 0, m, n, visited, queue);
	}

	private void bfs_recur_helper(int[][] matrix, int i, int j, int m, int n, boolean[][] visited,
			Queue<Integer> queue) {
		fill(matrix, visited, i, j, m, n, queue);
		while (!queue.isEmpty()) {
			int cord = queue.poll();
			int x = cord / n;
			int y = cord % n;

			fill(matrix, visited, x - 1, y, m, n, queue);
			fill(matrix, visited, x + 1, y, m, n, queue);
			fill(matrix, visited, x, y - 1, m, n, queue);
			fill(matrix, visited, x, y + 1, m, n, queue);
		}
	}

	private void fill(int[][] grid, boolean[][] visited, int i, int j, int numRows, int numCols, Queue<Integer> queue) {
		if (i < 0 || i >= numRows || j < 0 || j >= numCols) {
			return;
		}

		if (visited[i][j] || grid[i][j] == '0') {
			return;
		}

		visited[i][j] = true;
		System.out.print(grid[i][j] + " ");
		queue.offer(i * numCols + j);
	}

	public static void main(String[] args) {
		int[][] spiralMatrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		Matrix_BFS md = new Matrix_BFS();
		md.BFS_matrix(spiralMatrix);
		System.out.println("\n");
		md.BFS_recursive(spiralMatrix);
	}

}
