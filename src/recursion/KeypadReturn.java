package recursion;

import java.util.HashMap;

public class KeypadReturn {

	// Return a string array that contains all the possible strings
	public static String[] keypadHelper(int n,HashMap<Integer,String> map) {
		if(n==0) {
			String[] s=new String[1];
			s[0]="";
			return s;
		}
		int ld=n%10;
		String []so=keypadHelper(n/10,map);
		String o[]=new String[(map.get(ld).length())*so.length];
		int k=0;
		int slen=map.get(ld).length();
		for(int i=0;i<so.length;i++) {
			for(int j=0;j<map.get(ld).length();j++) {
				o[k++]=so[i]+String.valueOf(map.get(ld).charAt(j));
			}
			
		}
		
		return o;
	}
	public static String[] keypad(int n) {
		HashMap<Integer,String> map=new HashMap<>();
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		return keypadHelper(n,map);
		
		
	}

}
