package com.hari.dsal.Amazon;

import java.util.HashSet;
import java.util.Set;

public class NumberofDistinctIslands_694 {
	public int numDistinctIslands(int[][] grid) {
		if (grid == null || grid.length < 1 || grid[0].length < 1)
			return 0;
		int m = grid.length, n = grid[0].length;
		
		Set<String> res = new HashSet<>();
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
			
				if (grid[i][j] == 1) {
					Set<String> set = new HashSet<>();
					dfs(grid, i, j, i, j, set);
					res.add(set.toString());
				}
			}
		}
		return res.size();
	}

	public void dfs(int[][] grid, int i, int j, int baseX, int baseY, Set<String> set) {
		
		// Boundary Conditions
		int m = grid.length, n = grid[0].length;
		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0)
			return;
		
		set.add((i - baseX) + "_" + (j - baseY)); // Formula
		grid[i][j] = 0;
		dfs(grid, i + 1, j, baseX, baseY, set);
		dfs(grid, i - 1, j, baseX, baseY, set);
		dfs(grid, i, j - 1, baseX, baseY, set);
		dfs(grid, i, j + 1, baseX, baseY, set);
	}
	
	public static void main(String[] args) {
		NumberofDistinctIslands_694 nodi = new NumberofDistinctIslands_694();
		int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
		System.out.println(nodi.numDistinctIslands(grid));
	}
}
