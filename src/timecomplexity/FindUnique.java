package timecomplexity;
import java.util.*;


public class FindUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {1,3,1,3,6,6,7,10,7};
		System.out.println(findUnique(arr));
		System.out.println(findUniqueOptimal(arr));
		

	}
	public static int findUniqueOptimal(int[] arr) {
		//Your code goes here
		int e=arr[0];
		for(int i=1;i<arr.length;i++) {
			e=e^arr[i];
		}
		return e;
		
	}
	public static int findUnique(int[] arr) {
		//Your code goes here
		Arrays.sort(arr);
		if(arr.length==1) {
			return arr[0];
		}
		ArrayList<Integer> li=new ArrayList();
		int e=arr[0];
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]==arr[i+1]) {
				li.add(arr[i]);
				continue;
			}
			else {
				if(!li.contains(arr[i])) {
					e=arr[i];
					return e;
				}
			}
			
		}
		e=arr[arr.length-1];
		return e;
		
	}

}
