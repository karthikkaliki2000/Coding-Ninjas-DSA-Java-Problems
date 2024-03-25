package dynamicprogramming;

public class SubSetSumToK {
	public static boolean subsetSumToK1(int n, int k, int arr[]) {
		// Write your code here.
		if(k==0) {
			return true;
		}
		if(n==0) {
			return k==arr[n];
		}
		boolean notTake=subsetSumToK1(n-1,k,arr);
		boolean take=false;
		if(k>=arr[n]) {
			take=subsetSumToK1(n-1, k-arr[n], arr);
		}
		return take || notTake;
		
	}
	public static boolean subsetSumToKWithMemoization(int n, int k, int arr[],boolean[] dp) {
		// Write your code here.
		if(k==0) {
			return true;
		}
		if(n==0) {
			return k==arr[n];
		}
		if(dp[n]) {
			return true;
		}
		boolean notTake=subsetSumToKWithMemoization(n-1,k,arr,dp);
		boolean take=false;
		if(k>=arr[n]) {
			take=subsetSumToKWithMemoization(n-1, k-arr[n], arr,dp);
		}
		dp[n]= (take || notTake);
		return dp[n];
		
	}
	
	public static boolean subsetSumToKWithtabulation(int n, int k, int arr[],boolean[][] dp) {
		// Write your code here.
		for(int ind=1;ind<arr.length;ind++) {
			for(int t=1;t<=k;t++) {
				boolean notTake=dp[ind-1][t];
				boolean take=false;
				if(k>=arr[n]) {
					take=dp[ind-1][k-arr[ind]];
				}
				dp[ind][t]= (take || notTake);
				
			}
		}
		return dp[n-1][k];
		
	}
	  public static boolean subsetSumToK(int n, int k, int arr[]) {//correct answer with tabulation
	        boolean[] dp = new boolean[k + 1];
	        dp[0] = true; // Base case: subset sum to 0 is always possible

	        for (int i = 0; i < n; i++) {
	            for (int j = k; j >= arr[i]; j--) {
	                dp[j] = dp[j] || dp[j - arr[i]];
	            }
	        }

	        return dp[k];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {1,2,3,4};
		int target=4;
//		boolean [] dp=new boolean[arr.length+1];
//		for(int i=0;i<dp.length;i++) {//declare 2d array instead of 1d 
//			dp[i]=false;
//		}
	//	System.out.println(subsetSumToK1(arr.length-1,target,arr));
	//	System.out.println(subsetSumToKWithMemoization(arr.length-1,target,arr,dp));
		
		boolean [][] dp=new boolean[arr.length][target+1];
		for(int i=0;i<arr.length;i++) {
			dp[i][0]=true;
			
		}
		
		dp[0][arr[0]]=true;
		
		
		System.out.println(subsetSumToKWithtabulation(arr.length-1,target,arr,dp));

	}

}
