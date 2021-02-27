package com.hari.dsal.matrix;

public class WordSearch {
	
	public boolean exist(String[][] board, String word) {
        if (board == null || word == null) {
            return true;
        }
         
        if (board.length == 0 && word.length() == 0) {
            return true;
        }
         
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
         
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (existHelper(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
     
    private boolean existHelper(String[][] board, String word, int start, int row, int col, boolean[][] visited) {
        if (start == word.length()) {
            return true;
        }
         
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return false;
        }
         
        if (visited[row][col]) {
            return false;
        }
         
        if (board[row][col].charAt(0) != word.charAt(start)) {
            return false;
        }
         
        visited[row][col] = true;
        boolean result = existHelper(board, word, start + 1, row - 1, col, visited) ||
                         existHelper(board, word, start + 1, row + 1, col, visited) ||
                         existHelper(board, word, start + 1, row, col - 1, visited) ||
                         existHelper(board, word, start + 1, row, col + 1, visited);
        visited[row][col] = false;
         
        return result;
    }
    
    public static void main(String[] args) {
    	String [][]board = {
    			{"H", "E", "L", "L", "O"},
    	         {"A", "B", "C", "D", "E"}
    	};
   	
    	    WordSearch ws = new WordSearch();
    	    System.out.println(ws.exist(board, "EDL"));
	}

}
