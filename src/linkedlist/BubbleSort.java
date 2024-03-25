package linkedlist;

import java.util.Scanner;

public class BubbleSort {
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
	public static Node<Integer> bubbleSort(Node<Integer> head) {
		//Your code goes here
		if(head==null) {
			return head;
		}
		for(int i=0;i<length(head);i++) {
			Node<Integer> c=head;
			Node<Integer> p=null;
			while(c.next!=null) {
				if(c.data>c.next.data) {
					if(p!=null) {
						Node<Integer> t=c.next.next;
						c.next.next=c;
						p.next=c.next;
						c.next=t;
						p=p.next;
					}
					else {
						head=c.next;
						c.next=head.next;
						head.next=c;
						p=head;
						
					}
				}
				else {
					p=c;
					c=c.next;
				}
			}
		}
		
		return head;
		
		
	}
	private static int length(Node<Integer> head) {
		// TODO Auto-generated method stub
		if(head==null) {
			return 0;
		}
		Node<Integer> h=head;
		return 1+length(h.next);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head=takeInputOptimise();
		Node<Integer> head1=bubbleSort(head);
		printRec(head1);

	}

}
