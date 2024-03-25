package recursion;

public class Keypad1 {

	public static String helper(int digit){
		 String Options[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		 return Options[digit];
	}

		//Recursive method to generate all possible combinations of letters from a given number
	public static String[] keypad(int n){
		// Base case: if the number is 0, return an array with an empty string
		if(n==0){
			String[] output = new String[1];
			output[0] = "";
			return output;
		}
		// Recursively get the combinations for the smaller part of the number
		String[] smallOutput = keypad(n/10);
		// Get the last digit of the number
		int lastDigit = n%10;
		// Get the possible characters for the last digit
		String lastDigitOptions = helper(lastDigit);
		String[] output = new String[smallOutput.length*lastDigitOptions.length()];
		int k = 0;
		// Iterate through the combinations and make the final output
		for(int i = 0; i < smallOutput.length; i++) {
			for(int j = 0; j < lastDigitOptions.length(); j++) {
				output[k] = smallOutput[i] + lastDigitOptions.charAt(j);
				k++;
			}
		}
		// Return the final array of combinations
		return output;

	

	}
	public static void main(String[] args) {
		String[] res=keypad(23);
		for(String s:res) {
			System.out.println(s);
		}
	}
	
	
}
