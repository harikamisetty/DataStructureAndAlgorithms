package com.hari.dsal.matrix;

import java.util.HashSet;
import java.util.Set;

import javafx.util.Pair;

public class RoboCleaner_489 {
	// Solution
	public void cleanRoom_2(Robot robot) {
		dfs_2(robot, 0, 0, 0, new HashSet<>());
	}

	private static final int[] dirs = { 0, 1, 0, -1, 0 };

	private void dfs_2(Robot robot, int d, int i, int j, Set<Pair<Integer, Integer>> seen) {
		seen.add(new Pair<>(i, j));
		robot.clean();

		// explore clockwise: 0: ^, 1: >, 2: v, 3: <
		// the order is important since the idea is always turn right
		for (int k = 0; k < 4; ++k) {

			final int newD = (d + k) % 4;
			final int x = i + dirs[newD];
			final int y = j + dirs[newD + 1];

			if (!seen.contains(new Pair<>(x, y)) && robot.move()) {
				dfs_2(robot, newD, x, y, seen);
				// go back to the previous cell
				robot.turnRight();
				robot.turnRight();
				robot.move();
				// go back to the original direction
				robot.turnRight();
				robot.turnRight();
			}
			robot.turnRight(); // always turn the robot clockwise
		}
	}
}

interface Robot {
	// returns true if next cell is open and robot moves into the cell.
	// returns false if next cell is obstacle and robot stays on the current cell.
	boolean move();

	// Robot will stay on the same cell after calling turnLeft/turnRight.
	// Each turn will be 90 degrees.
	void turnLeft();

	void turnRight();

	// Clean the current cell.
	void clean();
}
