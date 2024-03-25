package dynamicprogramming;


import java.util.* ;
import java.io.*; 

public class PartitionsWithGivenDifference {
    public static int countPartitions(int n,int d,int[] arr)
    {
        int totalSum=0;
        for (int num:arr)
        {
            totalSum += num;
        }
        
 
        if((totalSum-d)< 0|| (totalSum - d) % 2 != 0) 
        return 0;
        
        int s1 = (totalSum-d)/2;
        return countSubsetsWithSum(arr, s1);
    }
    
    private static int countSubsetsWithSum(int[] arr,int sum)
     {
        int n=arr.length;
        int mod=(int) 1e9 + 7;
        int[][] dp =new int[n + 1][sum+1];
        

        for (int i=0;i<=n;i++) 
        {
            dp[i][0]=1;
        }
        
        for (int i=1;i<=n;i++) 
        {
            for (int j = 0; j <= sum; j++) 
            {
                dp[i][j] = dp[i-1][j]; 
                if (j>=arr[i-1]) 
                {
                    dp[i][j]=(dp[i][j]+dp[i-1][j -arr[i-1]])%mod; 
                }
            }
        }
        
        return dp[n][sum];
    }
}


