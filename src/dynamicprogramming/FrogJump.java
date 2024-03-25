package dynamicprogramming;

import java.util.* ;
import java.io.*; 
public class FrogJump {
	static int[] dp;
    public static int frogJump(int n, int heights[]) {
		dp=new int[heights.length+1];
		dp[0]=0;
		dp[1]=0;
		for(int i=2;i<=n;i++){
			int op1=0,op2=Integer.MAX_VALUE;
			op1=Math.abs(heights[i-1]-heights[i-2])+dp[i-1];
			if(i-2>0){
				op2=Math.abs(heights[i-1]-heights[i-3])+dp[i-2];
			}
			dp[i]=Math.min(op1, op2);
		}
		return dp[n];
        // Write your code here..

    }

//0 based indexing
	//  public static int frogJumpWithDP(int n, int heights[],ArrayList<Integer> dp) {

	//      if(n==0) {
	//     	 return 0;
	//      }
	//      int op1=0;int op2=Integer.MAX_VALUE;
	//      if(dp.get(n-1)!=-1) {
	//     	 op1=Math.abs(heights[n]-heights[n-1])+dp.get(n-1);
	//      }
	//      else {
	//     	 op1=Math.abs(heights[n]-heights[n-1])+frogJumpWithDP(n-1,heights,dp);
	//      }
	     
	//      if(n>1) {
	//     	 if(dp.get(n-2)!=-1) {
	//     		 op2=Math.abs(heights[n]-heights[n-2])+dp.get(n-2);
	//     	 }
	//     	 else {
	//     		 op2=Math.abs(heights[n]-heights[n-2])+frogJumpWithDP(n-2,heights,dp);
	//     	 }
	    	
	//      }
	//      dp.set(n, Math.min(op1, op2));
	//      return dp.get(n);

	//     }

	// 	public static void main(String[] args) {
	// 	// TODO Auto-generated method stub
	// 	int[] arr= {10 ,50, 10};
	// 	ArrayList<Integer> dp=new ArrayList<>();
	// 	dp.add(0);
	// 	for(int i=1;i<=arr.length;i++) {
	// 		dp.add(-1);
	// 	}
		
	// //	System.out.println(frogJump(arr.length, arr));
	// 	System.out.println(frogJumpWithDP(arr.length-1, arr,dp));

	// }

}
