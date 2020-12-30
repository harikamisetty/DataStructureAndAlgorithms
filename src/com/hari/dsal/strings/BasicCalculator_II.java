package com.hari.dsal.strings;

import java.util.Stack;

public class BasicCalculator_II {
	
	// Best Solution
	private int calculate(String s) {

		if (s == null || s.length() == 0)
			return 0;

		Stack<Integer> stack = new Stack<>();
		int num = 0;
		char sign = '+'; // Default Assignment
		int len = s.length();

		for (int i = 0; i < s.length(); i++) {

			if (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0'; // To avoid more than single digit
			}

			if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len - 1) {
				if (sign == '-') {
					stack.push(-num);
				}
				if (sign == '+') {
					stack.push(num);
				}
				if (sign == '*') {
					stack.push(stack.pop() * num);
				}
				if (sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = s.charAt(i); // Very Important step
				num = 0; // Defailut it to 0 Since it's already copied
			}
		}
		
		int re = 0;
		// Condition to add all items from Stack when it has only + or -
		for (int i : stack) {
			re += i;
		}
		
		return re;
	}
	// Method 2
	 public enum Operator{ADD, SUBTRACT, MULTIPLY, DIVIDE, BLANK}

	    public static void main(String[] args){
	        String expression = "2+3+5+5";
	        BasicCalculator_II calc = new BasicCalculator_II();
	        System.out.println(calc.calculate(expression));
	    }

	    public int  compute(String sequence){
	        Stack<Double> numberStack = new Stack<Double>();
	        Stack<Operator> operatorStack = new Stack<Operator>();
	        for(int i = 0; i < sequence.length(); i++){
	            try{
	                int number = parseNumber(sequence, i);
	                numberStack.push((double)number);

	                i += Integer.toString(number).length();
	                if(i >= sequence.length()){
	                    break;
	                }

	                Operator op = parseOperator(sequence, i);
	                collapseTop(numberStack, operatorStack, op);
	                operatorStack.push(op);
	            } catch(NumberFormatException ex){
	                return Integer.MIN_VALUE;
	            }
	        }
	        collapseTop(numberStack, operatorStack, Operator.BLANK);
	        if(numberStack.size() == 1 && operatorStack.size() == 0){
	            return numberStack.pop().intValue();
	        }
	        return 0;
	    }

	    private void collapseTop(Stack<Double> numberStack, Stack<Operator> operatorStack, Operator futureTop){
	        while(numberStack.size() >= 2 && operatorStack.size() >= 1){
	            if(priorityOfOperator(futureTop) <= priorityOfOperator(operatorStack.peek())){
	                double second = numberStack.pop();
	                double first = numberStack.pop();
	                Operator op = operatorStack.pop();
	                double result = applyOp(first, op, second);
	                numberStack.push(result);
	            } else{
	                break;
	            }
	        }
	    }

	    private double applyOp(double left, Operator op, double right){
	        switch (op){
	            case ADD: return left + right;
	            case SUBTRACT: return left - right;
	            case MULTIPLY: return left * right;
	            case DIVIDE: return left / right;
	            default: return right;
	        }

	    }

	    private int priorityOfOperator(Operator op){
	        switch (op){
	            case ADD: return 1;
	            case SUBTRACT: return 1;
	            case MULTIPLY: return 2;
	            case DIVIDE: return 2;
	            case BLANK: return 0;
	        }
	        return 0;
	    }

	    private int parseNumber(String sequence, int offset){
	        StringBuilder sb = new StringBuilder();
	        while(offset < sequence.length() && Character.isDigit(sequence.charAt(offset))){
	            sb.append(sequence.charAt(offset));
	            offset++;
	        }
	        return Integer.parseInt(sb.toString());
	    }

	    private Operator parseOperator(String sequence, int offset){
	        if(offset < sequence.length()){
	            char op = sequence.charAt(offset);
	            switch (op){
	                case '+': return Operator.ADD;
	                case '-': return Operator.SUBTRACT;
	                case '*': return Operator.MULTIPLY;
	                case '/': return Operator.DIVIDE;
	            }
	        }
	        return Operator.BLANK;
	    }

}
