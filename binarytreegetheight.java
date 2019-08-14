import java.util.*;

class BinaryNode {
	private int value;
	private int height;
	private BinaryNode left;
	private BinaryNode right;

	public int getHeight() {
		return height;
	}//end of method
	
	public void setHeight(int height) {
		this.height = height;
	}//end of method
	
	public int getValue() {
		return value;
	}//end of method

	public void setValue(int value) {
		this.value = value;
	}//end of method

	public BinaryNode getLeft() {
		return left;
	}//end of method

	public void setLeft(BinaryNode left) {
		this.left = left;
	}//end of method

	public BinaryNode getRight() {
		return right;
	}//end of method

	public void setRight(BinaryNode right) {
		this.right = right;
	}//end of method

	@Override
	public String toString() {
		return value + "";
	}//end of method

}
   
class BinarySearchTreeByLinkedList
{ 
    BinaryNode root; 
    BinarySearchTreeByLinkedList(){
		this.root = null;
	}
   
    /* Compute the "maxDepth" of a tree -- the number of  
       nodes along the longest path from the root node  
       down to the farthest leaf node.*/

       void insert(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		if (root == null) {
			root = node;
			System.out.println("Successfully inserted new node at Root !");
			return;
		}
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			if (presentNode.getLeft() == null) {
				presentNode.setLeft(node);
				System.out.println("Successfully inserted new node !");
				break;
			}else if (presentNode.getRight() == null) {
				presentNode.setRight(node);
				System.out.println("Successfully inserted new node !");
				break;
			} else {
					queue.add(presentNode.getLeft());
					queue.add(presentNode.getRight());
			}//end of else-if
		}//end of loop
    }//end of method
    
    public void maxDepth(BinaryNode node)  
    { 
		int a  = 0;
		
		BinaryNode temp1  = node;
		BinaryNode temp2  = node;
		
		while (temp1 != null &&  temp2 != null )
		{
			a++;
			temp1 = temp1.getLeft();

		}
		
		System.out.println(a);
    } 
}
public class binarytreegetheight
{
    /* Driver program to test above functions */
    public static void main(String[] args)  
    { 
        BinarySearchTreeByLinkedList tree = new BinarySearchTreeByLinkedList(); 
        tree.insert(1);
        tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
		tree.insert(8);
        System.out.println("Height of tree is : ");
        tree.maxDepth(tree.root); 
    } 
}
