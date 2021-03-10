package com.hari.dsal.Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles_547 {
	// BFS
	public int findCircleNum(int[][] M) {
		if (M == null || M.length == 0) {
			return 0;
		}

		int N = M.length;

		boolean[] visited = new boolean[N];
		int numCC = 0;

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				numCC += 1;
				bfs(i, M, visited);
			}
		}

		return numCC;
	}

	private void bfs(int row, int[][] M, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		int N = M.length;

		queue.offer(row);
		visited[row] = true;

		while (!queue.isEmpty()) {
			int currRow = queue.poll();
			for (int neighbor = 0; neighbor < N; neighbor++) {
				if (M[currRow][neighbor] == 1 && !visited[neighbor]) {
					queue.offer(neighbor);
					visited[neighbor] = true;
				}
			}
		}
	}

	// Union Find Solution
	private int numCC;

	public int findCircleNum_1(int[][] M) {
		if (M == null || M.length == 0) {
			return 0;
		}

		int N = M.length;
		int[] parents = new int[N];
		this.numCC = N;

		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j && M[i][j] == 1) {
					union(parents, i, j);
				}
			}
		}

		return numCC;
	}

	private void union(int[] parents, int a, int b) {
		int rootA = find(parents, a);
		int rootB = find(parents, b);

		if (rootA != rootB) {
			parents[rootA] = rootB;
			numCC -= 1;
		}
	}

	private int find(int[] parents, int a) {
		int root = a;
		while (root != parents[root]) {
			root = parents[root];
		}

		// path compression
		while (a != root) {
			int next = parents[a];
			parents[a] = root;
			a = next;
		}

		return root;
	}

	public static void main(String[] args) {
		FriendCircles_547 fc = new FriendCircles_547();
		int[][] grid = { 
				{ 1, 1, 0 }, 
				{ 1, 1, 0 }, 
				{ 0, 0, 1 } 
				};
		System.out.println(fc.findCircleNum(grid));
		System.out.println(fc.findCircleNum_1(grid));
	}
}
