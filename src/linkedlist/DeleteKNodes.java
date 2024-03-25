package linkedlist;

import java.util.Scanner;

public class DeleteKNodes {
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
	public static Node<Integer> kReverse(Node<Integer> head, int k) {
		//Your code goes here
		Node<Integer> h=head;
		if(h==null || k<=1) {
			return head;
		}
		Node<Integer> prev=null;
		Node<Integer> curr=head;
		Node<Integer> next=null;
		Node<Integer> temp=head;
		int c=0;
		int nc=0;
		while(temp!=null) {
			nc++;
			temp=temp.next;
		}
		if(k==nc) {
			while(c<k && curr!=null) {
				next=curr.next;
				curr.next=prev;
				prev=curr;
				curr=next;
				c++;
			}
			return prev;
		}
		while(c<k && curr!=null) {
			next=curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
			c++;
		}
		h.next=kReverse(next,k);
		return prev;
		
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head=takeInputOptimise();
		Node<Integer> head1=kReverse(head, 2);
		printRec(head1);

	}

}
