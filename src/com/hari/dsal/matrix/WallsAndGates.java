package com.hari.dsal.matrix;

import java.util.LinkedList;

public class WallsAndGates {
	//DFS
	public void wallsAndGates1(int[][] rooms) {
	    if(rooms==null || rooms.length==0||rooms[0].length==0)
	        return;

	    int m = rooms.length;
	    int n = rooms[0].length;

	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	            if(rooms[i][j]==0){
	                fill1(rooms, i, j, 0);
	            }
	        }
	    }
	}

	public void fill1(int[][] rooms, int i, int j, int distance){
	    int m=rooms.length;
	    int n=rooms[0].length;

	    if(i<0||i>=m||j<0||j>=n||rooms[i][j]<distance){
	        return;
	    }

	    rooms[i][j] = distance;

	    fill1(rooms, i-1, j, distance+1);
	    fill1(rooms, i, j+1, distance+1);
	    fill1(rooms, i+1, j, distance+1);
	    fill1(rooms, i, j-1, distance+1);
	}

	// BFS

	public static LinkedList<Integer> wallsAndGates(int[][] rooms) {
	    if(rooms==null || rooms.length==0||rooms[0].length==0)
	        return null;

	    int m = rooms.length;
	    int n = rooms[0].length;

	    LinkedList<Integer> queue = new LinkedList<Integer>();

	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	            if(rooms[i][j]==0){
	                queue.add(i*n+j);
	            }
	        }
	    }

	    while(!queue.isEmpty()){
	        int head = queue.poll();
	        int x=head/n;
	        int y=head%n;

	        if(x>0 && rooms[x-1][y]==Integer.MAX_VALUE){
	            rooms[x-1][y]=rooms[x][y]+1;
	            queue.add((x-1)*n+y);
	        }

	        if(x<m-1 && rooms[x+1][y]==Integer.MAX_VALUE){
	            rooms[x+1][y]=rooms[x][y]+1;
	            queue.add((x+1)*n+y);
	        }

	        if(y>0 && rooms[x][y-1]==Integer.MAX_VALUE){
	            rooms[x][y-1]=rooms[x][y]+1;
	            queue.add(x*n+y-1);
	        }

	        if(y<n-1 && rooms[x][y+1]==Integer.MAX_VALUE){
	            rooms[x][y+1]=rooms[x][y]+1;
	            queue.add(x*n+y+1);
	        }
	    }

	    while(!queue.isEmpty()){
	    	System.out.println(queue.poll());
	    }

	    return queue;
	}

	public static void main(String[] args) {
		int rooms[][] = {{1,0,3},{4,0,6},{7,0,9}};

		LinkedList<Integer> resList = wallsAndGates(rooms);

		while(resList != null) {
			//System.out.println(resList.pop());
		}
	}
}
