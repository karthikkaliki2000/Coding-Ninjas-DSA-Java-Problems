package queue;

import java.util.Stack;

public class QueueUsing2Stacks {

    //Define the data members
	Stack s1;
	Stack s2;
	int size;


    public QueueUsing2Stacks() {
        //Implement the Constructor
    	s1=new Stack();
    	s2=new Stack();
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
    	s1.add(element);
    	size++;
    }

    public int pop() {
        //Implement the pop() function
    	int d = 0;
    	while(!s1.isEmpty()) {
    		if(s1.size()>1) {
    			s2.add(s1.pop());
    			
    		}else if(s1.size()==1){
    			d=(int) s1.pop();
    		}
    		
    	}
    	while(!s2.isEmpty()) {
    		s1.add(s2.pop());
    	}
    	size--;
		return d;
    }

    public int top() {
        //Implement the top() function
    	int d = 0;
    	while(!s1.isEmpty()) {
    		if(s1.size()==1) {
    			 d=(int) s1.peek();
    		}
    		
    	}
    	return d;
    }
}
