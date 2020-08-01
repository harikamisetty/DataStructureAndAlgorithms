package com.hari.dsal.arrays;

public class Costco {

	private int findminprojects(int[] projects, int[] mintasks) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < mintasks.length; i++) {
			if (projects[i] < min) {
				min = i;
			}
		}
		return min;
	}

	private int[] findmintasks(int[] tasks) {
		int mintask = Integer.MAX_VALUE;
		int[] restask = new int[tasks.length];
		int res = 0;
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i] < mintask) {
				mintask = tasks[i];

			}
		}
		int j = 0;
		System.out.println(mintask);
		for (int k = 0; k < tasks.length; k++) {
			if (tasks[k] == mintask) {
				restask[j] = k;
				j++;
			}

		}
		return restask;
	}

	String smartAssigning(String[] names, boolean[] statuses, int[] projects, int[] tasks) {

		int len = names.length;

		for (int i = 0; i < len; i++) {
			if (statuses[i])
				break;
			int mintakarr[] = findmintasks(tasks);
			for (int l = 0; l < mintakarr.length; l++) {
				System.out.println(mintakarr[l]);
			}
			if (mintakarr.length == 1)
				return names[mintakarr[0]];

			if (mintakarr.length > 1) {
				int projectindex = findminprojects(projects, mintakarr);
				return names[projectindex];

			}
		}

		return null;
	}

}
