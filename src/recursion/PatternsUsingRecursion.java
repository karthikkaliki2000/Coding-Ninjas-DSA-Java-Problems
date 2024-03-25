package recursion;

public class PatternsUsingRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//traingle(4,4);
		traingle2(4,4);

	}
	public static void traingle(int r,int c) {
		if(r==0) {
			return;
		}
		if(c>0) {
			System.out.print("*");
			traingle(r,c-1);
		
		}
		else {
			System.out.println("");
			traingle(r-1,c=r-1);	
			
		}
		
	}
	public static void traingle2(int r,int c) {
		if(r==0) {
			return;
		}
		if(c>0) {
			
			traingle2(r,c-1);
			System.out.print("*");
		}
		else {
			traingle2(r-1,c=r-1);
			System.out.println("");
			
		}
		
		
	}
	

}
