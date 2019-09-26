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
        root = insert(root, value);
        //System.out.println(root+"dhsddf");
	}
    BinaryNode insert(BinaryNode currentNode, int value) {
        //System.out.println(root+"dhsddf");
		if (currentNode == null) { // if root node is blank then insert new node there
			System.out.println("Successfully inserted " + value + " in BST");
			return createNewNode(value);
		} else if (value <= currentNode.getValue()) {
			currentNode.setLeft(insert(currentNode.getLeft(), value));
			return currentNode;
		} else {
			currentNode.setRight(insert(currentNode.getRight(), value));
			return currentNode;
		}
    }
    
    public BinaryNode createNewNode(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		return node;
	}
    
    
    void levelOrderTraversal() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(root);
		System.out.println("\nPrinting Level order traversal of Tree...");
		if (root == null) {
			System.out.println("Tree does not exists !");
			return;
		}
		while (!queue.isEmpty()) {
			BinaryNode presentNode = queue.remove();
			System.out.print(presentNode.getValue() + " ");
			if (presentNode.getLeft() != null)
				queue.add(presentNode.getLeft());
			if (presentNode.getRight() != null)
				queue.add(presentNode.getRight());
		}
    }// end of method
    public BinaryNode lca(int n1, int n2)  
    { 
        return lca(root, n1, n2);
    }
    public BinaryNode lca(BinaryNode root,int n1, int n2)  
    { 
        if (root == null) 
            return null; 
   
        // If both n1 and n2 are smaller than root, then LCA lies in left 
        if (root.getValue() > n1 && root.getValue() > n2) 
            return lca(root.getLeft(), n1, n2); 
   
        // If both n1 and n2 are greater than root, then LCA lies in right 
        if (root.getValue() < n1 && root.getValue() < n2)  
            return lca(root.getRight(), n1, n2); 
   
        return root;
    }
}
public class binarytreelca
{
    /* Driver program to test above functions */
    public static void main(String[] args)  
    { 
        BinarySearchTreeByLinkedList tree = new BinarySearchTreeByLinkedList(); 
        tree.insert(20);
        tree.insert(8);
		    tree.insert(22);
		    tree.insert(4);
		    tree.insert(12);
		    tree.insert(10);
		    tree.insert(14);
		
        int n1 = 10, n2 = 14; 
        BinaryNode t = tree.lca( n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.getValue());
        
        n1 = 14; n2 = 8; 
        t = tree.lca( n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.getValue());
        
        n1 = 10; n2 = 22; 
        t = tree.lca( n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.getValue());
        //tree.levelOrderTraversal();
    } 
}
