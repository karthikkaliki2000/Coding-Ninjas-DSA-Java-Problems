package recursion;

public class PrintFactorialWithOutReturn {
    public static void fact(int n,int ans) {
    	if(n==0) {
    		System.out.println(ans);
    		return;
    	}
    	fact(n-1,n*ans);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           fact(5,1);
	}

}
