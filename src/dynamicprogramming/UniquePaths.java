package dynamicprogramming;

import java.util.ArrayList;

public class UniquePaths {
    static int[][] dp;
    static int mod=1000000007;
    // static int f(int n, int m, ArrayList<ArrayList<Integer>> mat,int[][] dp) {
	// 	if(n>=0 && m>=0 && mat.get(n).get(m)==-1) {
	// 		return 0;
	// 	}
	// 	if(n==0 && m==0) {
	// 		return 1;
	// 	}
	// 	if(n<0 || m<0) {
	// 		return 0;
	// 	}
	// 	if(dp[n][m]!=-1) {
	// 		return dp[n][m];
	// 	}
    //     int top=0;int left=0;
	// 	if(n>0){
    //         top=f(n-1,m,mat,dp);
    //     }
    //     if(m>0){
    //         left=f(n, m-1, mat,dp);
    //     }
		
	// 	 dp[n][m]=(left+top)%mod;
    //      return dp[n][m];
	// }
     static int f(int n, int m, ArrayList<ArrayList<Integer>> mat,int[][] dp) {
         for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                 if(mat.get(i).get(j)==-1){
                     dp[i][j]=0;
                 }
                 else if(i==0 && j==0){
                     dp[i][j]=1;
                 }
                 else{
                     int up=0;
                     int left=0;
                     if(i>0){
                         up=dp[i-1][j];
                     }
                     if(j>0){
                         left=dp[i][j-1];
                     }
                     dp[i][j]=(up+left)%mod;
                 }
             }
         }
         return dp[n-1][m-1];
	}
    static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
        // Write your code here.
        dp=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				dp[i][j]=-1;
			}
		}
        return f(n,m,mat,dp);
    }

}
