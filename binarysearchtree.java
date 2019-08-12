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


class BinarySearchTreeByLinkedList {

	BinaryNode root;

	public BinaryNode getRoot() {
		return root;
	}

	// Constructor
	BinarySearchTreeByLinkedList() {
		root = null;
	}

	// Insert values in BST
	void insert(int value) {
        root = insert(root, value);
        //System.out.println(root+"dhsddf");
	}

	// Helper Method
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

	

	// creates a new blank new node
	public BinaryNode createNewNode(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		return node;
	}

	
	// Deleting a node from BST
	public void deleteNodeOfBST(int value) {
		System.out.println("\n\nDeleting " + value + " from BST...");
		deleteNodeOfBST(root,value);
	}
	
	// Helper Method for delete
	public BinaryNode deleteNodeOfBST(BinaryNode root, int value) {
		if (root == null) {
			System.out.println("Value not found in BST");
			return null;
		}
		if (value < root.getValue()) {
			root.setLeft(deleteNodeOfBST(root.getLeft(), value));
		} else if (value > root.getValue()) {
			root.setRight(deleteNodeOfBST(root.getRight(), value));
		} else { // If currentNode is the node to be deleted

			if (root.getLeft() != null && root.getRight() != null) { // if nodeToBeDeleted have both children
				BinaryNode temp = root;
				BinaryNode minNodeForRight = minimumElement(temp.getRight());// Finding minimum element from right subtree
				root.setValue(minNodeForRight.getValue()); // Replacing current node with minimum node from right subtree
				root.setRight(deleteNodeOfBST(root.getRight(), minNodeForRight.getValue()));  // Deleting minimum node from right now
			} else if (root.getLeft() != null) {// if nodeToBeDeleted has only left child
				root = root.getLeft();
			} else if (root.getRight() != null) {// if nodeToBeDeleted has only right child
				root = root.getRight();
			} else // if nodeToBeDeleted do not have child (Leaf node)
				root = null;
		}
		return root;
	}// end of method

	
	
	// Get minimum element in binary search tree
	public static BinaryNode minimumElement(BinaryNode root) {
		if (root.getLeft() == null)
			return root;
		else {
			return minimumElement(root.getLeft());
		}
	}// end of method

	
	// Search a node in BST
	void searchForValue(int value) {
		searchForValue(root, value);
	}
	
	
	// Search a node in BST
	BinaryNode searchForValue(BinaryNode node, int value) {
		if (node == null) {
			System.out.println("Value: " + value + " not found in BST.");
			return null;
		} else if (node.getValue() == value) {
			System.out.println("Value: " + value + " found in BST.");
			return node;
		} else if (value < node.getValue()) {
			return searchForValue(node.getLeft(), value);
		} else {
			return searchForValue(node.getRight(), value);
		}
	}// end of method

	// Level order traversal of BST
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

	// Delete entire BST
	public void deleteTree() {
		System.out.println("Deleting entire Tree...");
		root = null;
		System.out.println("Tree deleted successfully !");
	}// end of method
	
	
	
	void printTreeGraphically() {
		Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
		Queue<Integer> level = new LinkedList<Integer>();
		
		int CurrentLevel = 1;
		boolean previousLevelWasAllNull = false;
		queue.add(root);
		level.add(1);
		
		System.out.println("\nPrinting Level order traversal of Tree...");
		if(root == null) {
			System.out.println("Tree does not exists !");
			return;
		}
		
		while (!queue.isEmpty()) {
			if(CurrentLevel == level.peek()) { //if we are in the same level
				if(queue.peek()==null) {
					queue.add(null);level.add(CurrentLevel+1);
				}else {
					queue.add(queue.peek().getLeft());level.add(CurrentLevel+1);
					queue.add(queue.peek().getRight());level.add(CurrentLevel+1);
					previousLevelWasAllNull = false;
				}
				System.out.print(queue.remove() + "  ");level.remove();
			}else { //level has changed
				System.out.println("\n");
				CurrentLevel++;
				if(previousLevelWasAllNull == true) {
					break;
				}
				previousLevelWasAllNull = true;
			}
		}//end of loop
	}//end of method
	
}// end of class

public class binarysearchtree {

	public static void main(String[] args) {
		
		//Constructor
		BinarySearchTreeByLinkedList tree = new BinarySearchTreeByLinkedList();
		
		//Inserting values in BST
		System.out.println("Inserting 10 nodes in Tree");
		tree.insert(100);
		tree.insert(80);
		tree.insert(70);
		tree.insert(90);
        tree.insert(50);
        
		
		
		
		tree.printTreeGraphically();
		
		//Searching non-existing value in Tree
		System.out.println("\n\nSearching for value on BST...");
		tree.searchForValue(80);
		
		//Searching existing value in Tree
		System.out.println("\nSearching for value on BST...");
		tree.searchForValue(60);

		
		//Deleting Node from Tree
		tree.deleteNodeOfBST(80); //Node does not exists
		tree.printTreeGraphically();
		
		/*tree.deleteNodeOfBST(57); //Node is having 0 Child
		tree.printTreeGraphically();
		
		tree.deleteNodeOfBST(60); //Node is having 1 Child
		tree.printTreeGraphically();
		
		tree.deleteNodeOfBST(50); //Node is having 2 Child
		tree.printTreeGraphically();

		//Deleting entire Tree
		tree.deleteTree();
		
		//Traversing Tree
		tree.levelOrderTraversal();
*/
	}//end of method

}//end of class
