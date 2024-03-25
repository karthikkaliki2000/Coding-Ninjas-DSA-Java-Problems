package priorityqueue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuyTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {8,9,8,8,12};
		System.out.println(buyTicket(arr,3));

	}

	public static int buyTicket(int input[], int k) {
		
		PriorityQueue<Integer> pq=new PriorityQueue<>(new Comp2());
		Queue<Integer> q=new LinkedList<>();
		int n=input.length;
		int t=0;
		for(int i=0;i<n;i++) {
			q.add(i);
			pq.add(input[i]);
		}
//		System.out.println(pq);
//		System.out.println(q);
		while(true) {
			if(q.peek()==k && input[q.peek()]>=pq.peek()) {
				t++;
				pq.poll();
				break;
			}
			if(input[q.peek()]>=pq.peek()) {
				t++;
				pq.poll();
				q.poll();
			}
			else {
				int e=q.poll();
				q.add(e);
			}
			
		}
		
       return t;
	}

}
class Comp2 implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return -((Integer) o1).compareTo((Integer) o2)
				;
	}
	
}
