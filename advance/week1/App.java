package advance.week1;

public class App {

	public static void main(String[] args) {
		TreeNode node = null;
		AVLtree obj = new AVLtree();
		node = obj.insert(node, 5);		
		node = obj.insert(node,4);
		node = obj.insert(node,3);
		node = obj.insert(node,6);
		node = obj.insert(node,7);
		node = obj.insert(node,1);		
		node = obj.insert(node,2);
		node = obj.insert(node,9);		
		node = obj.insert(node,8);
		System.out.println("Level Order => "+ obj.levelOrder(node));
		System.out.println("No. of nodes greater than given node => "+ obj.numOfNodesGreaterThan(node, 5));
		System.out.println("Minimum no of nodes for given height => "+ obj.minumunNodes(5));
	}

}
