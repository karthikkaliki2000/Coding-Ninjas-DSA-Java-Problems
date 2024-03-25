package recursion;

public class BinarySearchUsingRecursion {
	public static int binarySearch(int input[], int element) {
		// Write your code here
		int res=helper(0,input.length-1,input,element);
		return res;

	}
	public static int helper(int s,int e,int[] arr,int target) {
		  if(s>e) {
			  return -1;
		  }
		  int mid=(s+e)/2;
		  if(arr[mid]==target) {
			  return mid;
		  }
		  if(arr[mid]>target) {
			  return helper(s,mid-1,arr,target);
		  }
		  return helper(mid+1,e,arr,target);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,12,15,16,20,55,78,98,100};
		
		System.out.println(binarySearch(arr,98));

	}

}
