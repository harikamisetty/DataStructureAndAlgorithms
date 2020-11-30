package com.hari.dsal.Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesandLadders_909 {
	public int snakesAndLadders(int[][] board) {

		int n = board.length; //6

		int lastDestination = n * n; // 6*6 = 36
		int[] oned = new int[lastDestination + 1];//36+1 =37

		boolean leftToRight = true; // last
		int k = 1;
		for (int i = n - 1; i >= 0; i--) { // row

			if (leftToRight) {
				for (int j = 0; j < n; j++) {
					oned[k++] = board[i][j];// 5,0, 5,1

				}
			} else {
				for (int j = n - 1; j >= 0; j--) {
					oned[k++] = board[i][j];
				}
			}
			leftToRight = !leftToRight;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		boolean[] visited = new boolean[lastDestination + 1];
		visited[1] = true;

		int result = 1;

		while (!queue.isEmpty()) {
			int size = queue.size();//1
			result++;//1,2,3,4

			for (int i = 0; i < size; i++) {
				int curr = queue.remove(); // 1,15,16,13
				for (int neighbour = curr + 1; neighbour <= curr + 6; neighbour++) {//2 to 7, 16- 22,14-20

					if (oned[neighbour] != -1) {
						neighbour = oned[neighbour];//15,13
					}
					if (visited[neighbour]) { // false,13,14
						continue;
					}
					if (neighbour == lastDestination) { // 14 == 36 = false
						return result;
					}
					visited[neighbour] = true;// Vistited[2,16,13,14] = true;
					queue.offer(neighbour);// queue.offer(14)
				}
			}
		}

		return -1;
	}
	
	// SOlution 2
	 public int snakesAndLadders_2(int[][] board) {
	        
		    int n = board.length;
		        Queue<Integer> queue = new LinkedList<>();
		        queue.offer(1);
		        boolean[] visited = new boolean[n * n + 1];
		        
		        for (int move = 0; !queue.isEmpty(); move++) {
		            for (int size = queue.size(); size > 0; size--) {
		                int num = queue.poll();
		                if (visited[num]) continue;
		                visited[num] = true;
		                if (num == n * n) return move;
		                for (int i = 1; i <= 6 && num + i <= n * n; i++) {
		                    int next = num + i;
		                    int value = getBoardValue(board, next);
		                    if (value > 0) next = value;
		                    if (!visited[next]) queue.offer(next);
		                }
		            }
		        }
		        return -1;
		    }

		    private int getBoardValue(int[][] board, int num) {
		        int n = board.length;
		        int r = (num - 1) / n;
		        int x = n - 1 - r;
		        int y = r % 2 == 0 ? num - 1 - r * n : n + r * n - num;
		        return board[x][y];
			
		    }

	public static void main(String[] args) {
		int board[][] = 
			  { { -1, -1, -1, -1, -1, -1 }, 
				{ -1, -1, -1, -1, -1, -1 }, 
				{ -1, -1, -1, -1, -1, -1 },
				{ -1, 35, -1, -1, 13, -1 }, 
				{ -1, -1, -1, -1, -1, -1 }, 
				{ -1, 15, -1, -1, -1, -1 } };
		SnakesandLadders_909 sl = new SnakesandLadders_909();
		System.out.println(sl.snakesAndLadders_2(board));

	}
}
