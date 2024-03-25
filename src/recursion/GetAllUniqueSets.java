package recursion;

import java.util.*;
public class GetAllUniqueSets {
    public static void printSubsets(int input[]) {
        // Sort the input array
        Arrays.sort(input);
        // Create a list to store subsets
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // Call the recursive function to generate subsets
        fetch(input, 0, result, new ArrayList<>());
        // Print the subsets
        for(ArrayList<Integer> al: result){
            for(int i=0;i<al.size();i++){
                System.out.print(al.get(i)+" ");
            }
            System.out.println();
        }
    }
    public static void fetch(int[] input, int index, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> ds){
        // Add the current subset to the result list
        result.add(new ArrayList<Integer>(ds));
        // Iterate through the input array from the given index
        for(int i = index;i < input.length;i++){
            // Check for duplicate elements
            // If the cur

if(i != index && input[i] == input[i-1]){
                continue;
            }
            // Add the current element to the subset
            ds.add(input[i]);
            // Recursively call fetch with the next index
            fetch(input, i+1, result, ds);
            // Remove the last element to backtrack
            ds.remove(ds.size()-1);
        }   
    }
}