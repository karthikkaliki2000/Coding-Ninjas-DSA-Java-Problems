package recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abc";
		//permutation("",str);
		System.out.println(permutation1("",str));

	}

	private static void permutation(String p,String up) {
		// TODO Auto-generated method stub
		//String[] s=new String[0];
		if(up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char ch=up.charAt(0);
		for(int i=0;i<=p.length();i++) {
			String f=p.substring(0,i);
		    String s=p.substring(i,p.length());
		    permutation(f+ch+s,up.substring(1));
		}
		
		
	}
	private static ArrayList<String> permutation1(String p,String up) {
		// TODO Auto-generated method stub
		//String[] s=new String[0];
		List<String> l=new ArrayList();
		if(up.isEmpty()) {
			//System.out.println(p);
			l.add(p);
			return (ArrayList<String>) l;
		}
		char ch=up.charAt(0);
		for(int i=0;i<=p.length();i++) {
			String f=p.substring(0,i);
		    String s=p.substring(i,p.length());
		    ArrayList<String> ansbcalls= permutation1(f+ch+s,up.substring(1));
		    l.addAll(ansbcalls);
		}
		return (ArrayList<String>) l;
		
		
	}
	
	

}
