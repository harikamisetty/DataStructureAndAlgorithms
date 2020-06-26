package com.hari.dsal.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoadBalancer {
	private List<String> servers = new ArrayList<String>();
	Map<String, Integer> index = new HashMap<String, Integer>();

	public void addServer(String name) {
		servers.add(name);
		index.put(name, servers.size() - 1);
	}

	public void removeServer(String name) {
		Integer pos = index.get(name);
		if (pos == null) {
			throw new IllegalArgumentException();
		}
		servers.set(pos, servers.get(servers.size() - 1));
		servers.remove(servers.size() - 1);
	}

	public String getRandom() {
		int r = (int) (Math.random() * 1000);
		return servers.get(r % servers.size());
	}

	public static void main(String args[]) {
		LoadBalancer lb = new LoadBalancer();
		lb.addServer("1");
		lb.addServer("2");
		lb.addServer("3");
		lb.addServer("4");
		lb.addServer("5");

		System.out.print(lb.getRandom());
		System.out.print(lb.getRandom());
		System.out.print(lb.getRandom());
		System.out.print(lb.getRandom());

		lb.removeServer("3");
		lb.removeServer("1");
		System.out.print(lb.getRandom());
		System.out.print(lb.getRandom());
		System.out.print(lb.getRandom());
		System.out.print(lb.getRandom());

	}

}
