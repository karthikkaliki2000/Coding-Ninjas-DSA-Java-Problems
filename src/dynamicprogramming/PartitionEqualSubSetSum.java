package dynamicprogramming;



public class PartitionEqualSubSetSum {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean canPartition(int[] arr, int n) {
		// Write your code here.
		int totalSum=0;
		for(int i=0;i<n;i++){
			totalSum+=arr[i];
		}
		if(totalSum%2==1){
			return false;
		}
		else{
			return subsetSumToK(n,totalSum/2,arr);
		}
	}
	    public static boolean subsetSumToK(int n, int k, int arr[]) {
        boolean[] dp = new boolean[k + 1];
        dp[0] = true; // Base case: subset sum to 0 is always possible

        for (int i = 0; i < n; i++) {
            for (int j = k; j >= arr[i]; j--) {
                dp[j] = dp[j] || dp[j - arr[i]];
            }
        }

        return dp[k];
    }
}