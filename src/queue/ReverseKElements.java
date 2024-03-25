package queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReverseKElements {

	public static Queue<Integer> reverseQueue(Queue<Integer> input) {
	//Your code goes here
	if(input.size()==0){
		return null;
	}
	int d=input.poll();
	reverseQueue(input);
	input.add(d);
	return input;
}
public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
	//Your code goes here

	int n=input.size();
	if(k==1){
		return input;
	}
    int i=1;
	Queue<Integer> q=new ArrayDeque();
	while(i<=k && input.size()>=1) {
		q.add(input.remove());
		i++;
	}
	Queue<Integer> rq=null;
	rq=reverseQueue(q);
	while(!input.isEmpty()){
        rq.add(input.remove());
	}

	return q;
	
}
		
	
	public static void main(String[] args) {
		Queue iq=new ArrayDeque();
		iq.add(10);
		iq.add(20);
		iq.add(30);
		iq.add(40);
		iq.add(50);
		Queue q=reverseKElements(iq,2);
		while(!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}
}
