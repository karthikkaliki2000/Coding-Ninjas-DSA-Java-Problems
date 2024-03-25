package dynamicprogramming;

public class MinimumElements {

//    private static int min(int ind, int coins[], int tar, int dp[][]) {
//         if (ind == 0) {
//             if (tar % coins[0] == 0) return tar / coins[0];
//             else return (int) 1e9;
//         }
//         if (dp[ind][tar] != 0) return dp[ind][tar];
//         int notTake = 0 + min(ind - 1, coins, tar, dp);
//         int Take = Integer.MAX_VALUE;
//         if (coins[ind] <= tar) Take = 1 + min(ind, coins, tar - coins[ind], dp);
//         return dp[ind][tar] = Math.min(Take, notTake);
//     }

//     public static int minimumElements(int num[], int x) {
//         // Write your code here..
//         int[][] dp = new int[num.length][x + 1];
//         int ans = min(num.length - 1, num, x, dp);
//         if (ans >= (int) 1e9) return -1;
//         return ans;
//     }


    // public static int minimumElements(int num[], int x) {
    //     // Write your code here..
    //     int[][] dp = new int[num.length][x + 1];
    //      for (int t = 0; t <= x; t++) {
    //     if (t % num[0] == 0) {
    //         dp[0][t] = t / num[0];
    //     } else {
    //         dp[0][t] = (int) 1e9;
    //     }
    //     }

    //     for(int i = 1 ; i<num.length; i++){
    //         for(int tar = 0 ; tar<=x; tar++){
    //            int notTake = 0 + dp[i-1][tar];
    //            int Take = Integer.MAX_VALUE;
    //            if (num[i] <= tar) Take = 1 + dp[i][tar-num[i]];
    //            dp[i][tar] = Math.min(Take, notTake);
    //         }
    //     }

    //      int ans = dp[num.length-1][x];
    //      if (ans >= (int) 1e9) return -1;
    //      return ans;
    // }

    public static int minimumElements(int num[], int x) {
    int[] prev = new int[x + 1];
    int[] curr = new int[x + 1];

    for (int t = 0; t <= x; t++) {
        if (t % num[0] == 0) {
            prev[t] = t / num[0];
        } else {
            prev[t] = (int) 1e9;
        }
    }

    for (int i = 1; i < num.length; i++) {
        for (int tar = 0; tar <= x; tar++) {
            int notTake = prev[tar];
            int take = (num[i] <= tar) ? 1 + curr[tar - num[i]] : Integer.MAX_VALUE;
            curr[tar] = Math.min(notTake, take);
        }
        
        // Swap references of prev and curr arrays
        int[] temp = prev;
        prev = curr;
        curr = temp;
    }

    int ans = prev[x]; // Use prev array since it contains the final results
    if (ans >= (int) 1e9) return -1;
    return ans;
}

}