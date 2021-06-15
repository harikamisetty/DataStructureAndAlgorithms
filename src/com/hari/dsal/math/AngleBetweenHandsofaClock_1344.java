package com.hari.dsal.math;

public class AngleBetweenHandsofaClock_1344 {
	
	public double angleClock(int hour, int minutes) {
		
		final double hourHand = (hour % 12 + minutes / 60.0) * 30;
		final double minuteHand = minutes * 6;
		final double diff = Math.abs(hourHand - minuteHand);
		
		return Math.min(diff, 360 - diff);
	}
	
	public static void main(String[] args) {
		AngleBetweenHandsofaClock_1344 abc = new AngleBetweenHandsofaClock_1344();
		System.out.println(abc.angleClock(11, 15));
	}

}
