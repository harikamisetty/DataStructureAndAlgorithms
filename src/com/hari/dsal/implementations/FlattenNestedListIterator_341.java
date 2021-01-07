package com.hari.dsal.implementations;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenNestedListIterator_341 implements Iterator<Integer> {

	private Stack<NestedInteger> stack = new Stack<>();

	public FlattenNestedListIterator_341(List<NestedInteger> nestedList) {
		addInteger(nestedList);
	}

	@Override
	public Integer next() {
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext() {
		while (!stack.isEmpty() && !stack.peek().isInteger()) {
			final NestedInteger ni = stack.pop();
			addInteger(ni.getList());
		}
		return !stack.isEmpty();
	}

	// addInteger([1, [4, [6]]]) -> stack = [[4, [6]], 1]
	// addInteger([4, [6]]) -> stack = [[6], 4]
	// addInteger([6]) -> stack = [6]
	private void addInteger(final List<NestedInteger> nestedList) {
		for (int i = nestedList.size() - 1; i >= 0; --i)
			stack.push(nestedList.get(i));
	}

/*	// Solution 2
	public NestedIterator(List<NestedInteger> nestedList) {
	    addInteger(nestedList);
	  }

	@Override
	public Integer next() {
		return q.poll();
	}

	@Override
	public boolean hasNext() {
		return !q.isEmpty();
	}

	private Queue<Integer> q = new LinkedList<>();

	private void addInteger(final List<NestedInteger> nestedList) {
		for (final NestedInteger ni : nestedList)
			if (ni.isInteger())
				q.offer(ni.getInteger());
			else
				addInteger(ni.getList());
	}*/
}

interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested
	// list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
