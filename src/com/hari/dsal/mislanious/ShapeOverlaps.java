package com.hari.dsal.mislanious;

public class ShapeOverlaps {

	//Circle Overlap with Rectangle
	private boolean checkOverlap(int X1, int Y1, int X2, int Y2,int Xc, int Yc ,int R) {
		// Find the nearest point on the rectangle to the center of the circle
		int Xn = Math.max(X1, Math.min(Xc, X2));
		int Yn = Math.max(Y1, Math.min(Yc, Y2));
		
		// Find the distance between the nearest point and the center of the circle
	    // Distance between 2 points, (x1, y1) & (x2, y2) in 2D Euclidean space is
	    // ((x1-x2)**2 + (y1-y2)**2)**0.5
		int Dx = Xn - Xc;
		int Dy = Yn - Yc;
		
		return Math.sqrt(Dx * Dx + Dy * Dy) <= R ;
	}

	public static void main(String[] args) {
		ShapeOverlaps so = new ShapeOverlaps();
		System.out.println(so.checkOverlap(3, 3, 5, 5, 4, 4, 1));
	}
}
