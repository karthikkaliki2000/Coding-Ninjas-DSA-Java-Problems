package tries;

import java.util.ArrayList;

public class PatternMatching {
	public static boolean patternMatching(ArrayList<String> vect, String pattern) {
        // Write your code here
		Trie t=new Trie();
		
		for(int i=0;i<vect.size();i++) {
			for(int j=0;j<vect.get(i).length();j++) {
				t.add(vect.get(i).substring(j));
				t.add(vect.get(i).substring(0, j));
			}
		}
//		System.out.println(t.countWords());
		
		return t.search(pattern);
		
	}
	public static void main(String[] args) {
		ArrayList<String> arr=new ArrayList<String>();
		arr.add("ABC");
		arr.add("DEF");
		arr.add("GHI");
		arr.add("CBA");
		//System.out.println(arr);
		System.out.println(patternMatching(arr,"DE"));
	}
}
