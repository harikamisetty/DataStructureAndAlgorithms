package com.hari.dsal.matrix;

public class DisjointSet {

	public void solve(char[][] board) {
	    if(board == null || board.length==0) 
	        return;
	 
	    int m = board.length;
	    int n = board[0].length;
	 
	    //merge O's on left & right boarder
	    for(int i=0;i<m;i++){
	        if(board[i][0] == 'O'){
	            merge(board, i, 0);
	        }
	 
	        if(board[i][n-1] == 'O'){
	            merge(board, i, n-1);
	        }
	    }
	 
	    //merge O's on top & bottom boarder
	    for(int j=0; j<n; j++){
	         if(board[0][j] == 'O'){
	            merge(board, 0, j);
	        }
	 
	        if(board[m-1][j] == 'O'){
	            merge(board, m-1, j);
	        }
	    }
	 
	    //process the board
	    for(int i=0;i<m;i++){
	        for(int j=0; j<n; j++){
	            if(board[i][j] == 'O'){
	                board[i][j] = 'X';
	            }else if(board[i][j] == '#'){
	                board[i][j] = 'O';
	            }
	        }
	    }
	    for(int p=0;p<board.length;p++) {
			System.out.println("\n");
			for(int q=0;q<board[0].length;q++) {
				System.out.print(board[p][q]);
			}
		}
	}
	
	public void merge(char[][] board, int i, int j){
	    board[i][j] = '#';
	 
	    int[] dx = {-1, 0, 1, 0};
	    int[] dy = {0, 1, 0, -1};
	 
	    for(int k=0; k<4; k++){
	        int x = i+dx[k];
	        int y = j+dy[k];
	 
	        if(x>=0 && x<board.length
	          && y>=0 && y<board[0].length
	          && board[x][y]=='O'){
	            merge(board, x, y);
	        }
	    }   
	}
	
	public static void main(String[] args) {

		char[][] grid = { 
		  { '1', '1', '1', '1', '0' }, 
		  { '1', '1', '0', '1', '0' }, 
		  { '1', '1', '0', '0', '0' },
		  { '0', '0', '0', '0', '0' } };
		
		DisjointSet gs = new DisjointSet();
		gs.solve(grid);
		
		
	}
}
