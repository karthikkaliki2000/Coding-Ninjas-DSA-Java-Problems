package linkedlist;

import java.util.Scanner;

public class OddEven {
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
	public static Node<Integer> evenAfterOdd(Node<Integer> head) {
		//Your code goes here
		if(head==null) {
			return head;
		}
		Node<Integer> h=head;
		Node<Integer> oh=null;
		Node<Integer> ot=null;
		Node<Integer> eh=null;
		Node<Integer> et=null;
		while(h!=null) {
			if(h.data%2!=0) {
				if(oh==null) {
					oh=h;
					ot=h;
					
				}
				else {
					ot.next=h;
					ot=ot.next;
					
				}
			}
			else {
				if(eh==null) {
					eh=h;
					et=h;
					
				}
				else {
					et.next=h;
					et=et.next;
					
				}
			}
			h=h.next;
		}
		
		if(oh==null ) {
			return eh;
		}
		ot.next=eh;
		if(et!=null) {
			et.next=null;
		}
		
		return oh;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head=takeInputOptimise();
		Node<Integer> head1=evenAfterOdd(head);
		printRec(head1);

	}

}
