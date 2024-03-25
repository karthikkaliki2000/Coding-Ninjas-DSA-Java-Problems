package linkedlist;

import java.util.Scanner;

public class LinkedListUse2 {
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
//    public static Node<Integer> reverse_I(Node<Integer> head){
//    	  if(head==null){
//              return head;
//          }
//    	Node<Integer> previous=null;
//        Node<Integer> curr=head;
//        Node<Integer> next=head.next;
//        while(next!=null) {
//        	Node<Integer> newNext=next.next;
//        	curr.next=previous;
//        	next.next=curr;
//        	previous=curr;
//        	curr=next;
//        	next=newNext;
//        	
//        }
//        return curr;
//	}
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node<Integer> head=takeInputOptimise();
	//	Node<Integer> head1=reverse_I(head);
		Node<Integer> mid=midPoint(head);
		System.out.println(mid.data);
		//printRec(head1);
           
	}

}
