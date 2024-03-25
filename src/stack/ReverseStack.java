package stack;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStack {
	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		//Your code goes here
		if(input.size()<=1) {
			return;
		}
		int t=input.pop();
		while(!input.isEmpty()) {
			extra.add(input.pop());
		}
		reverseStack(input,extra);
		
		input.add(t);
		for(int i=0;i<extra.size();i++) {
			input.add(extra.get(i));
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack=new Stack();
		Scanner s=new Scanner(System.in);
		while(true) {
			int n=s.nextInt();
			if(n==-1) {
				break;
			}
			stack.add(n);
		}
		Stack helper=new Stack();
		
		reverseStack(stack,helper);
		for(int i=0;i<stack.size();i++) {
			System.out.println(stack.get(i));
		}
	}

}
