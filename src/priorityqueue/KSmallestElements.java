package priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;


public class KSmallestElements {
	public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
		// Write your code here
		Comparator c=new comp();
		PriorityQueue<Integer> pq=new PriorityQueue<>(c);
		for(int i=0;i<k;i++) {
			pq.add(input[i]);
		}
		for(int i=k;i<input.length;i++) {
			if(pq.peek()>input[i]) {
				int temp=pq.poll();
				pq.add(input[i]);
				input[i]=temp;
			}
		}
	//	System.out.println(pq);
		ArrayList<Integer> al=new ArrayList<>(pq);
		return al;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {9,6,11,5,4,8,7};
		System.out.println(kSmallest(arr.length,arr,3));

	}
	
	

}
class comp implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		
		return -((Integer) o1).compareTo((Integer)o2);
	}

	

	
	
}
