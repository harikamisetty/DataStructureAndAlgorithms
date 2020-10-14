package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

public class AnalyzeUserWebsiteVisitPattern_L1152 {

	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

		HashMap<String, TreeMap<Integer, String>> uns = new HashMap<>();
		HashMap<String, ArrayList<String>> unal = new HashMap<>();
		int n = username.length;

		for (int i = 0; i < n; i++) {
			String un = username[i];
			if (!uns.containsKey(un)) {
				uns.put(un, new TreeMap<Integer, String>());
			}
			uns.get(un).put(timestamp[i], website[i]);
		}

		for (String un : uns.keySet()) {
			unal.put(un, new ArrayList<>());
			for (int k : uns.get(un).keySet())
				unal.get(un).add(uns.get(un).get(k));
		}

		HashMap<String, Integer> sti = new HashMap<>();
		int max = 0;
		String lex = "";
		List<String> ans = new ArrayList<String>();

		for (String un : unal.keySet()) {
			int s = unal.get(un).size();
			HashSet<String> trips = new HashSet<>();
			for (int a = 0; a < s; a++) {
				for (int b = a + 1; b < s; b++) {
					for (int c = b + 1; c < s; c++) {
						String key = unal.get(un).get(a) + " " + unal.get(un).get(b) + " " + unal.get(un).get(c);
						trips.add(key);
					}
				}
			}
			for (String key : trips) {
				if (!sti.containsKey(key))
					sti.put(key, 0);
				sti.put(key, sti.get(key) + 1);
				if (sti.get(key) > max || (sti.get(key) == max && key.compareTo(lex) < 0)) {
					ans = new ArrayList<String>();
					ans.add(key.split(" ")[0]);
					ans.add(key.split(" ")[1]);
					ans.add(key.split(" ")[2]);
					max = sti.get(key);
					lex = key;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		String[] username = { "joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary" };
		int[] timestamp = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		String[] website = { "home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career" };

		AnalyzeUserWebsiteVisitPattern_L1152 a = new AnalyzeUserWebsiteVisitPattern_L1152();
		List<String>res = a.mostVisitedPattern(username, timestamp, website);
		System.out.println(res);
	}
}
