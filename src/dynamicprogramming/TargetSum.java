package dynamicprogramming;


import java.util.* ;
import java.io.*; 
public class TargetSum {
   public static int targetSum(int n, int target, int[] arr) {
	    // Dp vector to store results
	    ArrayList < Map < Integer, Integer >> dp = new ArrayList<>(arr.length + 1);
	    for(int i = 0; i < arr.length+1; i++){
	    	dp.add(new HashMap<Integer, Integer>());
	    }

	    // Zero sized array having target as 0
	    dp.get(0).put(0, 1);

	    // Traversing the arr vector
	    for (int i = 0; i < arr.length; i++) {

	        // Traversing the unordered map of previous index
	        for (Map.Entry j: dp.get(i).entrySet()) {
					
	            // Putting the sums possible for current index
                int v1 = dp.get(i + 1).containsKey((int)j.getKey() + arr[i])?dp.get(i + 1).get((int)j.getKey() + arr[i]):0;
	            dp.get(i + 1).put((int)j.getKey() + arr[i], v1 + (int)j.getValue());
	            
                int v2 = dp.get(i + 1).containsKey((int)j.getKey() - arr[i])?dp.get(i + 1).get((int)j.getKey() - arr[i]):0;
                dp.get(i + 1).put((int)j.getKey() - arr[i], v2 + (int)j.getValue());
	        }
	    }

	    // Returning our answer
	    return (dp.get(arr.length).containsKey(target))?dp.get(arr.length).get(target):0;
    }
}