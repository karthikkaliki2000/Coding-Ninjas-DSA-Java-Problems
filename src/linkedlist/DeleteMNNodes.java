package linkedlist;

import java.util.Scanner;

public class DeleteMNNodes {
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
	public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
		//Your code goes here
		if(M==0) {
			return null;
		}
		if(N==0) {
			return head;
		}
		Node<Integer> h=head;
		Node<Integer> ch=h;
		Node<Integer> dh=null;
		
		while(ch!=null) {
			for(int i=0;i<M-1 && ch!=null;i++) {
				ch=ch.next;
			}
			if(ch==null) {
				break;
			}
			dh=ch.next;
			for(int j=0;j<N && dh!=null;j++) {
				dh=dh.next;
			}
			ch.next=dh;
			ch=dh;
		}
		return h;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head=takeInputOptimise();
		Node<Integer> head1=skipMdeleteN(head, 2, 2);
		printRec(head1);

	}

}
