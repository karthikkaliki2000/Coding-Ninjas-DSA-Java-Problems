package recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class SubSetStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abc";
		//subStrings("",str);
	//	System.out.println(subStrings1("","abc"));
		//System.out.println(subStringsAscii("",str));
		//System.out.println(subStrings2("","1123"));
		ArrayList li=subStrings2("","1123");
		String[] s=new String[li.size()];
		for(int i=0;i<s.length;i++) {
			s[i]=(String) li.get(i);
		}
		for(String se:s) {
			
		}

	}

	private static void subStrings(String processedString, String unProcessedString) {
		// TODO Auto-generated method stub
		
		if(unProcessedString=="") {
			if(processedString!="") {
				System.out.println(processedString);
			}
			return;
		}
		subStrings(processedString+unProcessedString.charAt(0),unProcessedString.substring(1));
		subStrings(processedString,unProcessedString.substring(1));
		
	}
	private static ArrayList subStrings1(String processedString, String unProcessedString) {
		// TODO Auto-generated method stub
		
		if(unProcessedString=="") {
			//System.out.println(processedString);
			ArrayList l=new ArrayList();
			if(processedString!="") {
				l.add(processedString);
			}
			return l;
		}
		ArrayList list1=subStrings1(processedString+unProcessedString.charAt(0),unProcessedString.substring(1));
		ArrayList list2=subStrings1(processedString,unProcessedString.substring(1));
		list1.addAll(list2);
		return list1;
	}
	private static ArrayList subStringsAscii(String processedString, String unProcessedString) {
		// TODO Auto-generated method stub
		
		if(unProcessedString=="") {
			//System.out.println(processedString);
			ArrayList l=new ArrayList();
			if(processedString!="") {
				l.add(processedString);
			}
			return l;
		}
		ArrayList list1=subStringsAscii(processedString+unProcessedString.charAt(0),unProcessedString.substring(1));
		ArrayList list2=subStringsAscii(processedString,unProcessedString.substring(1));
		ArrayList list3=subStringsAscii(processedString+(unProcessedString.charAt(0)+0),unProcessedString.substring(1));
		list1.addAll(list2);
		list1.addAll(list3);
		return list1;
	}
	private static ArrayList subStrings2(String processedString, String unProcessedString) {
		// TODO Auto-generated method stub
		
		if(unProcessedString=="") {
			//System.out.println(processedString);
			ArrayList l=new ArrayList();
			if(processedString!="") {
				l.add(processedString);
			}
			return l;
		}
		char c=unProcessedString.charAt(0);
//		int i=c+48;
//		char ch=(char)i;
		ArrayList list1=subStrings2(processedString+c,unProcessedString.substring(1));
		ArrayList list2=subStrings2(processedString,unProcessedString.substring(1));
		list1.addAll(list2);
		return list1;
	}

}
