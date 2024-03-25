package timecomplexity;

public class PairSumArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,3,6,2,5,4,3,2,4};
		System.out.println(pairSum(arr,7));

	}
	public static int pairSum(int[] arr, int num) {
		//Your code goes here
		int c=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				if(i!=j) {
					if(arr[i]+arr[j]==num) {
						c++;
					}
				}
			}
		}
		return c;
	}

}
