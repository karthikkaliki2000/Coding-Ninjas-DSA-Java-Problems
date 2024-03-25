package recursion;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {23,78,98,34,56,2,12,5,89,45};
		int []r=mergeSort(arr);
		System.out.println(Arrays.toString(r));

	}

	private static int[] mergeSort(int[] arr) {
		// TODO Auto-generated method stub
		if(arr.length==1) {
			return arr;
		}
		int mid=arr.length/2;
		int[] l=mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] r=mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
		int[] res=merge(l,r);
		return res;
	}

	private static int[] merge(int[] larr, int[] rarr) {
		// TODO Auto-generated method stub
		int res[]=new int[larr.length+rarr.length];
		int i=0;
		int j=0;
		int k=0;
		while(i<larr.length && j<rarr.length) {
			if(larr[i]<rarr[j]) {
				res[k]=larr[i];
				i++;
				k++;
			}
			else {
				res[k]=rarr[j];
				j++;
				k++;
			}
		}
		while(i<larr.length) {
			res[k]=larr[i];
			i++;
			k++;
		}
		while(j<rarr.length) {
			res[k]=rarr[j];
			j++;
			k++;
		}
		return res;
		
		
	}

}
