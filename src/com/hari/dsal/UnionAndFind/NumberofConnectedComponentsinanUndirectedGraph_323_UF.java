package com.hari.dsal.UnionAndFind;

public class NumberofConnectedComponentsinanUndirectedGraph_323_UF {
	private int size;
	private int[] parent;
	
	
	// Constructor
	public NumberofConnectedComponentsinanUndirectedGraph_323_UF(int n) {
		size = n;
		parent = new int[n];

		for (int i = 0; i < n; ++i)
			parent[i] = i;
	}
	
	// Union
	public void union(int u, int v) {
		final int pu = find(u);
		final int pv = find(v);
		if (pu == pv)
			return;

		parent[pu] = pv;
		--size;
	}

	public int getSize() {
		return size;
	}

	//Find
	private int find(int u) {
		if (u != parent[u])
			parent[u] = find(parent[u]);
		return parent[u];
	}

	public static void main(String[] args) {
		int n =5;
		int [][] edgs = {{0,1},{1,2},{3,4}};
		NumberofConnectedComponentsinanUndirectedGraph_323_UF uf = new NumberofConnectedComponentsinanUndirectedGraph_323_UF(
				n);
		uf.main(n, edgs);
	}

	public int main(int n, int[][] edges) {
		for (int[] edge : edges)
			union(edge[0], edge[1]);

		return getSize();
	}
}
