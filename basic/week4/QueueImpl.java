package basic.week4;

public class QueueImpl implements Queue<Integer>{
	static Integer array[] = new Integer[5];
	int length = array.length;
	int front = -1;
	int rear = -1; 

	@Override
	public void enquue(Integer item) {
		if(front == -1 && rear == -1) {
			array[++rear] = item;
			front = 0;
			return;
		}
		if(rear-front == length-1 || front-rear == 1) {
			System.out.println("Stack Overflow");
		}
		else {
			if(rear == length-1) {
				rear = 0;
				array[rear] = item;
			}
			else
				array[++rear] = item;
		}
	}

	@Override
	public Integer dequeue() {
		Integer temp = null;
		if(front < rear)
			temp = array[front++];
		if(front == rear) {
			if(front == -1)
				System.out.println("Underflow");
			else {
				temp = array[front];
				front = rear = -1;
			}
		}
		if(front > rear) {
			if(front == length-1) {
				temp = array[front];
				front = 0;
			}
			else
				front++;
		}
		return temp;
	}

	@Override
	public Integer front() {
		Integer temp = null;
		if(!isEmpty()) 
			temp = array[front];
		else
			System.out.print("Queue is empty -> ");
		return temp;
	}

	@Override
	public boolean isEmpty() {
		boolean flag = false;
		if(front == -1 && rear == -1)
			flag = true;
		return flag;
	}

	@Override
	public void reverse() {
		int i = front;
		int j = rear;
		QueueImpl queueObj = new QueueImpl();
		while(i != j) {
			queueObj.swap(i,j);
			if(j-i == 1 || i-j == length-1)
				return;
			i++;
			j--;
			if(i>length-1)
				i = 0;
			if(j<0)
				j = length-1;
		}
	}


	private void swap(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	@Override
	public void recursive_reverse(Queue<Integer> queue) {
		if(queue.isEmpty() == false) {
			Integer temp = queue.dequeue();
			recursive_reverse(queue);
			queue.enquue(temp);
		}
	}
}
