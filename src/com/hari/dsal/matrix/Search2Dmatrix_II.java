package com.hari.dsal.matrix;

public class Search2Dmatrix_II {
	
	 public boolean searchMatrix(int[][] matrix, int target) {
		 
		 if(matrix ==null || matrix.length ==0)
			 return false;
		 int m = matrix.length,n=matrix[0].length, cutrow =0,curcol =n-1;
		 
		 while(cutrow<m && curcol>=0) {
			 if(matrix[cutrow][curcol] == target)
				 return true;
			 
			 if(matrix[cutrow][curcol] > target) {
				 curcol --;
			 }else {
				 cutrow ++;
			 }
		 }
		 return false;
	 }
}
