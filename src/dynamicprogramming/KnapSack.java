package dynamicprogramming;

//import java.util.* ;
//import java.io.*; 

//public class Solution{
//  static int[]dp;
//  	static int knapsackWithDP(int[] weight, int[] value, int n, int maxWeight,int[] dp) {
//		if(n==0) {
//			if(weight[0]<=maxWeight) {
//				return value[0];
//			}
//			else {
//				return 0;
//			}
//		}
		
//		int take=Integer.MIN_VALUE;
//		if(weight[n]<=maxWeight) {
//			if(dp[n]!=-1) {
//				maxWeight-=weight[n];
//				return dp[n];
//			}
//		}
//		int notTake=0+knapsackWithDP(weight, value, n-1, maxWeight,dp);
//		if(weight[n]<=maxWeight) {
//			take=value[n]+knapsackWithDP(weight, value, n-1, maxWeight-weight[n],dp);
//		}
//		//System.out.println("At "+n+ " take "+take+" notTake "+ notTake+ " maxweight"+maxWeight);
//	    dp[n]=Math.max(take, notTake);
//		return dp[n];
   

//}
//static int knapknapsackwithoutDPsack1(int[] weight, int[] value, int n, int maxWeight) {
//		if (n == 0) {
//			if (weight[0] <= maxWeight) {
//				maxWeight-= weight[0];
//				return value[0];
//			} else {
//				return 0;
//			}
//		}

//		int take = Integer.MIN_VALUE;
//		int notTake = 0 + knapsackwithoutDP(weight, value, n - 1, maxWeight);
//		if (weight[n] <= maxWeight) {
//			take = value[n] + knapsackwithoutDP(weight, value, n - 1, maxWeight - weight[n]);
//		}
//	//	System.out.println("At " + n + " take " + take + " notTake " + notTake + " maxweight" + maxWeight);
//		return Math.max(take, notTake);

//	}
//  static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

//       dp=new int[value.length+1];
//	//	dp[0]=value[value.length-1];
	
//		for(int i=0;i<weight.length;i++) {
//			dp[i]=-1;
//		}
//		//System.out.println(knapsack(weight, value, weight.length-1, 5));
//		return knapsackWithDP(weight, value, value.length-1, maxWeight,dp);
//	//return knapsackwithoutDP(weight, value, weight.length-1, maxWeight);

//  }
//}

public class KnapSack{
  public static int knapsack(int[] weight,int value[],int maxWeight,int n,int[][] storage,int i){
     if(i==weight.length || maxWeight==0){
         return 0;
		}
     if(storage[i][maxWeight]!=-1){
         return storage[i][maxWeight];
		}
     if(weight[i]>maxWeight)  {
         return storage[i][maxWeight]=knapsack(weight,value,maxWeight,n-1,storage,i+1);
     }else{
         int op1=value[i]+knapsack(weight,value,maxWeight-weight[i],n-1,storage,i+1);
         int op2=knapsack(weight,value,maxWeight,n-1,storage,i+1);
         storage[i][maxWeight]=Math.max(op1,op2);
         return storage[i][maxWeight];
     }      
 }
 public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
      int storage[][]=new int[n+1][maxWeight+1];
      for(int i=0;i<n+1;i++){
          for(int j=0;j<maxWeight+1;j++){
              storage[i][j]=-1;
          }
      }
      return knapsack(weight,value,maxWeight,n+1,storage,0);
 }	
}
