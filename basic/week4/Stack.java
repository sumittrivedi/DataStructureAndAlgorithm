package basic.week4;

@SuppressWarnings("hiding")
public interface Stack<Integer> {
	void push(Integer item);
	Integer pop();
	Integer peek();
	Boolean isEmpty();
	Stack<Integer> reverse(Stack<Integer> stack);
}
