package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
	public static int[] stockSpan(int[] price) {
		//Your code goes here
		int [] res=new int[price.length];
		
		for(int i=0;i<price.length;i++) {
			Stack s=new Stack();
			int c=1;
			for(int j=0;j<i;j++) {
				s.add(price[j]);
			}
			while(!s.isEmpty()) {
				if(price[i]>(int)s.peek()) {
					c++;
					
				}
				else if(price[i]<=(int)s.peek()){
					break;
				}
				
				s.pop();
			}
			res[i]=c;
			c=0;
		}
		return res;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10, 20 ,10 ,20 ,10 ,20};
		int res[]=new int[arr.length];
		res=stockSpan(arr);
		System.out.println(Arrays.toString(res));

	}

}
