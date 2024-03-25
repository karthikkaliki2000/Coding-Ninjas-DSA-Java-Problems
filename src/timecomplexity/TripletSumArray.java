package timecomplexity;

import java.util.Arrays;

public class TripletSumArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {6, 1 ,6, 5, 3, 2, 5, 0, 5, 6, 0 };
	//	System.out.println(tripletSum(arr,10));
		System.out.println(tripletSumOptimal(arr,5));

	}
	public static int tripletSum(int[] arr, int num) {
		//Your code goes here
		int c=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				for(int k=j;k<arr.length;k++) {
					if(i!=j && j!=k) {
						if(arr[i]+arr[j]+arr[k]==num) {
							c++;
						}
					}
				}
			}
		}
		return c;
	}
	public static int tripletSumOptimal(int[] arr, int num) {
		//Your code goes here
		Arrays.sort(arr);
		int n=arr.length;
		int ans=0;
		int low;
		int high;
		for(int i=0;i<=n-3;i++) {
			low=i+1;
			high=n-1;
			while(low<high) {
				int currSum=arr[i]+arr[low]+arr[high];
				if(currSum==num) {
					ans++;
					int tHigh=high-1;
					while(tHigh>low) {
						if(arr[high]==arr[tHigh]) {
							ans++;
							tHigh--;
						}
						else {
							break;
						}
					}
					low++;
					
				}
				else if(currSum>num) {
					high--;
				}
				else {
					low++;
				}
			}
		}
		return ans;
	}

}
