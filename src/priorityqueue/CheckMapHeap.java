package priorityqueue;

public class CheckMapHeap {
	public static boolean checkMaxHeap(int arr[]) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */
		int parentIndex=0;
		int LchildIndex=2*parentIndex+1;
		int RchildIndex=2*parentIndex+2;
		int n=arr.length;
		while(LchildIndex<n) {
			if(arr[parentIndex]<arr[LchildIndex]) {
				return false;
			}
			if(RchildIndex<n && arr[parentIndex]<arr[RchildIndex]) {
				return false;
			}
			parentIndex++;
			LchildIndex=2*parentIndex+1;
			RchildIndex=2*parentIndex+2;
		}
		return true;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    //   int[] arr= {42, 20, 18, 6 ,14, 11, 9, 4};
       int[] arr= {10 ,9, 8, 7, 6, 5, 4, 3 ,2 ,7};
       System.out.println(checkMaxHeap(arr));
	}

}
