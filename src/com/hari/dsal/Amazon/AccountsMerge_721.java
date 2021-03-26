package com.hari.dsal.Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class AccountsMerge_721 {

	public List<List<String>> accountsMerge(List<List<String>> accounts) {

		List<List<String>> ans = new ArrayList<>();
		Map<String, String> emailToName = new HashMap<>();
		Map<String, TreeSet<String>> parentEmailToEmails = new HashMap<>();
		UF uf = new UF(accounts);

		// get {email: name} mapping
		for (final List<String> account : accounts)
			for (int i = 1; i < account.size(); ++i)
				emailToName.putIfAbsent(account.get(i), account.get(0));

		// union emails
		for (final List<String> account : accounts)
			for (int i = 2; i < account.size(); ++i)
				uf.union(account.get(i), account.get(i - 1));

		for (final List<String> account : accounts)
			for (int i = 1; i < account.size(); ++i) {
				final String parent = uf.find(account.get(i));
				parentEmailToEmails.putIfAbsent(parent, new TreeSet<>());
				parentEmailToEmails.get(parent).add(account.get(i));
			}

		for (final String parentEmail : parentEmailToEmails.keySet()) {
			List<String> emails = new ArrayList<>(parentEmailToEmails.get(parentEmail));
			final String name = emailToName.get(parentEmail);
			emails.add(0, name);
			ans.add(emails);
		}
		return ans;
	}

	// #2 SOLUTION
	public List<List<String>> accountsMerge_2(List<List<String>> accounts) {
		Map<String, String> emailToName = new HashMap<>();
		Map<String, ArrayList<String>> graph = new HashMap<>();

		for (List<String> account : accounts) {
			String name = "";

			for (String email : account) {
				if (name == "") {
					name = email;
					continue;
				}

				graph.computeIfAbsent(email, x -> new ArrayList<String>()).add(account.get(1));
				graph.computeIfAbsent(account.get(1), x -> new ArrayList<String>()).add(email);
				emailToName.put(email, name);
			}
		}

		Set<String> seen = new HashSet<>();
		List<List<String>> ans = new ArrayList<>();

		for (String email : graph.keySet()) {

			if (!seen.contains(email)) {

				seen.add(email);
				Stack<String> stack = new Stack<>();
				stack.push(email);

				List<String> component = new ArrayList<>();

				while (!stack.empty()) {
					String node = stack.pop();
					component.add(node);

					for (String nei : graph.get(node)) {

						if (!seen.contains(nei)) {
							seen.add(nei);
							stack.push(nei);
						}
					}
				}

				Collections.sort(component);
				component.add(0, emailToName.get(email));
				ans.add(component);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		List<List<String>> accounts = 
				Arrays.asList(
				Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
				Arrays.asList("John", "johnnybravo@mail.com"),
				Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
				Arrays.asList("Mary", "mary@mail.com"));

		AccountsMerge_721 am = new AccountsMerge_721();
		List<List<String>> res = am.accountsMerge(accounts);

		for (final List<String> resitem : res) {
			System.out.println("\n");
			for (int i = 1; i < resitem.size(); ++i) {
				System.out.print(resitem.get(i) + ",");
			}
		}
	}

}

class UF {
	private Map<String, String> parent = new HashMap<>();

	public UF(List<List<String>> accounts) {
		for (List<String> account : accounts)
			for (int i = 1; i < account.size(); ++i) {
				final String email = account.get(i);
				parent.putIfAbsent(email, email);
			}
	}

	public void union(final String u, final String v) {
		parent.put(find(u), find(v));
	}

	public String find(final String u) {
		if (u != parent.get(u))
			parent.put(u, find(parent.get(u)));
		return parent.get(u);
	}
}
