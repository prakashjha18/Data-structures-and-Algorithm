class QueueByArray{
	
	int[] arr;
	int topOfQueue;
	int beginningOfQueue;

	
	public QueueByArray(int size) {
		this.arr = new int[size];
		this.topOfQueue = -1;
		this.beginningOfQueue = -1;
		System.out.println("Successfully created an empty queue of size: "+size);
	}//end of method


	public void enQueue(int value) {
		if (isQueueFull()) {
			System.out.println("Queue overflow error!!");
		}else if (isQueueEmpty()) { //If the queue is empty then we need to initialize beginning index 
			beginningOfQueue=0;
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Successfully inserted "+value+" in the queue");
		}else { //if the queue already has some elements in it then no need to initialize beginning index
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Successfully inserted "+value+" in the queue");
		}
		printQueue();
	}//end of method
	
		
	public void printQueue() {
		if(!isQueueEmpty()) {
			System.out.println("Queue now ...");
			for(int i=beginningOfQueue; i<=topOfQueue; i++) {
				System.out.println(arr[i] + "   ");
			}
			System.out.println();
		}else {
			System.out.println("Queue is empty !");
		}
	}
	
	public void deQueue() {
		if (isQueueEmpty()) {
			System.out.println("Queue underflow error!!");
		} else {
			System.out.println("Dequeing value from Queue...");
			System.out.println("Dequeued: "+arr[beginningOfQueue]+" from queue");
			beginningOfQueue++;
			if(beginningOfQueue > topOfQueue) { //If last element in the Queue is Dequeued
				beginningOfQueue = topOfQueue = -1;
			}
		}
		printQueue();
		System.out.println();
	}//end of method

	
	public boolean isQueueEmpty() {
		if ((beginningOfQueue == -1) || (beginningOfQueue == arr.length))
			return true;
		else
			return false;
	}//end of method

	
	public boolean isQueueFull() {
		if (topOfQueue == arr.length-1) {
			return true;
		}
		else {
			return false;
		}
			
	}//end of method

	
	public void peekOperation() {
		if (!isQueueEmpty()) {
			System.out.println(arr[beginningOfQueue]); 
		}else {
			System.out.println("The queue is empty!!");
		}
	}//end of method

	
	public void deleteQueue() {
		arr = null;
		System.out.println("Queue is successfully deleted !");
	}//end of method

}//end of class

public class linearqueuearray {

	public static void main(String[] args) {

		System.out.println("Creating an empty queue...");
		QueueByArray queue = new QueueByArray(5);

		System.out.println("Enqueuing 6 values in the queue...");
		for (int i = 1; i <= 6; i++) {
			queue.enQueue(i * 10);
		}

		System.out.println("Peek value from queue...");
		queue.peekOperation();

		System.out.println("Dequeue 6 values from queue...");
		for (int i = 0; i <= 5; i++) {
			queue.deQueue();
		}

		System.out.println("Deleting the entire Queue...");
		queue.deleteQueue();

	}// end of method

}// end of class
