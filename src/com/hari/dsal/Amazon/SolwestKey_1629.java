package com.hari.dsal.Amazon;

public class SolwestKey_1629 {
	public char slowestKey(int[] releaseTimes, String keysPressed) {
		int max = releaseTimes[0];
		char key = keysPressed.charAt(0);

		for (int i = 1; i < releaseTimes.length; i++) {
			int current = releaseTimes[i] - releaseTimes[i - 1];
			if (max < current) {
				max = current;
				key = keysPressed.charAt(i);
			} else if (max == current) {
				//lexicographically 
				key = key > keysPressed.charAt(i) ? key : keysPressed.charAt(i);
			}
		}
		return key;
	}
	
	public static void main(String[] args) {
		SolwestKey_1629 sk = new SolwestKey_1629();
		int[] releasetimes = {9,29,49,50};
		String keypressed = "cbcd";
		System.out.println(sk.slowestKey(releasetimes, keypressed ));
	}
}
