package timecomplexity;

import java.util.ArrayList;
import java.util.Arrays;

public class FindDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {0,7,2,5,4,7,1,3,6};
		System.out.println(findDuplicate(arr));

	}
	public static int findDuplicate(int[] arr) {
		//Your code goes here
		Arrays.sort(arr);
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i]==arr[i+1]) {
				return arr[i];
			}
			
			
		}
		int e=arr[arr.length-1];
		return e;
		
	}

}
