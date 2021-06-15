package com.hari.dsal.matrix;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary_332 {
	public List<String> findItinerary(List<List<String>> tickets) {
		LinkedList<String> ans = new LinkedList<>();
		Map<String, PriorityQueue<String>> graph = new HashMap<>();

		for (final List<String> ticket : tickets) {
			graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
			graph.get(ticket.get(0)).offer(ticket.get(1));
		}

		dfs(graph, "JFK", ans);

		return ans;
	}

	private void dfs(Map<String, PriorityQueue<String>> graph, final String node, LinkedList<String> ans) {
		final PriorityQueue<String> arrivals = graph.get(node);
		while (arrivals != null && !arrivals.isEmpty())
			dfs(graph, arrivals.poll(), ans);
		ans.addFirst(node);
	}
	
	public static void main(String[] args) {
		
	}
}
