package com.hari.dsal.matrix;

public class RobotBoundedInCircle {
	
	int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int curX = 0;
    int curY = 0;
    int curDir = 0;  
    
    public boolean isRobotBounded(String instructions) {
        if (instructions == null || instructions.length() == 0) {
            return true;
        }        
 
        for (int count = 0; count < 4; count++) {
            for (int i = 0; i < instructions.length(); i++) {
                char c = instructions.charAt(i);
                if (c == 'G') {
                    move();    
                } else {
                    turn(c);
                }
            }
        }
         
        return curX == 0 && curY == 0;
    }
     
    private void move() {
        curX += dirs[curDir][0];
        curY += dirs[curDir][1];
    }
     
    private void turn(char dir) {
        int dirVal = (dir == 'L' ? -1 : 1);
        curDir = (curDir + 4 + dirVal) % 4;
    }
    
    // Best Solution
    
    private boolean isCircleRobo(String instructions) {
    	int UD =0;
    	int LR =0;
    	
    	for(int i=0; i<instructions.length(); i++) {
    		if(instructions.charAt(i) == 'U') {
    			UD++;
    		} else if(instructions.charAt(i) == 'D') {
    			UD--;    			
    		} else if(instructions.charAt(i) == 'L') {
    			LR++;    		
    		} else if(instructions.charAt(i) == 'R') {
    			LR--;
    		}
    	}
    	return UD ==0 && LR ==0;  	
    }
    
    
    public static void main(String[] args) {
    	RobotBoundedInCircle rbc = new RobotBoundedInCircle();
    	String instructions ="GLR";
		System.out.println(rbc.isRobotBounded(instructions ));
		System.out.println(rbc.isCircleRobo("UD"));
	}
}
