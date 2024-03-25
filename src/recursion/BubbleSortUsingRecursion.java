package recursion;

import java.util.Arrays;

public class BubbleSortUsingRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {18,6,10,4,8,3,24,67,2,9};
		bubbleSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));

	}
	public static void bubbleSort(int[] arr,int l,int r) {
		if(r==0) {
			return;
		}
		
		if(l<r) {
			if(arr[l]>arr[l+1]) {
				int t=arr[l];
				arr[l]=arr[l+1];
				arr[l+1]=t;
				
		  }
			bubbleSort(arr,l+1,r);
		}
		else {
			bubbleSort(arr,0,r-1);
		}
		
	}

	

}
