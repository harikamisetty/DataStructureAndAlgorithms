package com.hari.dsal.Amazon;

public class StockSpanner_901 {
	private int[] prices;
	private int[] spans;
	private int top;
	private static final int SIZE = 10000;
	
    public StockSpanner_901() {
        prices = new int[SIZE];
        spans = new int[SIZE];
        top = -1;
    }
    
    public int next(int price) {
    	int span = 1;
        while (top >= 0 && prices[top] <= price) {
            span += spans[top];
            top--;
        }
        top++;
        prices[top] = price;
        spans[top] = span;
        
        return span;        
    }
    
    public static void main(String[] args) {    	
    	
    	StockSpanner_901 ss = new StockSpanner_901();
    	System.out.println(ss.next(100));
    	System.out.println(ss.next(80));
    	System.out.println(ss.next(60));
    	System.out.println(ss.next(70));
    	System.out.println(ss.next(60));
    	System.out.println(ss.next(75));
    	System.out.println(ss.next(85));
    	
	}
}
