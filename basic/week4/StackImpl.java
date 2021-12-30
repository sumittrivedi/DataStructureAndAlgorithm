package basic.week4;

public class StackImpl implements Stack<Integer> {
	
	static Integer array[] = new Integer[5];
	int lenth = array.length;
	int top = -1;

	@Override
	public void push(Integer item) {
		if(top < lenth-1)
			array[++top] = item;
		else
			System.out.println("Stack Overflow");
	}

	@Override
	public Integer pop() {
		Integer temp = null;
		if(!isEmpty())
			temp = array[top--];
		else
			System.out.print("Stack Undereflow");
		return temp;
	}

	@Override
	public Integer peek() {
		Integer temp = null;
		if(!isEmpty())
			temp = array[top];
		else
			System.out.print("Stack is empty");
		return temp;
	}

	@Override
	public Boolean isEmpty() {
		boolean flag = false;
		if(top < 0)
			flag = true;
		return flag;
	}

	@Override
	public Stack<Integer> reverse(Stack<Integer> stack) {
		
		if(stack.isEmpty() == false) {
			Integer x = stack.pop();
			reverse(stack);
			new StackImpl().insert_at_bottom(stack, x);
		}
		return stack;
	}
	
	private void insert_at_bottom(Stack<Integer> stack, int x) {
		if(stack.isEmpty()) {
			stack.push(x);
			return;
		}
		if(stack.isEmpty() == false) {
			int y = stack.pop();
			insert_at_bottom(stack, x);
			stack.push(y);
		}
	}

}
