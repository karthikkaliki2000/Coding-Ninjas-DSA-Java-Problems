package recursion;

public class RotatedBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {5,6,7,8,9,1,2,3};
		System.out.println(rbs(arr,3,0,arr.length-1));

	}

	private static int rbs(int[] arr, int target,int s,int e) {
		// TODO Auto-generated method stub
		if(s>e) {
			return -1;
		}
		int mid=(s+e)/2;
		if(arr[mid]==target) {
			return mid;
		}
		if(arr[s]<=arr[mid]) {
			if(arr[s]<=target && arr[mid]>=target) {
				e=mid;
			}
			else {
				s=mid+1;
			}
		}
		else {
			if(arr[mid]<=target && arr[e]>=target) {
				s=mid;
			}
			else {
				e=mid-1;
			}
		}
		return rbs(arr,target,s,e);
	}

}
