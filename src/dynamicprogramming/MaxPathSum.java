package dynamicprogramming;


import java.util.* ;
import java.io.*; 

public class MaxPathSum {
	static int[][] dp;

    public static int maximumPathSum1(int[][] matrix, int row,int col) {
        // Write your code here.
    	if(row < 0 || col<0 || col>=matrix[row].length) {
    		return Integer.MIN_VALUE;
    	}
		if(dp[row][col]!=-1) {
    		return dp[row][col];
    	}
    	if(row==0) {
    		return dp[row][col] = matrix[row][col];
    	}
    	
    	int up= maximumPathSum1(matrix,row-1,col);
    	int ldiag= maximumPathSum1(matrix,row-1,col-1);
    	int rdiag= maximumPathSum1(matrix,row-1,col+1);
    	
    	dp[row][col]=matrix[row][col] + Math.max(up, Math.max(ldiag, rdiag));
    	return dp[row][col];
    	
    }
    
    

	public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
			// TODO Auto-generated method stub
		//int[][] matrix= {{1,2,10,4},{100,3,2,4},{1,1,20,2},{1,2,2,1}};
		//System.out.println(minimumPathSum1(triangle,triangle.length,0,0));
		dp=new int[matrix.length][matrix[0].length];
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				dp[i][j]=-1;
			}
		}
		int max=Integer.MIN_VALUE;
		for(int i=0;i<matrix[0].length;i++) {
			max=Math.max(max, maximumPathSum1(matrix,matrix.length-1,i));
			// if(ans>max) {
			// 	max=ans;
			// 	//System.out.println(ans+"Ans");
			// }
		}
		return max;
	}
}
