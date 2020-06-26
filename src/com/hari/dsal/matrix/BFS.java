package com.hari.dsal.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	// BFS
	private void printdata(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return;
		}
		int rows = grid.length;
		int cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];
        Queue<String> queue = new LinkedList<>();

        queue.add(0 + "," + 0);
        
        while(!queue.isEmpty()) {
            String x = queue.remove();

        	 int row = Integer.parseInt(x.split(",")[0]);
             int col = Integer.parseInt(x.split(",")[1]);

             if (row < 0 || col < 0 || row >= rows || col >= cols || visited[row][col])
                 continue;

             visited[row][col] = true;
             System.out.print(grid[row][col] + " ");
             queue.add(row + "," + (col - 1)); //go left
             queue.add(row + "," + (col + 1)); //go right
             queue.add((row - 1) + "," + col); //go up
             queue.add((row + 1) + "," + col); //go down       	
        }
	}
	
	public static void main(String[] args) {

		int gridInt [][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
				};
		BFS bfs = new BFS();
		bfs.printdata(gridInt);
	}
}
