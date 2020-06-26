package com.hari.dsal.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
	
	Queue<Integer> queue = new LinkedList<Integer>();
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
         
        int m = board.length;
        int n = board[0].length;
         
        for (int i = 0; i < n; i++) {
            solveHelper(0, i, m, n, board);
            solveHelper(m - 1, i, m, n, board);
        }
         
        for (int i = 1; i < m - 1; i++) {
            solveHelper(i, 0, m, n, board);
            solveHelper(i, n - 1, m, n, board);
        }
         
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'D') {
                    board[i][j] = 'O';
                }
            }
        }
    }
     
    private void solveHelper(int row, int col, int m, int n, char[][] board) {
        fill(row, col, m, n, board);
         
        while (!queue.isEmpty()) {
            int cord = queue.poll();
            int x = cord / n;
            int y = cord % n;
             
            fill(x - 1, y, m, n, board);
            fill(x + 1, y, m, n, board);
            fill(x, y - 1, m, n, board);
            fill(x, y + 1, m, n, board);
        }
    }
     
    private void fill(int row, int col, int m, int n, char[][] board) {
        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != 'O') {
            return;
        } 
         
        board[row][col] = 'D';         
        queue.offer(row * n + col);
    }
    
    
    // Disjoint Method
    public void solveDisjoint(char[][] board) {
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
}
