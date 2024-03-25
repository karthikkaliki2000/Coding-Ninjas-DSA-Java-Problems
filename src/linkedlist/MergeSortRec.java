package linkedlist;

import java.util.Scanner;

public class MergeSortRec {
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
	public static Node<Integer> midPoint(Node<Integer> head) {
        //Your code goes here
	  if(head==null) {
		  return head;
	  }
	  Node<Integer> s=head;
	  Node<Integer> f=head;
	  while(s.next!=null) {
		  if(f.next==null) {
			  break;
		  } 
		  if(f.next.next==null) {
			  break;
		  }
		  s=s.next;
		  f=f.next.next;
		 
	  }
	  return s;
	  
    }
	public static Node<Integer> merge2Sorted(Node<Integer> head1,Node<Integer> head2){
		if(head1==null) {
			return head2;
		}
		if(head2==null) {
			return head1;
		}
		Node<Integer> t1=head1;
		Node<Integer> t2=head2;
		Node<Integer> head=null;
		Node<Integer> tail=null;
		if(t1.data<t2.data) {
			head=t1;
			tail=t1;
			t1=t1.next;
		}
		else {
			head=t2;
			tail=t2;
			t2=t2.next;
		}
		while(t1!=null && t2!=null) {
			if(t1.data<t2.data) {
				tail.next=t1;
				tail=t1;
				
				t1=t1.next;
			}
			else {
				tail.next=t2;
	            tail=t2;
				t2=t2.next;
			}
		}
		if(t1!=null) {
			tail.next=t1;
			tail=t1;
		}
		if(t2!=null) {
			tail.next=t2;
			tail=t2;
		}
		return head;
		
	}
	public static Node<Integer> mergeSort(Node<Integer> head){
		Node<Integer> h=head;
		if(h==null || h.next==null) {
			return h;
		}
		Node<Integer> h1=head;
		Node<Integer> mid=midPoint(head);
		Node<Integer> head2=mergeSort(mid.next);
		mid.next=null;
		Node<Integer> head1=mergeSort(head);
		return merge2Sorted(head1,head2);
		
				
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head1=takeInputOptimise();
		Node<Integer> head=mergeSort(head1);
		printRec(head);

	}

}
