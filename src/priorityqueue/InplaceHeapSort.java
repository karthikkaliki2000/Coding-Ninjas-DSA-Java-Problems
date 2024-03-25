package priorityqueue;

import java.util.Arrays;

public class InplaceHeapSort {
    public static void heapSort(int[] arr) {
    	//Build the heap in O(n)
    	int n=arr.length;
    	for(int i=(n/2)-1;i>=0;i--) {
    		downHeapify(arr,i,n);
    	}
    	//remove elements from starting one by one and put at last position
    	for(int i=(n-1);i>=0;i--) {
    		int temp=arr[i];
    		arr[i]=arr[0];
    		arr[0]=temp;
    		downHeapify(arr,0,i);
    	}
    	
    }
	private static void downHeapify(int[] arr, int i, int n) {
		// TODO Auto-generated method stub
		int parentIndex=i;
		int LchildIndex=2*parentIndex+1;
		int RchildIndex=2*parentIndex+2;
		while(LchildIndex < n) {
			int minIndex=parentIndex;
			if(arr[LchildIndex]<arr[minIndex]) {
				minIndex=LchildIndex;
			}
			if(RchildIndex<n && arr[RchildIndex]<arr[minIndex]) {
				minIndex=RchildIndex;
			}
			if(minIndex==parentIndex) {
				return;
			}
			int temp=arr[parentIndex];
			arr[parentIndex]=arr[minIndex];
			 arr[minIndex]=temp;
			 parentIndex=minIndex;
			 LchildIndex=2*parentIndex+1;
			 RchildIndex=2*parentIndex+2;
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {2,7,5,1,3,9,4,6};
	   heapSort(arr);
	   System.out.println(Arrays.toString(arr));
	   

	}

}
