package dynamicprogramming;


import java.util.* ;
import java.io.*; 
import java.util.*;
public class MaximumSumOfNonAdjacentElements {

	static int[] dp;
	public static int maximumNonAdjacentSum2(ArrayList<Integer> nums,int idx) {
	if(idx==0) {
			return nums.get(idx);
		}
		if(idx<0) {
			return 0;
		}
		int pick=nums.get(idx);
		int notPick=0;
		if(idx>1) {
			if(dp[idx-2]!=-1) {
				pick=nums.get(idx)+dp[idx-2];
			}
			else {
				pick=nums.get(idx)+maximumNonAdjacentSum2(nums,idx-2);
			}
		}
		
		if(dp[idx-1]!=-1) {
			notPick=dp[idx-1];
		}
		else {
			notPick=0+maximumNonAdjacentSum2(nums,idx-1);
		}
		
		int ans= Math.max(pick, notPick);
		dp[idx]=ans;
		return ans;
	}
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		dp=new int[nums.size()+1];
		dp[0]=nums.get(0);
		for(int i=1;i<=nums.size();i++) {
			dp[i]=-1;
		}
		return maximumNonAdjacentSum2(nums,nums.size()-1);
	}
}





// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;

// public class MaximumNonAdjacentSum1 {
// 	static int[] dp;
// 	public static int maximumNonAdjacentSum2(ArrayList<Integer> nums,int idx) {
// 		// Write your code here.
// 		if(idx==0) {
// 			return nums.get(idx);
// 		}
// 		if(idx<0) {
// 			return 0;
// 		}
// 		int pick=nums.get(idx);
// 		int notPick=0;
// 		if(idx>1) {
// 			if(dp[idx-2]!=-1) {
// 				pick=nums.get(idx)+dp[idx-2];
// 			}
// 			else {
// 				pick=nums.get(idx)+maximumNonAdjacentSum2(nums,idx-2);
// 			}
// 		}
		
// 		if(dp[idx-1]!=-1) {
// 			notPick=dp[idx-1];
// 		}
// 		else {
// 			notPick=0+maximumNonAdjacentSum2(nums,idx-1);
// 		}
		
// 		int ans= Math.max(pick, notPick);
// 		dp[idx]=ans;
// 		return ans;
// 	}
// 	public static int maximumNonAdjacentSum1(ArrayList<Integer> nums,int idx) {
// 		// Write your code here.
// 		if(idx==0) {
// 			return nums.get(idx);
// 		}
// 		if(idx<0) {
// 			return 0;
// 		}
// 		int pick=0;
// 		pick=nums.get(idx)+maximumNonAdjacentSum1(nums,idx-2);
		
// 		int notPick=0+maximumNonAdjacentSum1(nums,idx-1);
// 		return Math.max(pick, notPick);
// 	}

// 	public static void main(String[] args) {
// 		// TODO Auto-generated method stub
// 		List<Integer> arr=new ArrayList<>();
// 		arr= Arrays.asList(4, 8);
// 		ArrayList<Integer> a=new ArrayList<>(arr);

// 	//	System.out.println(maximumNonAdjacentSum1(a,a.size()-1));
		
// 		dp=new int[a.size()+1];
// 		dp[0]=a.get(0);
// 		for(int i=1;i<=a.size();i++) {
// 			dp[i]=-1;
// 		}
// 		System.out.println(maximumNonAdjacentSum2(a,a.size()-1));

// 	}

// }
