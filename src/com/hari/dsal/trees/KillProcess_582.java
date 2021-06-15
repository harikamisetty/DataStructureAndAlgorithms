package com.hari.dsal.trees;

import java.util.ArrayList;
import java.util.List;

public class KillProcess_582 {
	
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
	
		int n = pid.size();
		int maxval = -1;
		for (int i = 0; i < n; ++i)
			maxval = Math.max(maxval, pid.get(i));

		int[] parent = new int[maxval + 1];
		for (int i = 0; i < n; ++i)
			parent[pid.get(i)] = pid.get(i);

		for (int i = 0; i < n; ++i)
			if (pid.get(i) != kill && ppid.get(i) != 0)
				union(pid.get(i), ppid.get(i), parent);

		List<Integer> res = new ArrayList();
		for (int i = 0; i < n; ++i)
			if (find(pid.get(i), parent) == kill)
				res.add(pid.get(i));

		return res;
	}

	public void union(int i, int j, int[] parent) {
		int pi = parent[i];
		int pj = parent[j];
		if (pi != pj)
			parent[pi] = pj;
	}

	public int find(int i, int[] parent) {
		if (i != parent[i]) {
			parent[i] = find(parent[i], parent);
			return parent[i];
		} else
			return i;
	}
}
