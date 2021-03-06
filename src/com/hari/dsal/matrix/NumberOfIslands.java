package com.hari.dsal.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	
	//DFS
	public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
         
        boolean[][] visited = new boolean[rows][cols];
        int result = 0;
         
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    numIslandsHelper1(grid, visited, i, j, rows, cols);
                }
            }
        }
         
        return result;
    }
     
    private static void numIslandsHelper1(char[][] grid, boolean[][] visited, int i, int j, int numRows, int numCols) {
        if (i < 0 || i >= numRows || j < 0 || j >= numCols || visited[i][j]) {
            return;
        }
         
        // If water
        if (grid[i][j] == '0') {
            return;
        }
         
        // Mark the visted[i][j] = true
        visited[i][j] = true;
         
        // Go up, down, left and right
        numIslandsHelper1(grid, visited, i - 1, j, numRows, numCols);
        numIslandsHelper1(grid, visited, i + 1, j, numRows, numCols);
        numIslandsHelper1(grid, visited, i, j - 1, numRows, numCols);
        numIslandsHelper1(grid, visited, i, j + 1, numRows, numCols);
    }
    
    
    //BFS
    private static Queue<Integer> queue = new LinkedList();
    
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
         
        int result = 0;
         
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    result++;
                    numIslandsHelper(grid, visited, i, j, rows, cols);
                }
            }
        }
        return result;
    }
     
    private static void numIslandsHelper(char[][] grid, boolean[][] visited, int i, int j, int numRows, int numCols) {
        fill(grid, visited, i, j, numRows, numCols);
         
        while (!queue.isEmpty()) {      
            int cord = queue.poll();
            int x = cord / numCols;
            int y = cord % numCols;
     
            fill(grid, visited, x - 1, y, numRows, numCols);
            fill(grid, visited, x + 1, y, numRows, numCols);
            fill(grid, visited, x, y - 1, numRows, numCols);
            fill(grid, visited, x, y + 1, numRows, numCols);
        }
    }
     
    private static void fill(char[][] grid, boolean[][] visited, int i, int j, int numRows, int numCols) {
        if (i < 0 || i >= numRows || j < 0 || j >= numCols || visited[i][j] || grid[i][j] == '0') {
            return;
        }
         
        visited[i][j] = true;
         
        queue.offer(i * numCols + j);
    }
    
 
    
    public static void main(String[] args) {

		/*char[][] grid = { { '1', '1', '1', '1', '0' }, 
						  { '1', '1', '0', '1', '0' }, 
						  { '1', '1', '0', '0', '0' },
						  { '0', '0', '0', '0', '0' } };*/
		
		char[][] grid = { { '1', '0' }, 
				  		  { '0', '0' } 
				  		 };

		System.out.println(numIslands(grid));
	}
}
