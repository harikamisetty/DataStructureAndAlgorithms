package com.hari.dsal.strings.more;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments_722 {

	public List<String> removeComments(String[] source) {

		List<String> ans = new ArrayList<>();
		boolean commenting = false;
		StringBuilder modified = new StringBuilder();

		for (final String line : source) {
			
			for (int i = 0; i < line.length();) {

				if (i + 1 == line.length()) {
					if (!commenting)
						modified.append(line.charAt(i));
					++i;
					break;
				}

				String twoChars = line.substring(i, i + 2);

				if (twoChars.equals("/*") && !commenting) {
					commenting = true;
					i += 2;
				} else if (twoChars.equals("*/") && commenting) {
					commenting = false;
					i += 2;
				} else if (twoChars.equals("//")) {
					if (!commenting)
						break;
					else
						i += 2;
				} else {
					if (!commenting)
						modified.append(line.charAt(i));
					++i;
				}
			}

			if (modified.length() > 0 && !commenting) {
				ans.add(modified.toString());
				modified.setLength(0);
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		RemoveComments_722 rc = new RemoveComments_722();
		String[] input = { "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;",
				"/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}" };
		for(String strval : rc.removeComments(input)) {
			System.out.print(strval + " ");
		}
	}
}
