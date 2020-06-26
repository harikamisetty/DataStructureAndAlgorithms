package com.hari.dsal.trees;

public class Node_I {

	int data;
	Node_I left, right;

	public int height;

	public String strData;

	public Node_I(int data) {
		this.data = data;
		left = right = null;
		height = 1;
	}

	Node_I(String strData) {
		this.strData = strData;
	}

	public String getStrData() {
		return strData;
	}

}
