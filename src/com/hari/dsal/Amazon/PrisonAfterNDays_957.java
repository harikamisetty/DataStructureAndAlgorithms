package com.hari.dsal.Amazon;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class PrisonAfterNDays_957 {

	protected int cellsToBitmap(int[] cells) {
		int stateBitmap = 0x0;
		for (int cell : cells) {
			stateBitmap <<= 1;
			stateBitmap = (stateBitmap | cell);
		}
		return stateBitmap;
	}

	protected int[] nextDay(int[] cells) {
		int[] newCells = new int[cells.length];
		newCells[0] = 0;
		for (int i = 1; i < cells.length - 1; i++)
			newCells[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
		newCells[cells.length - 1] = 0;
		return newCells;
	}

	public int[] prisonAfterNDays(int[] cells, int N) {

		HashMap<Integer, Integer> seen = new HashMap<>();
		boolean isFastForwarded = false;

		// step 1). run the simulation with hashmap
		while (N > 0) {
			if (!isFastForwarded) {
				int stateBitmap = this.cellsToBitmap(cells);
				if (seen.containsKey(stateBitmap)) {
					// the length of the cycle is seen[state_key] - N
					N %= seen.get(stateBitmap) - N;
					isFastForwarded = true;
				} else
					seen.put(stateBitmap, N);
			}
			// check if there is still some steps remained,
			// with or without the fast-forwarding.
			if (N > 0) {
				N -= 1;
				cells = this.nextDay(cells);
			}
		}
		return cells;
	}

	// #2 Soluton
	public int[] prisonAfterNDays_2(int[] cells, int N) {
		LinkedList<int[]> list = new LinkedList<>();
		int[] currentDay = getNextDay(cells);
		N--;

		while (N > 0) {
			if (!list.isEmpty() && Arrays.equals(list.getFirst(), currentDay)) {
				N = N % list.size();
				if (N == 0)
					break;
			}
			list.add(currentDay);
			currentDay = getNextDay(currentDay);
			N--;
		}

		return currentDay;
	}

	private int[] getNextDay(int[] currentDay) {
		int[] nextDay = new int[currentDay.length];

		for (int i = 0; i < currentDay.length; i++) {
			if (i == 0 || i == currentDay.length - 1)
				nextDay[i] = 0;
			else if (currentDay[i + 1] == currentDay[i - 1])
				nextDay[i] = 1;
			else
				nextDay[i] = 0;
		}

		return nextDay;
	}

	public static void main(String[] args) {
		PrisonAfterNDays_957 pan = new PrisonAfterNDays_957();
		int[] cells = { 1, 0, 1, 0, 0, 0, 1, 0 };
		int[] res = pan.prisonAfterNDays_2(cells, 2);
		for (int val : res) {
			System.out.print(val + ",");
		}
	}
}
