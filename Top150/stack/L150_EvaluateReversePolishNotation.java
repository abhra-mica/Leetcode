package stack;

import java.util.Stack;

public class L150_EvaluateReversePolishNotation {
	public static void main(String[] args) {
		String[] tokens = {"2", "1", "+", "3", "*"};
		int result = evalRPN(tokens);
		System.out.println("Result= " + result);
	}

	public static int evalRPN(String[] tokens) {
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < tokens.length; i++) {
			if (!tokens[i].equals("+") && !tokens[i].equals("-")
					&& !tokens[i].equals("*") && !tokens[i].equals("/")) {
				stack.push(tokens[i]);
			} else {
				int firstNum = Integer.parseInt(stack.pop());
				int secondNum = Integer.parseInt(stack.pop());
				int ans = 0;
				if (tokens[i].equals("+")) {
					ans = firstNum + secondNum;
				} else if (tokens[i].equals("-")) {
					ans = secondNum - firstNum;
				} else if (tokens[i].equals("*")) {
					ans = firstNum * secondNum;
				} else if (tokens[i].equals("/")) {
					ans = secondNum / firstNum;
				}
				stack.push(Integer.toString(ans));
			}
		}
		return Integer.parseInt(stack.peek());
	}
}
