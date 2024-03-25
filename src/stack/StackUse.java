package stack;

public class StackUse {

	public static void main(String[] args) throws StackEmptyException, StackFullException {
		// TODO Auto-generated method stub
		
//         StackUsingArray stack=new StackUsingArray();
//         stack.push(10);
//         System.out.println( stack.top());
//        System.out.println(stack.isEmpty());
//         System.out.println(stack.size());
//         System.out.println(stack.pop());
//         System.out.println(stack.size());
//         System.out.println(stack.isEmpty());
//         stack.top();
//         stack.push(20);
//         StackUsingArray stack1=new StackUsingArray(1);
//         stack1.push(10);
//         stack1.push(20);
//         stack1.push(30);
//         System.out.println(stack1.size());
//		StackUsingLL stack=new StackUsingLL();
//		stack.push(10);
//		stack.push(20);
//		stack.push(30);
//		stack.push(40);
//		System.out.println(stack.pop());
//		System.out.println(stack.size());
		StackUsing2Queues s=new StackUsing2Queues();
//		s.push(17);
//		s.push(23);
//		s.push(11);
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
//		System.out.println(s.pop());
	//	System.out.println(s.getSize());
		System.out.println(s.isEmpty());
		System.out.println(s.getSize());
		s.push(13);
		System.out.println(s.top());
		s.push(41);
	//	System.out.println(s.top());
		System.out.println(s.pop());
	//	System.out.println(s.top());
		System.out.println(s.isEmpty());
         
	}

}
