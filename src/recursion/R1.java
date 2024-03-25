package recursion;

public class R1 {
    static int rn,c=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		pnto1(5);
//		p1ton(5);
//		pnto11ton(5);
		
		//System.out.println(prod(5));
	//	System.out.println(prodDigits(125));
		//System.out.println();
//		revNum1(12345);
//		System.out.println(rn);
//		System.out.println(revNum2(12345));
		//System.out.println();
	
		System.out.println(	countZeroes(100001));
	}
	private static int countZeroes(int n) {
		// TODO Auto-generated method stub
		return helper1(n,0);
		
	}
	private static int helper1(int n, int c) {
		// TODO Auto-generated method stub
		if(n==0) {
			return c;
		}
		if(n%10==0) {
			return helper1(n/10,c+1);
		}
		return helper1(n/10,c);
	}
	private static void revNum1(int n) {
		// TODO Auto-generated method stub
		if(n==0) {
			return;
		}
		int rem=n%10;
		
	   rn=rn*10+rem;
	   revNum1(n/10);
		
		
	}
	private static int revNum2(int n) {
		// TODO Auto-generated method stub
		int digits=(int)Math.log10(n)+1;
		
		return helper(n,digits);//helper function helps us to add another variable as we want
		                        //in the current function
		
		
	}
	private static int helper(int n, int digits) {
		// TODO Auto-generated method stub
		if(n%10==n) {
			return n;
		}
		int rem=n%10;
		return rem*(int)(Math.pow(10,digits-1))+helper(n/10,digits-1);
	}
	private static int prodDigits(int n) {
		// TODO Auto-generated method stub
		if(n%10==n) {
			return n;
		}
		return (n%10)*prodDigits(n/10);
		
	}
	static void pnto1(int n) {
		if(n==0) {
			return;
		}
		System.out.println(n);
		pnto1(n-1);
		
	}
	static void p1ton(int n) {
		if(n==0) {
			return;
		}
		p1ton(n-1);
		System.out.println(n);
		
	}
	static void pnto11ton(int n) {
		if(n==0) {
			return;
		}
		
		System.out.println(n);
		 pnto11ton(n-1);
		 System.out.println(n);
		 
		
	}
	static int prod(int n) {
		if(n==1) {
			return 1;
		}
		return n*prod(n-1);
	}

}
