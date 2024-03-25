package dynamicprogramming;

public class CountSubSetsWithSumK {
	 public static int findWays1(int num[], int tar,int ind) {
	        // Write your code here.
		 if(tar==0) {
			 return 1;
		 }
		 if(ind==0) {
			 if(num[0]==tar) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
		 }
		 
		 int notTake=findWays1(num,tar,ind-1);
		 int take=0;
		 if(num[ind]<=tar) {
			 take=findWays1(num, tar-num[ind], ind-1);
		 }
		 return take+notTake;
	    }
	
	 public static int findWaysWithMemoization(int num[], int tar,int ind,int[][] dp) {
	        // Write your code here.
		 if(tar==0) {
			 return 1;
		 }
		 if(ind==0) {
			 if(num[0]==tar) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
		 }
		 if(dp[ind][tar]!=-1) {
			 return dp[ind][tar];
		 }
		 int notTake=findWaysWithMemoization(num,tar,ind-1,dp);
		 int take=0;
		 if(num[ind]<=tar) {
			 take=findWaysWithMemoization(num, tar-num[ind], ind-1,dp);
		 }
		 dp[ind][tar]= take+notTake;
		 return dp[ind][tar];
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,1,4,5};
		int target=5;
		int [][] dp=new int[arr.length+1][target+1];
		for(int i=0;i<=arr.length;i++) {
			for(int j=0;j<target+1;j++) {
				dp[i][j]=-1;
			}
		}
		//System.out.println(findWays1(arr,5,arr.length-1));
		System.out.println(findWaysWithMemoization(arr, target, arr.length-1,dp));

	}

}
