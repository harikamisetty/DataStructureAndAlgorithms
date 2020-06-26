package com.hari.dsal.mislanious;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FaceBook_Prasanth {

	public static void main(String[] args) {
		String[] stringList = { "hari@gmail.com", "nilu@gmail.com", "koman@gmail.com", "kanna@gmail.com",
				"ravi@gmail.com" };

		List<String> userNames = getNamesFromMails(stringList);

		for (String resStr : userNames) {
			System.out.println(resStr);
		}
	}

	private static List<String> getNamesFromMails(String[] stringList) {

		if (stringList == null || stringList.length == 0)
			return null;

		List<String> resList = new ArrayList<>();

		try (FileWriter writer = new FileWriter("app.log");
			BufferedWriter bw = new BufferedWriter(writer)) {
			for (String email : stringList) {
				bw.write(email.substring(0, email.indexOf('@')));
				bw.write("\n");
				resList.add(email.substring(0, email.indexOf('@')));
			}
		} catch (IOException e) {
			System.err.format("IOException: %s%n", e);
		}

		return resList;
	}
}
