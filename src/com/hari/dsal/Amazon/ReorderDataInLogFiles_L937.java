package com.hari.dsal.Amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class ReorderDataInLogFiles_L937 {

	public String[] reorderLogFiles(String[] logs) {

		PriorityQueue<String> letterLogs = new PriorityQueue<>(
				Comparator.<String, String>comparing(o -> o.split(" ", 2)[1]).thenComparing(o -> o.split(" ", 2)[0]));

		List<String> digitLogs = new LinkedList<String>();

		for (String log : logs) {
			// String secondWord = log.split(" ",2)[1];
			if (Character.isDigit(log.split(" ", 2)[1].charAt(0))) {
				digitLogs.add(log);
			} else {
				letterLogs.add(log);
			}
		}

		String[] out = new String[logs.length];
		int i = 0;
		while (!letterLogs.isEmpty()) {
			out[i] = letterLogs.poll();
			i++;
		}
		for (String log : digitLogs) {
			out[i] = log;
			i++;
		}
		return out;
	}
	
	// BEST WAY 
	public String[] reOrderLogs(String[] logs) {
		Comparator<String> myComp = new Comparator<String>() {
			@Override
			public int compare(String log1, String log2) {
				// split each log into two parts: <identifier, content>
				String[] split1 = log1.split(" ", 2);
				String[] split2 = log2.split(" ", 2);

				boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
				boolean isDigit2 = Character.isDigit(split2[1].charAt(0));

				// case 1). both logs are letter-logs
				if (!isDigit1 && !isDigit2) {
					// first compare the content
					int cmp = split1[1].compareTo(split2[1]);
					if (cmp != 0)
						return cmp;
					// logs of same content, compare the identifiers
					return split1[0].compareTo(split2[0]);
				}

				// case 2). one of logs is digit-log
				if (!isDigit1 && isDigit2)
					// the letter-log comes before digit-logs
					return -1;
				else if (isDigit1 && !isDigit2)
					return 1;
				else
					// case 3). both logs are digit-log
					return 0;
			}
		};

		Arrays.sort(logs, myComp);
		return logs;
	}

	public static void main(String[] args) {
		String s = "hello how are you?";
		String[] str = s.split("\\s+", 2);

		for (String st : str) {
			System.out.println(st);
		}
		String []logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		//String []logs = {"let1 art can","let2 art can","let3 art zero"};
		
		ReorderDataInLogFiles_L937 rd = new ReorderDataInLogFiles_L937();
		String []strs = rd.reOrderLogs(logs);
		
		for(String stre : strs) {
			System.out.println(stre);
		}
	}
}
