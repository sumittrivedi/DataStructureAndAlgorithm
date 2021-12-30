package basic.week3;
public class DoubleLinkedLIst {
	static Node root;
	class Node {
		String data;
		Node prev;
		Node next;
		public Node(String data) {
			this.data = data;
		}
		public String getData() {
			return data;
		}
		public Node getPrev() {
			return prev;
		}
		public Node getNext() {
			return next;
		}
	}

	void insert(Node root, String data, int index) {
		Node newNode = new Node(data);
		if(index == 0) {
			Node rootNext = null;
			if(root != null)
				rootNext = root.next;
			DoubleLinkedLIst.root = newNode;
			DoubleLinkedLIst.root.next = rootNext;
		}
		else {
			int count = 0;
			Node currentNode = root;
			Node prevNode = currentNode.prev;
			while(count < index ) {
				if(currentNode.next == null) {
					Node tempNode = new Node("");
					tempNode.prev = currentNode;
					currentNode.next = tempNode;
				}
				prevNode = currentNode;
				currentNode = currentNode.next;
				count++;
			}
			newNode.prev = prevNode;
			newNode.next = currentNode.next;
			prevNode.next = newNode;
			if(currentNode.next != null)
				currentNode.next.prev = newNode;
		}
	}
	
	void delete(Node root, int index) {
		if(index == 0) {
			DoubleLinkedLIst.root = null;
		}
		else {
			int count = 0;
			Node currentNode = root;
			Node prevNode = null;
			while(count < index) {
				prevNode = currentNode;
				currentNode = currentNode.next;
				count++;
				
			}
			prevNode.next = currentNode.next;
			currentNode.next.prev = prevNode;
			currentNode.prev = currentNode.next = null;
		}
	}
	
	Node reverse(Node root) {
		Node tempNode = root;
		if(tempNode.next == null) 
			return root;
		
		int count = 0;
		while(tempNode.next != null) { 
			count++;
			tempNode = tempNode.next;
		}
		Node frontPointer = root;
		Node rearPointer = tempNode;
		for(int i = 0; i < (count+1)/2; i++) {
			String tempData = frontPointer.data;
			frontPointer.data = rearPointer.data;
			rearPointer.data = tempData;
			frontPointer = frontPointer.next;
			rearPointer = rearPointer.prev;
		}
		return root;
	}
	
	void display(Node root) {
		Node tempNode = root;
		while(tempNode != null) {
			System.out.println(tempNode.data);
			tempNode = tempNode.next;
		}
	}
	
	public static void main(String args[]) {
		
		DoubleLinkedLIst dll = new DoubleLinkedLIst();
		dll.insert(root, "A", 0);
		dll.insert(root, "B", 1);
		dll.insert(root, "C", 2);
		dll.insert(root, "D", 3);
		dll.insert(root, "E", 6);
		dll.insert(root, "hg", 4);
		dll.insert(root, "AA", 0);
		dll.insert(root, "BB", 1);
		dll.reverse(root);
		dll.delete(root, 2);
		dll.display(root);
	}

}
