package com.hari.dsal.arrays;

import java.awt.Point;
import java.util.HashMap;

public class MaxPointsOnaLine {
	public static int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;

		HashMap<Double, Integer> result = new HashMap<Double, Integer>();
		int max = 0;

		for (int i = 0; i < points.length; i++) {
			int duplicate = 1;//
			int vertical = 0;
			for (int j = i + 1; j < points.length; j++) {
				// handle duplicates and vertical
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						duplicate++;
					} else {
						vertical++;
					}
				} else {
					double slope = points[j].y == points[i].y ? 0.0
							: (1.0 * (points[j].y - points[i].y)) / (points[j].x - points[i].x);

					if (result.get(slope) != null) {
						result.put(slope, result.get(slope) + 1);
					} else {
						result.put(slope, 1);
					}
				}
			}

			for (Integer count : result.values()) {
				if (count + duplicate > max) {
					max = count + duplicate;
				}
			}

			max = Math.max(vertical + duplicate, max);
			result.clear();
		}

		return max;
	}
	
	public static void main(String[] args) {
		
		Point p1= new Point(1, 1);
		Point p2= new Point(2, 2);
		Point p3= new Point(3, 3);
		Point p4= new Point(4, 4);
		Point p5= new Point(3, 2);
		Point p6= new Point(4, 3);
		Point p7= new Point(2, 1);
		Point p8= new Point(1, 2);
		Point p9= new Point(1, 3);
		Point p10= new Point(1, 4);
		
		Point [] points = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10};
		
		System.out.println(maxPoints(points));
		
	}
}
