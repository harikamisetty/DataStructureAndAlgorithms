package com.hari.dsal.implementations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignFileSystem_LC588 {

	File root = null;

	public DesignFileSystem_LC588() {
		root = new File();
	}

	public List<String> ls(String path) {
		String[] dirs = path.split("/");
		File node = root;
		List<String> result = new ArrayList<>();
		String name = "";
		
		for (String dir : dirs) {
			if (dir.length() == 0)
				continue;
			if (!node.children.containsKey(dir)) {
				return result;
			}
			node = node.children.get(dir);
			name = dir;
		}

		if (node.isFile) {
			result.add(name);
		} else {
			for (String key : node.children.keySet()) {
				result.add(key);
			}
		}
		Collections.sort(result);

		return result;
	}

	public void mkdir(String path) {
		String[] dirs = path.split("/");
		File node = root;
		for (String dir : dirs) {
			if (dir.length() == 0)
				continue;
			if (!node.children.containsKey(dir)) {
				File file = new File();
				node.children.put(dir, file);
			}
			node = node.children.get(dir);
		}
	}

	public void addContentToFile(String filePath, String content) {
		String[] dirs = filePath.split("/");
		File node = root;
		for (String dir : dirs) {
			if (dir.length() == 0)
				continue;
			if (!node.children.containsKey(dir)) {
				File file = new File();
				node.children.put(dir, file);
			}
			node = node.children.get(dir);
		}
		node.isFile = true;
		node.content += content;
	}

	public String readContentFromFile(String filePath) {
		String[] dirs = filePath.split("/");
		File node = root;
		for (String dir : dirs) {
			if (dir.length() == 0)
				continue;
			if (!node.children.containsKey(dir)) {
				File file = new File();
				node.children.put(dir, file);
			}
			node = node.children.get(dir);
		}

		return node.content;
	}
}

class File {
	boolean isFile = false;
	Map<String, File> children = new HashMap<>();
	String content = "";
}
