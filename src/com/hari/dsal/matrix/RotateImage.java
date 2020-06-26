package com.hari.dsal.matrix;

public class RotateImage {
	
	public static  void rotate(int[][] matrix) {
        // check if matrix is null or empty or length equals to 1
        if (matrix == null || matrix.length < 2) return;
         
        int n = matrix.length; //3
         
        for (int layer = 0; layer < n/2; layer++) {
            int first = layer;//0
            int last = n - layer - 1; //2
             
            for (int i = first; i < last; i++) {
                int offset = i - first; //0
                int top = matrix[first][i];//0,0
                 
                // left -> top
                matrix[first][i] = matrix[last - offset][first];
                 
                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];
                 
                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];
                 
                // top - > right;
                matrix[i][last] = top;
            }
        }
    }
	
	public static void main(String[] args) {
		
		int [][] grid = {{1,2,3},
						 {4,5,6},
						 {7,8,9}};
		rotate(grid);
		
		int m = grid.length;
		int n = grid[0].length;
		for(int i=0; i < m; i++) {
			System.out.println("\n");
			for(int j=0; j < n; j++) {
				System.out.print(grid[i][j]);
			}
		}
	}
}
