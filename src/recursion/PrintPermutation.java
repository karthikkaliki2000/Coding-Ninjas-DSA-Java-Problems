package recursion;

public class PrintPermutation {

	public static void permutations(String input){
		// Write your code here
        permutationsHelper(input,"");

	}
    
    private static void permutationsHelper(String input, String output)
    {
        if (input.length()==0)
            System.out.println(output);
        
        for (int i=0;i<input.length();i++)
            permutationsHelper(input.substring(0,i)+input.substring(i+1), output+input.charAt(i));
    }
}
