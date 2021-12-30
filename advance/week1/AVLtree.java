package advance.week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val, height;
	TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.height = 0;
	}
}

public class AVLtree {

	public void updateHeight(TreeNode node) {
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}

	public int getHeight(TreeNode node) {
		return (node == null) ? -1 : node.height;
	}

	public int balanceFactor(TreeNode node) {
		return (node == null) ? 0 : getHeight(node.left) - getHeight(node.right);
	}

	public TreeNode insert(TreeNode node, int val) {
		if (node == null)
			return new TreeNode(val);
		else {
			if (val == node.val)
				throw new RuntimeException("Duplicate Key");
			else if (val < node.val)
				node.left = insert(node.left, val);
			else
				node.right = insert(node.right, val);
		}
		return balanceTree(node);
	}

	public TreeNode balanceTree(TreeNode node) {
		updateHeight(node);
		int bf = balanceFactor(node);
		if (bf < -1) {
			int bf_nodeRight = balanceFactor(node.right);
			if (bf_nodeRight > 0)
				node.right = rightRotation(node.right);
			node = leftRotation(node);
		}
		if (bf > 1) {
			int bf_nodeLeft = balanceFactor(node.left);
			if (bf_nodeLeft < 0)
				node.left = leftRotation(node.left);
			node = rightRotation(node);
		}
		return node;
	}

	public void update(int initialVal, int updatedVal) {

	}

//	public TreeNode delete(TreeNode node, int val) {
//		if(node == null)
//			return null;
//		else {
//			if(node.left == null || node.right == null) {
//				if(node.left == null && node.right == null)
//					return null;
//				else {
//					if(node.left == null)
//						return node.right;
//					else
//						return node.left;
//				}
//			}
//			else {
//				
//				
//				
//			}
//			
//		}
//	
//	}

	public TreeNode leftRotation(TreeNode node) {
		TreeNode newNode = node.right;
		node.right = newNode.left;
		newNode.left = node;
		updateHeight(node);
		updateHeight(newNode);
		return newNode;

	}

	public TreeNode rightRotation(TreeNode node) {
		TreeNode newNode = node.left;
		node.left = newNode.right;
		newNode.right = node;
		updateHeight(node);
		updateHeight(newNode);
		return newNode;

	}

	public int minumunNodes(int height) {
		if (height == 0 || height == 1)
			return height + 1;
		return 1 + minumunNodes(height - 1) + minumunNodes(height - 2);
	}

	public int totalNodes(TreeNode node) {
		if (node == null)
			return 0;
		return 1 + totalNodes(node.left) + totalNodes(node.right);
	}

	public int numOfNodesGreaterThan(TreeNode node, int val) {
		TreeNode temp = node;
		int result = 0;
		if (temp == null)
			return result;
		while (val >= temp.val) {
			if(temp.right == null)
				break;
			temp = temp.right;
		}
		if(val < temp.val) {
			result = 1 + totalNodes(temp.right) + numOfNodesGreaterThan(temp.left, val);
		}
		return result;
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> elements = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(null);
		if (root == null)
			return result;
		while (!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if (temp == null) {
				result.add(elements);
				if (!queue.isEmpty()) {
					queue.add(null);
					elements = new ArrayList<Integer>();
				}
			} else {
				elements.add(temp.val);
				if (temp.left != null)
					queue.add(temp.left);
				if (temp.right != null)
					queue.add(temp.right);
			}
		}
		return result;
	}

}
