package timecomplexity;

import java.util.Arrays;

public class RotateArrayByN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {1 ,3 ,6 ,11, 12, 17};
		rotate(arr,4);
		System.out.println(Arrays.toString(arr));

	}
	 public static void rotate(int[] arr, int d) {
	    	//Your code goes here
		 if(arr.length==0) {
			 return;
		 }
		 d=d%arr.length;
		 int[] narr=new int[arr.length];
		 int k=0;
		 for(int i=d;i<arr.length;i++) {
			 narr[k]=arr[i];
			k++;
		 }
		 for(int i=0;i<d;i++) {
			 narr[k]=arr[i];
			 k++;
		 }
		 for(int i=0;i<arr.length;i++) {
			 arr[i]=narr[i];
		 }
		 
	    }

}
