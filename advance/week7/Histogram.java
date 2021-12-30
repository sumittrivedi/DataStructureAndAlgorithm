package advance.week7;

import java.util.Stack;

public class Histogram {

	int maxArea(int[] array) {
		int max_area = 0;
		int[] nsl = nearestSmallLeft(array);
		int[] nsr = nearestSmallRight(array);
		int n = array.length;

		for (int i = 0; i < n; i++) {
			int area = (nsr[i] - nsl[i] -1) * array[i];
			if (area > max_area)
				max_area = area;
		}
		return max_area;
	}

	int[] nearestSmallLeft(int[] array) {
		int[] nsl = new int[array.length];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < array.length; i++) {
			while (stack.empty() == false && array[stack.peek()] >= array[i])
				stack.pop();
			if (stack.empty())
				nsl[i] = -1;
			else
				nsl[i] = stack.peek();
			stack.push(i);
		}
		
		return nsl;
	}

	int[] nearestSmallRight(int[] array) {
		int n = array.length;
		int[] nsr = new int[n];
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = n - 1; i > -1; i--) {
			while (stack.empty() == false && array[stack.peek()] >= array[i])
				stack.pop();
			if (stack.empty())
				nsr[i] = n;
			else
				nsr[i] = stack.peek();
			stack.push(i);
		}
		return nsr;
	}
	
}
