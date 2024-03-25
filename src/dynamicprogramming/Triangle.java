package dynamicprogramming;

import java.util.* ;
import java.io.*; 
public class Triangle {
    static int[][] dp;
      public static int minimumPathSum2(int[][] triangle, int n,int row,int col) {
        // Write your code here.
    	if(row==n-1) {
    		return triangle[n-1][col];
    	}
    	int down=0;
    	int diag=0;
    	if(dp[row][col]!=-1) {
    		return dp[row][col];
    	}
    	down=triangle[row][col]+minimumPathSum2(triangle,n,row+1,col);
    	diag=triangle[row][col]+minimumPathSum2(triangle,n,row+1,col+1);
    	
    	dp[row][col]= Math.min(down, diag);
    	return dp[row][col];
    	
    }
    public static int minimumPathSum(int[][] triangle, int n) {
        // Write your code here.
        dp=new int[triangle.length][triangle.length];
		for(int i=0;i<triangle.length;i++) {
			for(int j=0;j<triangle.length;j++) {
				dp[i][j]=-1;
			}
		}
        return minimumPathSum2(triangle,triangle.length,0,0);
    }
	//    public static int minimumPathSum1(int[][] triangle, int n,int row,int col) {
    //     // Write your code here.
    // 	if(row==n-1) {
    // 		return triangle[n-1][col];
    // 	}
    // 	int down=0;
    // 	int diag=0;
    // 	down=triangle[row][col]+minimumPathSum1(triangle,n,row+1,col);
    // 	diag=triangle[row][col]+minimumPathSum1(triangle,n,row+1,col+1);
    // 	return Math.min(down, diag);
    	
    // }
}