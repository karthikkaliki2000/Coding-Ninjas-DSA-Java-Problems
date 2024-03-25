package stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class MinimumBracketReversal {
	public static int countBracketReversals(String input) {
		//Your code goes here
		int c=0;
		Stack s=new Stack();
         if(input.length()%2==0){
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)=='{') {
					s.add(input.charAt(i));
				}
				else {
					if(s.isEmpty()) {
						s.add(input.charAt(i));
					}
					else {
						if((char)s.peek()=='}') {
							c++;
							s.pop();
						}
						else {
							s.push(input.charAt(i));
						}
//						c++;
//						s.pop();
					}
				}
			}
			
				while(!s.isEmpty()) {
					char c1=(char)s.pop();
					char c2=(char)s.pop();
					if(c1==c2) {
						c++;
					}
					else {
						c+=2;
					}
					//System.out.println(s.pop());
				}
			
		}
		else{
			return -1;
		}
         return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		String str=s.next();
		System.out.println(countBracketReversals(str));
		

	}

}
