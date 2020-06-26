package com.hari.dsal.matrix;

import java.util.Stack;

public class DFS {
	// DFS	
	private void printDFSData(int[][] grid) {
		int h = grid.length;
        if (h == 0)
            return;
        int l = grid[0].length;
        boolean[][] visited = new boolean[h][l];
        Stack<String> stack = new Stack<>();

        stack.push(0 + "," + 0);

        System.out.println("Depth-First Traversal: ");
        while (stack.empty() == false) {

            String x = stack.pop();
            int row = Integer.parseInt(x.split(",")[0]);
            int col = Integer.parseInt(x.split(",")[1]);

            if(row<0 || col<0 || row>=h || col>=l || visited[row][col])
                continue;

            visited[row][col]=true;
            System.out.print(grid[row][col] + " ");
            stack.push(row + "," + (col-1)); //go left
            stack.push(row + "," + (col+1)); //go right
            stack.push((row-1) + "," + col); //go up
            stack.push((row+1) + "," + col); //go down
        }
	}

	public static void main(String[] args) {
		
		int gridInt [][] = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
				};
		DFS dfs = new DFS();
		dfs.printDFSData(gridInt);
	}
}
