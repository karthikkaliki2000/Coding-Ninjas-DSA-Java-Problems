package recursion;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {4,3,8,2,1,9};
		quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));

	}

	private static void quickSort(int[] arr,int l,int h) {
		// TODO Auto-generated method stub
		if(l>=h) {
			return;
		}
		int s=l;
		int e=h;
		int mid=(s+e)/2;
		int pivot=arr[mid];
		while(s<=e) {
			while(arr[s]<pivot) {
				s++;
			}
			while(arr[e]>pivot) {
				e--;
			}
			if(s<=e) {
				int t=arr[s];
				arr[s]=arr[e];
				arr[e]=t;
				s++;
				e--;
			}
		}
		quickSort(arr,l,e);
		quickSort(arr,s,h);
		
	}

}
