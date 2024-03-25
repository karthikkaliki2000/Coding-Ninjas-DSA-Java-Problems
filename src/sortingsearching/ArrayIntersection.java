package sortingsearching;

import java.util.Arrays;

public class ArrayIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr1= {1,3,5,9,9,8};
		int [] arr2= {21,40,5,2,9,90};
		
	
		intersection(arr1,arr2);
		
//		System.out.println(Arrays.toString(arr1));
//		System.out.println(Arrays.toString(arr2));

	}
	public static void intersection(int[] arr1, int[] arr2) {
	    //Your code goes here
		QuickSort.sort(arr1,0,arr1.length-1);
		QuickSort.sort(arr2,0,arr2.length-1);
		
		for(int i=0;i<arr1.length;i++) {
			int target=arr1[i];
			int s=0;
			int e=arr2.length-1;
			while(s<=e) {
				int mid=(s+e)/2;
				String a2=String.valueOf(arr2[mid]);
				if(arr2[mid]==target) {
					
					System.out.print(arr2[mid]+" ");
					arr2[mid]=0;
					break;
				}
				if(arr2[mid]>target) {
					
					e=mid-1;
				}
				else {
					s=mid+1;
				}
			}
		}
	
	}

}
