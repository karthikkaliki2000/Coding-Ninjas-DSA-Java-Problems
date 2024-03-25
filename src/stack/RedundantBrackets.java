package stack;

import java.util.Scanner;
import java.util.Stack;

public class RedundantBrackets {
	public static boolean checkRedundantBrackets(String expression) {
		//Your code goes here
		Stack s=new Stack();
		for(int i=0;i<expression.length();i++) {
			if(expression.charAt(i)!=')') {
				s.add(expression.charAt(i));
			}
			else {
				int c=0;
				while((char)s.peek()!='(') {
					c++;
					s.pop();
				}
				s.pop();
				if(c<=1) {
					return true;
				}
				else {
					if(s.isEmpty()) {
						return false;
					}
					else {
						c=0;
						continue;
					}
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		String str=s.next();
		System.out.println(checkRedundantBrackets(str));
		
	}

}
