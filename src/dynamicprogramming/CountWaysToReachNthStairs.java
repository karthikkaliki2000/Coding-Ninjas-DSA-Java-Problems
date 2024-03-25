package dynamicprogramming;


//import java.util.* ;
//import java.io.*; 
//public class Solution {
	
//	public static long countDistinctWayToClimbStair(int nStairs) {
//		int n=nStairs;
//		if(n==0){
//			return 1;
//		}
//		long l=0;
//		long r=0;
//		if(n>=1){
//			l= countDistinctWayToClimbStair(n-1);
//		}
//		if(n>=2){
//			r= countDistinctWayToClimbStair(n-2);
//		}
//		return l+r;

//	}
//}
public class CountWaysToReachNthStairs {
 public static final int MOD = 1000000007;

 public static void multiply(long F[][], long M[][]) {
     long x = (F[0][0] * M[0][0] + F[0][1] * M[1][0]) % MOD;
     long y = (F[0][0] * M[0][1] + F[0][1] * M[1][1]) % MOD;
     long z = (F[1][0] * M[0][0] + F[1][1] * M[1][0]) % MOD;
     long w = (F[1][0] * M[0][1] + F[1][1] * M[1][1]) % MOD;

     F[0][0] = x % MOD;
     F[0][1] = y % MOD;
     F[1][0] = z % MOD;
     F[1][1] = w % MOD;
 }

 public static void power(long F[][], long nStairs) {
     if (nStairs == 0 || nStairs == 1) {
         return;
     }

     long M[][] = {{1, 1}, {1, 0}};

     power(F, nStairs / 2);
     multiply(F, F);

     if (nStairs % 2 == 1) {
         multiply(F, M);
     }
 }

 public static long fib(long nStairs) {
     long F[][] = {{1, 1}, {1, 0}};

     if (nStairs == 0) {
         return 0;
     }

     power(F, nStairs - 1);

     return F[0][0];
 }

 public static long countDistinctWayToClimbStair(long nStairs) {
     return fib(nStairs + 1);
 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}


