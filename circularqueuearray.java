class CircularQueueByArray{
	
	int[] arr;
	int topOfQueue;
	int size;
	int start;

	
	public CircularQueueByArray(int size) {
		this.arr = new int[size];
		this.size = size;
		this.topOfQueue = -1;
		start = -1;
		System.out.println("Successfully created an empty queue of size: "+size);
	}//end of method


	public void enQueue(int value) {
		if(arr==null) {
			System.out.println("Array is not yet created. Please create one first.");
		}else if (isQueueFull()) {
			System.out.println("\nQueue overflow error!!");
		}else {
			initializeStartOfArray();
			if (topOfQueue+1 == size) { //if top is already at last cell of array, then reset it to first cell
				topOfQueue=0;
			}else {
				topOfQueue++;
			}
			arr[topOfQueue] = value;
			System.out.println("\nSuccessfully inserted "+value+" in the queue");
		}
	}//end of method

	
	public void initializeStartOfArray() {
		if (start == -1) { 
			start = 0;
		}
	}//end of method
	
	
	public void deQueue() {
		if (isQueueEmpty()) {
			System.out.println("Queue underflow error!!");
		} else {
			System.out.println("\n---------------------------------------------");
			System.out.println("Before Dequeue..");printArray();
			System.out.println("\nDequeing value from Queue...");
			System.out.println("Dequeued: "+arr[start]+" from queue");
			arr[start] = 0; //initialize the unused cell to 0
			if (start == topOfQueue) { //if there is only 1 element in Queue
				start = topOfQueue = -1;
			}else if (start+1 == size) { //if start has reached end of array, then start again from 0
				start=0;
			}else {
				start++;
			}
		}
		System.out.println("After Dequeue..");printArray();
		System.out.println("---------------------------------------------");
	}//end of method

	
	public boolean isQueueEmpty() {
		if (topOfQueue == -1)
			return true;
		else
			return false;
	}//end of method

	
	public boolean isQueueFull() {
		if (topOfQueue+1 == start) { //If we have completed a circle, then we can say that Queue is full
			return true;
		}else if ((start==0) && (topOfQueue+1 == size)) { //Trivial case of Queue being full
			return true;
		}else {
			return false;
		}
	}//end of method

	
	public void peekOperation() {
		//if stack is not empty, return the value on top of stack
		if (!isQueueEmpty()) {
			System.out.println("\nPeeking value from queue...");
			System.out.println(arr[start]); 
		}else {
			System.out.println("The queue is empty!!");
		}
	}//end of method

	
	public void deleteStack() {
		System.out.println("\n\nDeleting the entire Queue...");
		arr = null;
		System.out.println("Queue is successfully deleted !");
	}//end of method
	
	
	//Print entire array
	public void printArray() {
		System.out.println("Array now...");
		for(int i=0; i<size; i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println("\nStart = " + start);
		System.out.println("End = "+ topOfQueue);
	}//end of method

}//end of class

public class circularqueuearray {

	public static void main(String[] args) {

		System.out.println("Creating an empty queue...");
		CircularQueueByArray queue = new CircularQueueByArray(5);

		System.out.println("\nEnqueuing 5 values in the queue...");
		for (int i = 1; i <= 5; i++) {
			queue.enQueue(i * 10);
		}
		queue.enQueue(60);
		queue.deQueue();
		queue.deQueue();
		queue.enQueue(60);
		queue.printArray();
		queue.deQueue();
		queue.printArray();
		queue.deleteStack();

	}// end of method

}// end of class
