package recursion;

import java.util.HashMap;

public class KeypadPrint {
	public static void keypadPrint(int n,HashMap<Integer,String> map,String[] res) {
		if(n==0) {
			for(String s:res) {
				System.out.print(s+" ");
			}
			return;
		}
		int lastN=n%10;
		int newN=n/10;
		String o[]=new String[(map.get(lastN).length())*res.length];
		int k=0;
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<map.get(lastN).length();j++) {
				o[k++]=res[i]+String.valueOf(map.get(lastN).charAt(j));
			}
			
		}
		keypadPrint(newN,map,o);
	}
	
	public static void keypadPrintOptimised(int n,HashMap<Integer,String> map,String res) {
		if(n==0) {
			System.out.println(res);
			return;
		}
		int lastN=n%10;
		int newN=n/10;
		String options=map.get(lastN);
		for(int i=0;i<options.length();i++) {
			keypadPrintOptimised(newN,map,res+map.get(lastN).charAt(i));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,String> map=new HashMap<>();
		String[] res=new String[1];
		res[0]="";
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		//keypadPrint(23,map,res);
		keypadPrintOptimised(23,map,"");

	}

}
