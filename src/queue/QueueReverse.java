package queue;

import java.util.Queue;

public class QueueReverse {
	public static void reverseQueue(Queue<Integer> input) {
		//Your code goes here
		if(input.size()==0){
			return;
		}
		int d=input.poll();
		reverseQueue(input);
		input.add(d);
	}
}
