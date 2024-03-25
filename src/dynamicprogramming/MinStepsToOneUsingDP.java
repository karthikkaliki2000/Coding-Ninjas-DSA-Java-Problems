package dynamicprogramming;


public class MinStepsToOneUsingDP {

	static int helper(int n,int[] dp){
		if(n<=1){
			return 0;
		}
		int min1=Integer.MAX_VALUE;
		int min2=Integer.MAX_VALUE;
		int min=1+helper(n-1,dp);

		if(n%2==0){
			min1=1+helper(n/2,dp);
		}
		if(n%3==0){
			min2=1+helper(n/3,dp);
		}
		return Math.min(min, Math.min(min1, min2));

	}
	static int helperWithDp(int n,int[] dp){
		// int prev=dp[0];
		// int prev2=dp[1];
		for(int i=2;i<=n;i++){
				int min1=Integer.MAX_VALUE;
				int min2=Integer.MAX_VALUE;
					int min=Integer.MAX_VALUE;
				

				if(i%2==0){
						min1=1+dp[i/2];
				}
				if(i%3==0){
						min2=1+dp[i/3];
				}
				min=1+dp[i-1];
				dp[i]=Math.min(min,Math.min(min1,min2));
			//	System.out.println(i+" "+dp[i]);


		}
	
		return dp[n];

	}
	public static int countMinStepsToOne(int n) {
		//Your code goes here
		int[] dp=new int[n+1];
		dp[0]=0;
		dp[1]=0;
		for(int i=2;i<=n;i++){
			dp[i]=-1;
		}
		return helperWithDp(n,dp);
	}

}