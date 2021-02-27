package com.hari.dsal.matrix;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {
	  public boolean solve(int[][] matrix) {

		  Set<String> seen = new HashSet<>();

		    for (int i = 0; i < 9; ++i)
		      for (int j = 0; j < 9; ++j) {
		        final int c = matrix[i][j];
		        if (!seen.add(c + "@row" + i) ||
		            !seen.add(c + "@col" + j) ||
		            !seen.add(c + "@box" + i / 3 + j / 3))
		          return false;
		      }

		    return true;
  }

 
  public static void main(String[] args) {
	int[][] matrix =  {
	                           {4, 2, 6, 5, 7, 1, 3, 9, 8},
	                           {8, 5, 7, 2, 9, 3, 1, 4, 6},
	                           {1, 3, 9, 4, 6, 8, 2, 7, 5},
	                           {9, 7, 1, 3, 8, 5, 6, 2, 4},
	                           {5, 4, 3, 7, 2, 6, 8, 1, 9},
	                           {6, 8, 2, 1, 4, 9, 7, 5, 3},
	                           {7, 9, 4, 6, 3, 2, 5, 8, 1},
	                           {2, 6, 5, 8, 1, 4, 9, 3, 7},
	                           {3, 1, 8, 9, 5, 7, 4, 6, 2}
	                           };
	SudokuValidator sv = new SudokuValidator();
	System.out.println(sv.solve(matrix));
}
}
