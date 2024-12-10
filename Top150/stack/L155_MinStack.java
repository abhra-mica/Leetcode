package stack;
import java.util.Stack;

public class L155_MinStack {
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(512);
		ms.push(-1024);
		ms.push(-1024);
		ms.push(512);
		ms.pop();
		ms.getMin();
		ms.pop();
		ms.getMin();
		ms.pop();
		ms.getMin();
	}
}

class MinStack {
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> min_vals = new Stack<>();

	public void push(int val) {
		// <= If we entry same values multiple times
		if (min_vals.isEmpty() || val <= min_vals.peek()) {
			min_vals.push(val);
		}
		stack.push(val);
	}

	public void pop() {
		/*
		 * As stack is storing Integer objects if we done this checking using ==
		 * instead of equals() then stale result will come
		 */
		if (stack.peek().equals(min_vals.peek())) {
			min_vals.pop();
		}
		stack.pop();
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return min_vals.isEmpty() ? 0 : min_vals.peek();
	}
}
