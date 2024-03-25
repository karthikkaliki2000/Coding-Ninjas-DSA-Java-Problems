package recursion;

public class RemoveA {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abaaccad";
		//System.out.println(remove(str));
		String str1="Hi How are you Hello Hi Hello Hi";
		System.out.println(removeStr(str1,"Hi"));

	}

	private static String remove(String str) {
		// TODO Auto-generated method stub
		String s="";
		if(str.length()==0) {
			return s;
		}
		String ansfrombelowcalls;
		if(str.charAt(0)=='a') {
			ansfrombelowcalls=""+remove(str.substring(1));
		}
		else {
			ansfrombelowcalls=str.charAt(0)+remove(str.substring(1));
		}
		
		return ansfrombelowcalls;
	}
	private static String removeStr(String str,String r) {
		// TODO Auto-generated method stub
		
		if(str.length()==0) {
			return "";
		}
		String ansfrombelowcalls;
		if(str.startsWith(r)) {
			ansfrombelowcalls=""+removeStr(str.substring(r.length()),r);
		}
		else {
			ansfrombelowcalls=str.charAt(0)+removeStr(str.substring(1),r);
		}
		
		return ansfrombelowcalls;
	}

}
