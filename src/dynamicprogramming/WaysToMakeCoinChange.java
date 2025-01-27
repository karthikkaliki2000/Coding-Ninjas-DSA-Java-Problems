package dynamicprogramming;

public class WaysToMakeCoinChange {
	public static long countWaysToMakeChange(int denominations[], int value){
	     
        long[] dp = new long[value+1];
        dp[0]=1;
        for (int i=0;i<denominations.length;i++)
        {
            for (int j=0;j<=value;j++)
            {
                if (j>=denominations[i])
                {
                    dp[j]=dp[j]+dp[j-denominations[i]];
                }
            }
        }
        return dp[value];
	}	
}
