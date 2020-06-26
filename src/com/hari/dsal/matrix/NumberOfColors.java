package com.hari.dsal.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfColors {

	private int numberofcolors(int[][] matrix) {

		int l = matrix.length;
		int h = matrix[0].length;
		boolean[][] visited = new boolean[l][h];

		Queue<String> queue = new LinkedList<>();
		Queue<String> pendingqueue = new LinkedList<>();
		pendingqueue.add(0 + "," + 0);

		int count = 0;

		while (!pendingqueue.isEmpty()) {
			String val = pendingqueue.remove();

			int valrow = Integer.parseInt(val.split(",")[0]);
			int valcol = Integer.parseInt(val.split(",")[1]);
			queue.add(valrow + "," + valcol);
			count++;
			int target = matrix[valrow][valcol];

			while (!queue.isEmpty()) {
				String x = queue.remove();
				int row = Integer.parseInt(x.split(",")[0]);
				int col = Integer.parseInt(x.split(",")[1]);

				if (row < 0 || col < 0 || row >= h || col >= l || visited[row][col])
					continue;

				visited[row][col] = true;
				validate(matrix, row, col, l, h, queue, pendingqueue, visited, target);
			}
		}
		return count;
	}

	private void validate(int[][] matrix, int row, int col, int l, int h, Queue<String> queue,
			Queue<String> pendingqueue, boolean[][] visited, int target) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		for (int i = 0; i < dx.length; i++) {
			int posX = row + dx[i];
			int posY = col + dy[i];

			if (posX < 0 || posX >= l || posY < 0 || posY >= h || visited[posX][posY])
				continue;

			if (matrix[posX][posY] == target) {
				queue.add(posX + "," + posY);
			} else if (!isExists(pendingqueue, posX, posY)) {
				pendingqueue.add(posX + "," + posY);
			}
		}
	}

	private boolean isExists(Queue<String> pendingqueue, int posX, int posY) {
		String strArray[] = pendingqueue.toArray(new String[pendingqueue.size()]);
		if (strArray == null || strArray.length == 0)
			return false;

		for (int i = 0; i < strArray.length; i++) {
			String x = strArray[i];
			int row = Integer.parseInt(x.split(",")[0]);
			int col = Integer.parseInt(x.split(",")[1]);
			if (posX == row && posY == col) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		NumberOfColors noc = new NumberOfColors();
		int[][] matrix = { { 2, 3, 2 }, { 2, 2, 2 }, { 6, 2, 3 } };
		System.out.println(noc.numberofcolors(matrix));
	}
}
