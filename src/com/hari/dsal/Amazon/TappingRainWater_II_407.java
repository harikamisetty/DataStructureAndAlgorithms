package com.hari.dsal.Amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TappingRainWater_II_407 {
	final static int[][] move = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public int trapRainWater(int[][] heightMap) {
		if (heightMap.length == 0)
			return 0;
		int row = heightMap.length;
		int col = heightMap[0].length;

		PriorityQueue<Block> heap = new PriorityQueue<Block>(new Comparator<Block>() {
			public int compare(Block a, Block b) {
				return a.hold - b.hold;
			}
		});

		for (int i = 0; i < row; i++) {
			heap.add(new Block(i, -1, -1));
			heap.add(new Block(i, col, -1));
		}
		for (int j = 0; j < col; j++) {
			heap.add(new Block(-1, j, -1));
			heap.add(new Block(row, j, -1));
		}

		boolean[][] visited = new boolean[row][col];
		int ans = 0;

		while (!heap.isEmpty()) {
			Block cur = heap.poll();
			for (int[] mv : move) {
				int nx = cur.x + mv[0];
				int ny = cur.y + mv[1];
				if (nx < 0 || nx >= row)
					continue;
				if (ny < 0 || ny >= col)
					continue;
				if (visited[nx][ny])
					continue;
				visited[nx][ny] = true;

				if (cur.hold > heightMap[nx][ny]) {
					ans += cur.hold - heightMap[nx][ny];
					heap.add(new Block(nx, ny, cur.hold));
				} else
					heap.add(new Block(nx, ny, heightMap[nx][ny]));
			}
		}
		return ans;
	}
	
	// SOLUTION 2
	public int trapRainWater2(int[][] heightMap) {

		if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
			return 0;
		}

		PriorityQueue<Cell> queue = new PriorityQueue<Cell>(1, new Comparator<Cell>() {
			public int compare(Cell a, Cell b) {
				return a.height - a.height;
			}
		});

		int m = heightMap.length;
		int n = heightMap[0].length;
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			visited[i][0] = true;
			visited[i][n - 1] = true;
			queue.offer(new Cell(i, 0, heightMap[i][0]));
			queue.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
		}

		for (int i = 0; i < n; i++) {
			visited[0][i] = true;
			visited[m - 1][i] = true;
			queue.offer(new Cell(0, i, heightMap[0][i]));
			queue.offer(new Cell(0, i, heightMap[m - 1][i]));
		}

		int[][] dirs = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

		int res = 0;
		while (!queue.isEmpty()) {

			Cell cell = queue.poll();
			for (int[] dir : dirs) {
				int row = cell.row + dir[0];
				int col = cell.col + dir[1];

				if (row >= 0 && row < m && col >= 0 && col <= n && !visited[row][col]) {
					visited[row][col] = true;
					res = res + Math.max(0, cell.height - heightMap[row][col]);
					queue.offer(new Cell(row, col, Math.max(heightMap[row][col], cell.height)));
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TappingRainWater_II_407 tr = new TappingRainWater_II_407();
		int[][] grid = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
		System.out.println(tr.trapRainWater(grid));
	}
}

class Block {
	int x, y, hold;

	public Block(int x, int y, int hold) {
		this.x = x;
		this.y = y;
		this.hold = hold;
	}
}

class Cell {
	int row, col, height;

	public Cell(int row, int col, int height) {
		this.row = row;
		this.col = col;
		this.height = height;
	}
}
