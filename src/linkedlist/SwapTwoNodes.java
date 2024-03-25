package linkedlist;

import java.util.Scanner;

public class SwapTwoNodes {
	public static void printRec(Node<Integer> head) {
		if(head==null) {
			return;
		}
		System.out.println(head.data);
		printRec(head.next);
	}
	public static Node<Integer> takeInputOptimise(){
		Node<Integer> head=null;
		Node<Integer> tail=null;
		Scanner s=new Scanner(System.in);
		int data=s.nextInt();
		while(data!=-1) {
			Node<Integer> currentNode=new Node<>(data);
			if(head==null) {
				head=currentNode;
				tail=currentNode;
			}
			else {
				tail.next=currentNode;
				tail=tail.next;
			}
			data=s.nextInt();
		}
		return head;
		
	}
	public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
		//Your code goes here
		if(head==null) {
			return null;
		}
		if(i>j) {
			int t=j;
			j=i;
			i=t;
		}
	//	System.out.println(i+" "+j);
        
		Node<Integer> h=head;
		Node<Integer> t1=head;
		Node<Integer> t2=head;
        
		for(int k=0;k<i-1;k++) {
			t1=t1.next;
		}
		for(int l=0;l<j-1;l++) {
			t2=t2.next;
		}
		if(i==0) {
			
			Node<Integer> ht=t1.next;
			Node<Integer> kt=t1.next.next;
//			if(t2.next==null) {
//				kt=null;
//			}
//			else {
//				kt=t2.next.next;
//			}
		    t2.next=ht;
		    t1.next=null;
		    t2.next.next=kt;
			return h;
		}
        
		Node<Integer> t2ea=t2.next.next;
		Node<Integer> t1ea=t1.next.next;
		Node<Integer> t1nt=t1.next;
		if(j-i<=1) {
			Node<Integer> nt=t1.next;
			t1.next=t2.next;
			t2.next.next=nt;
			nt.next=t2ea;
			
		}
		else {
			t1.next=t2.next;
			t1.next.next=t1ea;
			t2.next=t1nt;
			t1nt.next=t2ea;
		}
		
	//	printRec(h);
		
		
//		System.out.println(t1.data);
//		System.out.println(t2.data);
		return h;
		
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head=takeInputOptimise();
		Node<Integer> head1=swapNodes(head, 0, 2);
		printRec(head1);

	}

}
