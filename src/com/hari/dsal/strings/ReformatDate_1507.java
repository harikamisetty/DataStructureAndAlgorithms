package com.hari.dsal.strings;

public class ReformatDate_1507 {
	public String reformatDate(String date) {

		StringBuilder sb = new StringBuilder();
		String[] arr = date.split(" ");
		sb.append(arr[arr.length - 1]);
		sb.append("-");

		String[] month = new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov",
				"Dec" };

		String mon = arr[1];
		for (int i = 0; i < month.length; i++) {
			if (mon.equals(month[i]) && i + 1 > 9) {
				sb.append(i + 1);
				break;
			} else if (mon.equals(month[i]) && i + 1 <= 9) {
				sb.append('0');
				sb.append(i + 1);
				break;
			} else
				continue;
		}

		sb.append("-");
		String datee = "";

		if (arr[0].length() == 4)
			datee = arr[0].substring(0, 2);
		else {
			sb.append(0);
			datee = arr[0].substring(0, 1);
		}

		sb.append(datee);

		return sb.toString();
	}
	
	public static void main(String[] args) {
		String date = "20th Oct 2052";
		ReformatDate_1507 rfd = new ReformatDate_1507();
		System.out.println();
	}
}
