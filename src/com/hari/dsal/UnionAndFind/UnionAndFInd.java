package com.hari.dsal.UnionAndFind;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UnionAndFInd {

	UnionAndFInd() {
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	private void union(int u, int v) {
		int pu = find(u);
		int pv = find(v);
		if (pv == pu)
			return;
		parent[pu] = pv;
		return;
	}

	private int find(int u) {
		if (u != parent[u])
			parent[u] = find(parent[u]);
		return parent[u];
	}

	int len = 0;

	private int length(int u, boolean[] visited) {

		if (u != parent[u] && !visited[u]) {
			visited[u] = true;
			len++;
			parent[u] = length(parent[u], visited);
		} else {
			visited[u] = true;
		}
		return len;
	}

	private List<Integer> noOfNodes(int[] parent) {

		boolean[] visited = new boolean[parent.length];
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				queue.offer(i);
				res.add(length(i, visited));
			}
		}
		return res;
	}

	private List<Integer> process() {
		return noOfNodes(parent);
	}

	int n = 5;
	int parent[] = new int[n];

	public static void main(String[] args) {
		int[][] edgs = { { 0, 1 }, { 1, 2 }, { 3, 4 } };

		UnionAndFInd uaf = new UnionAndFInd();

		for (int[] edge : edgs) {
			uaf.union(edge[0], edge[1]);
		}
		for (int val : uaf.process()) {
			System.out.println(val);
		}
	}
}
