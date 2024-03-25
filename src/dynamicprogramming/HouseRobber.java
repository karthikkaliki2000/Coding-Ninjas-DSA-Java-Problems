package dynamicprogramming;

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class HouseRobber {
	
	static long[] dp;
	public static long maximumNonAdjacentSum2(ArrayList<Integer> nums,int idx) {
	if(idx==0) {
			return nums.get(idx);
		}
		if(idx<0) {
			return 0;
		}
		long pick=nums.get(idx);
		long notPick=0;
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
		
		long ans= Math.max(pick, notPick);
		dp[idx]=ans;
		return ans;
	}
	public static long maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
			if(nums.size()==1) {
			return nums.get(0);
		}
		if(nums.size()==0) {
			return 0;
		}
	
		dp=new long[nums.size()+1];
		dp[0]=nums.get(0);
		for(int i=1;i<=nums.size();i++) {
			dp[i]=-1;
		}
		return maximumNonAdjacentSum2(nums,nums.size()-1);
	}

	public static long houseRobber(int[] valueInHouse) {
		// Write your code here.	
	//	List<Integer> list = Arrays.stream(valueInHouse).boxed().toList();
	if(valueInHouse.length==1) {
			return valueInHouse[0];
		}
		ArrayList<Integer> arr=new ArrayList<>();
		for(int i=0;i<valueInHouse.length;i++){
			arr.add(valueInHouse[i]);
		}
		ArrayList<Integer> arrWithOutfirst=new ArrayList<>();
		ArrayList<Integer> arrWithOutLast=new ArrayList<>();
		for(int i=0;i<arr.size()-1;i++) {
			arrWithOutfirst.add(arr.get(i+1));
			arrWithOutLast.add(arr.get(i));
		}

		long answithoutfirst=maximumNonAdjacentSum(arrWithOutfirst);
		long answithoutlast=maximumNonAdjacentSum(arrWithOutLast);
		// Write your code here.
		return Math.max(answithoutfirst, answithoutlast);	

	}	
}