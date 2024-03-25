package priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.*;
import java.util.PriorityQueue;

public class KLargestElements {
	public static int kthLargest(int n, int[] input, int k) {
		// Write your code here
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0;i<k;i++) {
			pq.add(input[i]);
		}
		for(int i=k;i<input.length;i++) {
			if(pq.peek()<input[i]) {
				int temp=pq.poll();
				pq.add(input[i]);
				input[i]=temp;
			}
		}
	//	System.out.println(pq);
		ArrayList<Integer> al=new ArrayList<>(pq);
		al.sort(new comp1());
	//	System.out.println(al);
		return al.get(al.size()-1);
		

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int[] arr= {9,6,11,5,4,8,7};
		int []arr= {
				10101 ,565, 4921, 60
		};

	//	System.out.println(kLargest(arr,3));
		System.out.println(kthLargest(arr.length,arr,2));

	}
	public static ArrayList<Integer> kLargest(int input[], int k) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0;i<k;i++) {
			pq.add(input[i]);
		}
		for(int i=k;i<input.length;i++) {
			if(pq.peek()<input[i]) {
				int temp=pq.poll();
				pq.add(input[i]);
				input[i]=temp;
			}
		}
	//	System.out.println(pq);
		ArrayList<Integer> al=new ArrayList<>(pq);
		return al;
		
	}
	
}
class comp1 implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return ((Integer) o1).compareTo((Integer)o2);
	}
	
}
