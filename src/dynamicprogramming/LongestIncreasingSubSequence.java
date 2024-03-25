package dynamicprogramming;


public class LongestIncreasingSubSequence {

	public static int longestIncreasingSubsequence(int arr[]) 
    {
    //     if(arr.length==0)
    //         return 1;
        int dp[]=new int[arr.length];
        dp[0]=1;

    //     for(int i=1;i<dp.length;i++){

    //         for(int j=i-1;j>=0;j--){
    //             if(arr[j]<arr[i] && dp[i]<dp[j]+1)
    //                 dp[i]=dp[j]+1;
    //            else
    //                dp[i]=Math.max(1,dp[i]);
    //     }}
    //     int max=dp[0];
    //     for(int i=1;i<dp.length;i++){
    //         if(dp[i]>max)
    //             max=dp[i];
    //     }
    //     return max;
    // }
    int ans=0;
    int pos=0;	
    for(int i=0;i<arr.length;i++){
        pos=find(0,ans,dp,arr[i]);
        dp[pos]=arr[i];
        if(ans==pos){
            ans++;
        }
    }
    return ans;

}
   public static int  find(int s,int e,int[] arr,int target){
        while(s<e){
            int mid = s+(e-s)/2;
            if(target > arr[mid]){
                s = mid+1;
            }else{
                e = mid;
            }
        }
        return s;
     }
}