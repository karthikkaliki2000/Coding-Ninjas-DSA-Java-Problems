package queue;

import java.util.Arrays;

public class QueueUsingArrays {
     private int []data;
     private int front;
     private int rear;
     private int size=0;
     public QueueUsingArrays() {
 		super();
 		this.data = new int[5];
 		this.front = -1;
 		this.rear = -1;
 	}
	public QueueUsingArrays(int capacity) {
		super();
		this.data = new int[capacity];
		this.front = -1;
		this.rear = -1;
	}
	public void enqueue(int ele) throws QueueFullException {
		// TODO Auto-generated method stub
		if(size==data.length) {
		//	throw new QueueFullException();
			doubleCapacity();
		}
		if(size==0) {
			front=0;
		}
		//System.out.println(Arrays.toString(data)+"HI");
		rear=(rear+1)%data.length;
		data[rear]=ele;
		size++;
	//	System.out.println(data.length);
		
	}
	private void doubleCapacity() {
		// TODO Auto-generated method stub
		int []temp=data;
		data=new int[2*temp.length];
		int k=0;
		for(int i=front;i<temp.length;i++) {
			data[k++]=temp[i];
		}
		for(int i=0;i<front-1;i++) {
			data[k++]=temp[i];
		}
		front=0;
		rear=temp.length-1;
		
		
	}
	public int dequeue() throws QueueEmptyException {
		// TODO Auto-generated method stub
		if(size==0) {
			throw new QueueEmptyException();
		}
		int dq=data[front];
		data[front]=0;
		
		size--;
		if(size>0) {
			front=(front+1)%data.length;
		}
		if(size==0) {
			front =-1;
			rear=-1;
		}
		return dq;
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	public int front() throws QueueEmptyException {
		// TODO Auto-generated method stub
		if(size==0) {
			throw new QueueEmptyException();
		}
		return data[front];
	}
	
     
}
