package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {
	 public static boolean isBalanced(String expression) {
	        //Your code goes here
	       Stack s=new Stack();
	       Map m=new HashMap();
	       m.put('}', '{');
	       m.put(']', '[');
	       m.put(')', '(');
	        for(int i=0;i<expression.length();i++) {
	        	if(expression.charAt(i)=='{' ||  expression.charAt(i)=='[' || expression.charAt(i)=='(') {
	        		s.push(expression.charAt(i));
	        	}
	        }
	        if(expression.charAt(0)=='}' || expression.charAt(0)==']' || expression.charAt(0)==')'){
                return false;
            }
	        for(int i=0;i<expression.length();i++) {
	        	if(expression.charAt(i)=='}' ||  expression.charAt(i)==']' || expression.charAt(i)==')') {
	        		//System.out.println((char)s.peek()+" "+expression.charAt(i));
	        		if(!s.isEmpty()) {
	        			if(m.get(expression.charAt(i))==s.peek()) {
		        			s.pop();
		        		}
	        		}
	        		else {
	        			return false;
	        		}
	        		
	        	}
	        }
	       // System.out.println(s);
	        return s.isEmpty();
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr = new Scanner(System.in);
        String expression = sr.next();
        System.out.println(isBalanced(expression));
	}

}
