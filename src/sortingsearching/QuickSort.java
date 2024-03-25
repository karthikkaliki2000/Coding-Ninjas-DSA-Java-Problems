package sortingsearching;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,4,3,5};
		quickSort(arr);
		System.out.println(Arrays.toString(arr));

	}

	private static void quickSort(int[] arr) {
		// TODO Auto-generated method stub
		sort(arr,0,arr.length-1);
		
	}
	static void sort(int[] arr,int l,int h) {
		// TODO Auto-generated method stub
		int mid=(l+h)/2;
		int pivot=arr[mid];
		int s=l;
		int e=h;
		if(l>h) {
			return;
		}
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
		sort(arr,l,e);
		sort(arr,s,h);
		

		
		
	}

	

}
