package recursion;

public class SubSequenceStrings {
    public static String[] subSequence(String s) {
    	if(s.length()==0) {
    		String[] sarr=new String[1];
    		sarr[0]="";
    		return sarr;
    	}
    	String[] so=subSequence(s.substring(1));
    	String[] o=new String[2*so.length];
    	for(int i=0;i<so.length;i++) {
    		o[i]=so[i];
    	}
    	int k=0;
    	for(int i=so.length;i<o.length;i++) {
    		o[i]=s.charAt(0)+so[k++];
    	}
    	return o;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         String[] res=subSequence("abc");
         for(String s:res) {
        	 System.out.print(s+" ");
         }
	}

}
