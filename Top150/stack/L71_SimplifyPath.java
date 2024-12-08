package stack;

import java.util.Stack;

public class L71_SimplifyPath {
	public static void main(String[] args) {
		String path = "/home/user/Documents/../Pictures";
		String result = simplifyPath(path);
		System.out.println("Result= " + result);
	}

	public static String simplifyPath(String path) {
		Stack<String> stack = new Stack<>();
		String[] arr = path.split("/");

		for (String s : arr) {
			if (!stack.isEmpty() && s.equals("..")) {
				stack.pop();
			} else if (!s.equals("") && !s.equals(" ") && !s.equals("..")
					&& !s.equals(".")) {
				stack.push(s);
			}
		}
		return "/" + String.join("/", stack);
	}
}
