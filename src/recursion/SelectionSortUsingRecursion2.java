package recursion;

import java.util.Arrays;

public class SelectionSortUsingRecursion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {18,6,10,4,8,3,24,67,2,9};
		selectionSort(arr,0,arr.length-1,Integer.MIN_VALUE,0);
		System.out.println(Arrays.toString(arr));

	}
	public static void selectionSort(int[] arr,int l,int r,int max,int maxi) {
		if(r==0) {
			return;
		}
		if(l<r) {
			if(max<arr[l]) {
				max=arr[l];
				maxi=l;
			}
			selectionSort(arr,l+1,r,max,maxi);
		}
		else {
			int t=arr[r];
			arr[r]=arr[maxi];
			arr[maxi]=t;
			selectionSort(arr,0,r-1,Integer.MIN_VALUE,0);
		}
		
	}

	

}
