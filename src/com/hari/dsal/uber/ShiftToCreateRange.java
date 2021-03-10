package com.hari.dsal.uber;

public class ShiftToCreateRange {

	public boolean solve(int[] arr) {
		if (arr.length == 1)
			return true;
		int locationOne = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				locationOne = i;
			}
		}
		return increasing(arr, locationOne) || decreasing(arr, locationOne);
	}

	boolean decreasing(int[] arr, int loc) {
		int current = (loc + 1) % arr.length;
		loc = (loc + 2) % arr.length;
		while (arr[loc] != 1) {
			if (arr[loc] > arr[current])
				return false;
			current = loc;
			loc = (loc + 1) % arr.length;
		}
		return true;
	}

	boolean increasing(int[] arr, int loc) {
		int current = (loc + 1) % arr.length;
		loc = (loc + 2) % arr.length;
		while (arr[loc] != 1) {
			if (arr[loc] < arr[current])
				return false;
			current = loc;
			loc = (loc + 1) % arr.length;
		}
		return true;
	}

	public static void main(String[] args) {
		ShiftToCreateRange stcr = new ShiftToCreateRange();
		int[] arr = { 4, 1, 2, 3 };
		System.out.println(stcr.solve(arr));
	}

}
