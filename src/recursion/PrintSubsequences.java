package recursion;

public class PrintSubsequences {
    public static void printSubSeq(String s,String[] sarr) {
    	if(s.length()==0) {
    		for(String e:sarr) {
    			System.out.print(e+" ");
    		}
    		return;
    	}
    	String resArr[]=new String[2*sarr.length];
    	for(int i=0;i<sarr.length;i++) {
    		resArr[i]=sarr[i];
    	}
    	int k=0;
    	for(int i=sarr.length;i<resArr.length;i++) {
    		resArr[i]=sarr[k++]+s.charAt(0);
    	}
    	printSubSeq(s.substring(1),resArr);
    	
    }
    public static void printSubSeqOptimised(String s,String res) {
    	if(s.length()==0) {
    		System.out.print(res+" ");
    		return;
    	}
    	printSubSeqOptimised(s.substring(1),res);
    	printSubSeqOptimised(s.substring(1),res+s.charAt(0));
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []s=new String[1];
		s[0]="";
	//	printSubSeq("abc",s);
		printSubSeqOptimised("abc","");
	}

}
