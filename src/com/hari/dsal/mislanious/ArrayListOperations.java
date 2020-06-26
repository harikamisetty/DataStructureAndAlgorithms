package com.hari.dsal.mislanious;

import java.util.ArrayList;
import java.util.List;

public class ArrayListOperations {

	public static void main(String[] args) {

		List list = new ArrayList();

		list.add(0);
		list.add(0, 2);
		list.add(0, 4);

		for (Object res : list) {

			System.out.println(Integer.parseInt(res.toString()));

		}

	}
}
