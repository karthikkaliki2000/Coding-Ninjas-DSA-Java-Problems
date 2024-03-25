package recursion;

public class FindMinInArray {
	public static int findMin(int[] arr,int si) {
		if(si==arr.length) {
			return Integer.MAX_VALUE;
		}
		int min=findMin(arr,si+1);
		if(arr[si]<min) {
			return arr[si];
		}
		else {
			return min;
		} 
	}
	public static void findMin(int[] arr,int si,int min) {
		if(arr.length==si) {
			System.out.println(min);
			return;
		}
	    if(arr[si]<min) {
	    	min=arr[si];
	    }
	    findMin(arr,si+1,min);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {25,89,43,12,1,36};
        // System.out.println(findMin(arr,0));
		findMin(arr,0,Integer.MAX_VALUE);
	}

}
