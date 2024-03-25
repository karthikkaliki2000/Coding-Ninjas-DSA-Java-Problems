package dynamicprogramming;


public class NumberOfSubSets {
    static int mod=1000000000+7;
     public static int findWaysWithMemoization(int num[], int tar,int ind,int[][] dp) {
	        // Write your code here.
		 if(tar==0) {
			 return 1;
		 }
		 if (ind < 0) {
            return 0;
        }
		 if(ind==0) {
			 if(tar==0 && num[0]==0) {
				 return 2;
			 }
			 if(tar==0 || tar==num[0]){
				 return 1;
			 }
			return 0;
		 }
		 if(dp[ind][tar]!=-1) {
			 return dp[ind][tar];
		 }
		 int notTake=findWaysWithMemoization(num,tar,ind-1,dp)%mod;
		 int take=0;
		 if(num[ind]<=tar) {
			 take=findWaysWithMemoization(num, tar-num[ind], ind-1,dp)%mod;
		 }
		 dp[ind][tar]= take+notTake;
		 return dp[ind][tar];
	    }
    public static int findWays(int num[], int tar) {
        // Write your code here.
        int [][] dp=new int[num.length+1][tar+1];
		for(int i=0;i<=num.length;i++) {
			for(int j=0;j<tar+1;j++) {
				dp[i][j]=-1;
			}
		}
        int ans=findWaysWithMemoization(num,tar,num.length-1,dp);
        return ans;

    }
}