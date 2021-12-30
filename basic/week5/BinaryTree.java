package basic.week5;
import java.util.*; 

class TreeNode { 
    int val; 
    TreeNode left; 
    TreeNode right; 
  
    TreeNode(int val) { 
      this.val = val; 
      left = null; 
      right = null; 
    } 
  } 
  
public class BinaryTree { 

	public boolean isSymmetric(TreeNode root) {
        boolean flag = true;
        if(root == null)
            return true;
        Queue<TreeNode> left_part = new LinkedList<TreeNode>();
        Queue<TreeNode> right_part = new LinkedList<TreeNode>();
        if(root.left != null) {
            left_part.add(root.left);
            left_part.add(null);
        }
        if(root.right != null) {
            right_part.add(root.right);
            right_part.add(null);
        }
        while(!left_part.isEmpty() && !right_part.isEmpty()) {
            TreeNode temp1 = left_part.poll();
            TreeNode temp2 = right_part.poll();
            if(temp1 == null || temp2 == null) {
                if(temp1 != temp2)
                    return false;
                else{
                    if(!left_part.isEmpty())
                        left_part.add(null);
                    if(!right_part.isEmpty())
                        right_part.add(null);
                } 
            }
            else {
                if(temp1.val != temp2.val)
                    return false;
                if(temp1.left == null || temp2.right == null){
                    if(temp1.left != temp2.right)
                        return false;
                }
                else{
                    left_part.add(temp1.left);
                    right_part.add(temp2.right);
                }
                if(temp1.right == null || temp2.left == null){
                    if(temp1.right != temp2.left)
                        return false;
                }
                else{
                    left_part.add(temp1.right);
                    right_part.add(temp2.left);
                }
            }
        }
        if(!left_part.isEmpty() || !right_part.isEmpty()) 
            flag = false;
        return flag;
    }
	public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> elements =  new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        if(root == null)
            return result;
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if(temp == null) {
                result.add(elements);
                if(!queue.isEmpty()) {
                    queue.add(null);
                    elements = new ArrayList<Integer>();
                }
            }
            else {
                elements.add(temp.val);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
        return result;
    }
	Stack<Integer> stack = new Stack();
    boolean flag = true;
    public boolean isValidBST(TreeNode root) {
        if(root != null) 
        	inOrder(root);
        return flag;
    }
    
    private void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        if(stack.isEmpty() == true)
            stack.push(root.val);
        else {
            if(root.val <= stack.pop()){
                flag = false;
                return;
            }
            else
                stack.push(root.val);
        }
        inOrder(root.right);
    }
  public static void main(String[] args)  { 
 
	TreeNode root = new TreeNode(1); 
    root.left = new TreeNode(2); 
    root.right = new TreeNode(2); 
    root.left.left = new TreeNode(4); 
    root.left.right = new TreeNode(5); 
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(7);
    
    BinaryTree obj = new BinaryTree();
    List<List<Integer>> result = obj.levelOrder(root);
    result.forEach(System.out::println);
    System.out.println(obj.isSymmetric(root));
    System.out.println(obj.isValidBST(root));
  } 
} 