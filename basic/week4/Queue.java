package basic.week4;

@SuppressWarnings("hiding")
public interface Queue<Integer> {
	void enquue(Integer item);
	Integer dequeue();
	Integer front();
	boolean isEmpty();
	void reverse();	
	void recursive_reverse(Queue<Integer> queue);
}
