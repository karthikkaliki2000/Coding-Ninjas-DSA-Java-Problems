package queue;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

}



public class QueueUsingLL {

//Define the data members
 private Node front;
 private Node rear;
 private int size;

public QueueUsingLL() {
	//Implement the Constructor
	front=null;
	rear=null;
	size=0;
}



/*----------------- Public Functions of Stack -----------------*/


public int getSize() { 
	//Implement the getSize() function
	return size;
}


public boolean isEmpty() { 
	//Implement the isEmpty() function
	return size==0;
}


public void enqueue(int data) {
	//Implement the enqueue(element) function
	Node n=new Node(data);
	if(rear==null){
       front=n;
	   rear=n;
	   
	}
	else{
		rear.next=n;
		rear=n;
	}
	
	size++;
}


public int dequeue() {
	//Implement the dequeue() function
	int data;
	if(size==0) {
		return -1;
	}
	if(front==rear) {
		data=front.data;
		front=null;
		rear=null;
	}
	else {
		
		data=front.data;
		front=front.next;	
	}
	size--;
	return data;
	
}


public int front() {
	//Implement the front() function
	if(front!=null) {
		return front.data;
	}
	else {
		System.out.println("Hi");
		return -1;
	}
}
}

