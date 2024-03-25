package stack;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

import queue.QueueUse;

public class StackUsing2Queues {


    //Define the data members
	private Queue q1=new ArrayDeque();
	private Queue q2=new ArrayDeque();
	private int size;


    public StackUsing2Queues() {
        //Implement the Constructor
    	q1=new ArrayDeque();
    	q2=new ArrayDeque();
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

    public void push(int element) {
        //Implement the push(element) function
		q1.add(element);
		size++;
    }

    public int pop() {
        //Implement the pop() function
    	if(q1.size()==0) {
    		return -1;
    	}
    	int d=0;
		while(!q1.isEmpty()){
			if(q1.size()==1) {
				d=(int) q1.remove();
			}
			else {
				q2.add(q1.remove());
			}
		}
		while(!q2.isEmpty()) {
			q1.add(q2.remove());
		}
		size--;
		return d;
    }

    public int top() {
    	 //Implement the pop() function
    	if(q1.size()==0) {
    		return -1;
    	}
    	int d=0;
    	while(!q1.isEmpty()) {
    		if(q1.size()==1) {
    			d=(int) q1.peek();
    		}
    		q2.add(q1.remove());
    	}
    	while(!q2.isEmpty()) {
			q1.add(q2.remove());
		}
    	return d;
    }

}
