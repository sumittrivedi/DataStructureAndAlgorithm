package basic.week4;

public class Main {
	public static void main(String args[]) {
		Stack<Integer> stack = new StackImpl();
		stack.push(45);
		stack.push(25);
		stack.push(35);
		stack.isEmpty();
		stack.pop();
		System.out.println(stack.peek());
		stack.push(15);
		stack.push(95);
		stack.reverse(stack);
		System.out.println(stack.peek());
			
		Queue<Integer> queue = new QueueImpl();
		queue.enquue(12);
		System.out.println(queue.dequeue());
		System.out.println(queue.front());
		queue.enquue(52);
		queue.enquue(22);
		queue.enquue(32);
		queue.reverse();
		System.out.println(queue.front());
		queue.recursive_reverse(queue);
		System.out.println(queue.front());
		
	}

}
