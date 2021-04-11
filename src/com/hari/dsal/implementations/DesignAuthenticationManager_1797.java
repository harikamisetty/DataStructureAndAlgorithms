package com.hari.dsal.implementations;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class DesignAuthenticationManager_1797 {
	private int timeToLive;
	private Map<String, Integer> map = new LinkedHashMap<String, Integer>();

	public DesignAuthenticationManager_1797(int timeToLive) {
		this.timeToLive = timeToLive;
	}

	public void generate(String tokenId, int currentTime) {
		clean(currentTime);
		map.put(tokenId, currentTime + timeToLive);
	}

	public void renew(String tokenId, int currentTime) {
		clean(currentTime);

		if (map.get(tokenId) != null) {
			map.remove(tokenId);
			map.put(tokenId, currentTime + timeToLive);
		}
	}

	public int countUnexpiredTokens(int currentTime) {
		clean(currentTime);

		return map.size();
	}

	private void clean(int currentTime) {
		for (Iterator<String> it = map.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			if (map.get(key) <= currentTime) {
				it.remove();
			} else {
				break;
			}
		}
	}
}
