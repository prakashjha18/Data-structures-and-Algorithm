class SingleNode {
	private int value;
	private SingleNode next;
	
    public int getValue() {
            return value;
        }

	public void setValue(int value) {
		this.value = value;
	}

	public SingleNode getNext() {
		return next;
	}

	public void setNext(SingleNode next) {
		this.next = next;
	}

    @Override
    public String toString() {
        return  value + "";
    }

}

class SingleLinkedList {
	private SingleNode head;
	private SingleNode tail;
	private int size;// denotes size of list
	
	
	public SingleNode createSingleLinkedList(int nodeValue) {
		head = new SingleNode();
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		node.setNext(null);
		head = node;
		tail = node;
		size = 1;// size =1
		return head;
	}

	public SingleNode getHead() {
		return head;
	}

	public void setHead(SingleNode head) {
		this.head = head;
	}

	public SingleNode getTail() {
		return tail;
	}

	public void setTail(SingleNode tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	public void insertInLinkedList(int nodeValue, int location) {
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		if (!existsLinkedList()) { // Linked List does not exists
			System.out.println("The linked list does not exist!!");
			return; 
		} else if (location == 0) {// insert at first position
			node.setNext(head);
			head = node;
		} else if (location >= size) {// insert at last position
			node.setNext(null);
			tail.setNext(node);
			tail = node; 
		} else {// insert at specified location
			SingleNode tempNode = head;
			int index = 0;
			while (index < location - 1) {// loop till we reach specified node
				tempNode = tempNode.getNext();
				index++;
			}//tempNode currently references to node after which we should insert new node
			SingleNode nextNode = tempNode.getNext(); //this is the immediate next node after new node
			tempNode.setNext(node);//update reference of tempNode to reference to new node
			node.setNext(nextNode);//update newly added nodes' next.
		}
		setSize(getSize()+1);
	}

	
	public boolean existsLinkedList() {
		// if head is not null retrun true otherwise return false
		return head != null;
	}
	
	
	//Traverses Linked List
	void traverseLinkedList() {
		if (existsLinkedList()) {
			SingleNode tempNode = head;
			for (int i = 0; i < getSize(); i++) {
				System.out.print(tempNode.getValue());
				if (i != getSize() - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		}else {
			System.out.println("Linked List does not exists !");
		}
		System.out.println("\n");
	}

	
	//Deletes entire Linked List
	void deleteLinkedList() {
		System.out.println("\n\nDeleting Linked List...");
		head = null;
		tail = null;
		System.out.println("Linked List deleted successfully !");
	}

	
	//Searches a node with given value
	boolean searchNode(int nodeValue) {
		if (existsLinkedList()) {
			SingleNode tempNode = head;
			for (int i = 0; i < getSize(); i++) {
				if (tempNode.getValue() == nodeValue) {
					System.out.print("Found the node at location: "+i+"\n");
					return true;
				}
				tempNode = tempNode.getNext();
			}
		}
		System.out.print("Node not found!! \n");
		return false;
	}
	
	
	//Deletes a node having a given value
	public void deletionOfNode(int location) {
        
		if (!existsLinkedList()) {
			System.out.println("The linked list does not exist!!");// Linked List does not exists
			return;
        } else if (location == 0) { // we want to delete first element
           
            head = head.getNext();
            //System.out.println(head +"sh");
			setSize(getSize()-1);
            if(getSize() == 0) { // if there are no more nodes in this list
                
				tail = null;
			}	
        }else if (location >= getSize()){ //If location is not in range or equal, then delete last node
            
			SingleNode tempNode = head;
			for (int i = 0; i < size - 1; i++) {
				tempNode = tempNode.getNext(); //temp node points to 2nd last node
			}
			if (tempNode == head) { //if this is the only element in the list
				tail = head = null;
				setSize(getSize()-1);
				return;
			}
			tempNode.setNext(null); 
			tail= tempNode;
			setSize(getSize()-1);
			
        }else { //if any inside node is to be deleted
            
			SingleNode tempNode = head;
			for (int i = 0; i < location - 1; i++) {
				tempNode = tempNode.getNext(); // we need to traverse till we find the location
			}	
			tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
			setSize(getSize()-1);
		}//end of else	
		
	}//end of method
	
}// end of class

class StackByLinkedList {

	SingleLinkedList list;

	
	//constructor
	public  StackByLinkedList() {
		list = new SingleLinkedList();
	}//end of method

	
	public void push(int value) {
		if(list.getHead()== null) {
			list.createSingleLinkedList(value);
		}else {
			list.insertInLinkedList(value, 0);	
		}
		System.out.println("Inserted " + value + " in Stack !");
	}//end of method

	
	public int pop() {
		int value = -1;
		if (isEmpty()) {
			System.out.println("Stack underflow error!!");
		} else {
			value = list.getHead().getValue();
			list.deletionOfNode(0);
		}
		return value;
	}// end of method

	
	public boolean isEmpty() {
		if (list.getHead() == null)
			return true;
		else
			return false;
	}// end of method

	
	public int peek() {
		if (!isEmpty())
			return list.getHead().getValue();
		else {
			System.out.println("The stack is empty!!");
			return -1;
		}
	}// end of method
	

	public void deleteStack() {
		list.setHead(null);
	}//end of method
	
}//end of method

public class stacklinkedlist {

	public static void main(String[] args) {

		StackByLinkedList stack = new StackByLinkedList();

		System.out.println("Pushing 10 values into stack");
		for (int i = 1; i <= 10; i++) {
			stack.push(i * 10);
		}
		System.out.println();

		System.out.println("Peeking value");
		System.out.println(stack.peek());
		System.out.println();

		System.out.println("Poping 11 values from stack");
		for (int i = 1; i <= 11; i++) {
			System.out.println(stack.pop());
		}
		System.out.println();

	}

}
