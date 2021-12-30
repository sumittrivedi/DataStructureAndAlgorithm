package basic.week3;
public class SingleLinkedList {	
		static Node root;
		class Node {
			int data;
			Node next;
			public Node(int data) {
				this.data = data;
			}
		}
		Boolean checkCircularList(Node root) {
			Boolean flag = false;
			Node slowPointer = root;
			Node fastPointer = root.next;
			while(fastPointer != null && fastPointer != slowPointer) {
				slowPointer = slowPointer.next;
				fastPointer = fastPointer.next.next;
			}
			if (fastPointer == slowPointer) {
				flag = true;
			}
			return flag;
		}
		void createCircularList(Node root) {
			Node firstNode = new Node(88);
			SingleLinkedList.root = firstNode;
			for(int i=0; i<6; i++) {
				firstNode.next = new Node(i);
				firstNode = firstNode.next;
			}
			firstNode.next = SingleLinkedList.root;
		}
		void createNonCircularList(Node root) {
			Node firstNode = new Node(88);
			SingleLinkedList.root = firstNode;
			for(int i=0; i<6; i++) {
				firstNode.next = new Node(i);
				firstNode = firstNode.next;
			}
		}
		
		public Node mergeTwoLists(Node l1, Node l2) {
			Node result = null;
			if (l1 == null || l2 == null) {
				if (l1 == null)
					result = l2;
				else
					result = l1;
			} else {
				if (l1.data <= l2.data) {
					Node temp = l1;
					while ((temp.next != null) && (temp.next.data <= l2.data))
						temp = temp.next;
					Node temp1 = temp.next;
					temp.next = l2;
					mergeTwoLists(temp1, temp.next);
					result = l1;
				} else {
					Node temp = l2;
					while ((temp.next != null) && (temp.next.data < l1.data))
						temp = temp.next;
					Node temp2 = temp.next;
					temp.next = l1;
					mergeTwoLists(temp.next, temp2);
					result = l2;
				}
			}
			return result;
		}

		
		public static void main(String args[]) {
			
			SingleLinkedList sll = new SingleLinkedList();
//			sll.createCircularList(root);
			sll.createNonCircularList(root);
			System.out.println(sll.checkCircularList(root));
			
		}
}
