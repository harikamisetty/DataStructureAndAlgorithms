package com.hari.dsal.strings;

import java.util.ArrayList;
import java.util.Stack;

public class SimplifyPath_71 {
	public String simplifyPath(String path) {
	    final String[] dirs = path.split("/");
	    Stack<String> stack = new Stack<>();

	    for (final String dir : dirs) {
	      if (dir.isEmpty() || dir.equals("."))
	        continue;
	      if (dir.equals("..")) {
	        if (!stack.isEmpty())
	          stack.pop();
	      } else {
	        stack.push(dir);
	      }
	    }

	    return "/" + String.join("/", new ArrayList(stack));
	  }
	
	public static void main(String[] args) {
		SimplifyPath_71 sp = new SimplifyPath_71();
		System.out.println(sp.simplifyPath("/home//foo/")); // /a/./b/../../c/
	}
}
