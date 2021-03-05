package com.hari.dsal.matrix;

import java.util.ArrayDeque;
import java.util.Queue;

import javafx.util.Pair;

public class Wildfire {
	public int solve(int[][] matrix) {

		Queue<Pair<Integer, Integer>> queue = new ArrayDeque<>();

		// Step 1). build the initial set of rotten oranges
		int tree = 0;
		int ROWS = matrix.length, COLS = matrix[0].length;

		for (int r = 0; r < ROWS; ++r)
			for (int c = 0; c < COLS; ++c)
				if (matrix[r][c] == 2)
					queue.offer(new Pair<>(r, c));
				else if (matrix[r][c] == 1)
					tree++;
		// To GET NUMBER OF DAYS - it will add at the end.
		queue.offer(new Pair<>(-1,-1));
		
		// Step 2). start the rotting process via BFS
		int minutesElapsed = -1;
		int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		
		
		while(!queue.isEmpty()) {
			Pair<Integer,Integer> p = queue.poll();
			int row =p.getKey();
			int col = p.getValue();
			
			if(row == -1) {
				minutesElapsed++;
				if(!queue.isEmpty())
					queue.offer(new Pair<>(-1,-1));
			} else {
				for(int[] d : directions) {
					int newrow = row+d[0];
					int newcol = col+d[1];
					
					if(newrow>= 0 && newrow < ROWS && newcol >= 0 && newcol<ROWS) {
						if(matrix[newrow][newcol] == 1) {
							matrix[newrow][newcol] = 2;
							tree--;
							queue.offer(new Pair<>(newrow,newcol));
						}
					}
				}
			}
		}	
		
		return tree ==0?minutesElapsed:-1;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 2, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
		/*int[][] matrix = {
		          {2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 0, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 1, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 2, 1, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 0, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2},
		          {2, 2, 1, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 2, 1, 2, 1, 2, 2, 2, 1, 1, 1, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
		          };*/
		Wildfire wf = new Wildfire();
		System.out.println(wf.solve(matrix));
	}
}
