package linkedlist;

import java.util.Scanner;

public class LinkedListUse {
	/*
	 * public static Node<Integer> createLinkedList(){ Node<Integer> n1=new
	 * Node<>(10); Node<Integer> n2=new Node<>(20); Node<Integer> n3=new Node<>(30);
	 * Node<Integer> n4=new Node<>(40); n1.next=n2; n2.next=n3; n3.next=n4;
	 * n4.next=null; return n1; }
	 */
	public static Node<Integer> takeInputOptimise() {
		Node<Integer> head = null;
		Node<Integer> tail = null;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		while (data != -1) {
			Node<Integer> currentNode = new Node<>(data);
			if (head == null) {
				head = currentNode;
				tail = currentNode;
			} else {
				tail.next = currentNode;
				tail = tail.next;
			}
			data = s.nextInt();
		}
		return head;

	}

	/*
	 * public static Node<Integer> takeInput(){ Node<Integer> head=null; Scanner
	 * s=new Scanner(System.in);
	 * 
	 * int data=s.nextInt();
	 * 
	 * while(data!=-1) { Node<Integer> currentNode=new Node<>(data); if(head==null)
	 * { head=currentNode; } else { Node<Integer> tail=head; while(tail.next!=null)
	 * { tail=tail.next; } tail.next=currentNode; } data=s.nextInt(); } return head;
	 * }
	 */
	/*
	 * public static void print(Node head) { Node n=head; while(n!=null) {
	 * System.out.println(n.data); n=n.next; } // while(head!=null) { //
	 * System.out.println(head.data); // head=head.next; // } }
	 */
//	public static Node<Integer> insert(Node<Integer> head, int pos, int data){
//		//Your code goes here
//		  if(pos<0){
//				pos=1;
//			}
//				Node<Integer> newNode=new Node(data);
//			
//			if(pos==0) {
//				newNode.next=head;
//				return newNode;
//			}
//			else {
//				Node<Integer> h=head;
//					Node<Integer> n=head;
//				int k=1;
//				while(h.next!=null) {
//					if(pos-1==k-1) {
//						Node<Integer> t=h.next;
//						h.next=newNode;
//						newNode.next=t;
//						break;
//					}
//					
//				   h=h.next;
//				   k++;
//				}
//				int c=0;
//			while(n.next!=null){
//	         
//			  n=n.next;
//			   c++;
//			}
//		//	System.out.println(c+"cpos"+pos);
//			if(c+1==pos){
//				
//				n.next=newNode;
//			}
//				return head;
//		}
//		
//	}

	/*
	 * public static Node<Integer> deleteNode( Node<Integer> head, int pos) { //
	 * Write your code here. Node<Integer> h=head; int c=0; while(h.next!=null) {
	 * c++; h=h.next; } if(pos>=c) { return head; } if(pos==0) { Node<Integer>
	 * newHead=head.next; head.next=null; return newHead; } else { Node<Integer>
	 * n=head; int k=0; while(n!=null) { if(pos-1==k) { n.next=n.next.next; break; }
	 * n=n.next; k++; } return head; } }
	 */
//	public static int findNode(Node<Integer> head, int n) {
//		// Write your code here.
//		Node<Integer> h=head;
//		int i=0;
//		while(h.next!=null) {
//			if(h.data==n) {
//				return i;
//			}
//			i++;
//			h=h.next;
//		}
//		return -1;
//		
//		
//	}
	/*
	 * public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {
	 * //Your code goes here if(head==null){ return null; } if(n==0){ return head; }
	 * int c=1; Node<Integer> h=head; Node<Integer> h1=head; Node<Integer> h2=head;
	 * Node<Integer> newHead = null; while(h.next!=null) { c++; h=h.next; } int
	 * p=c-n; //System.out.println(p); int k=1; while(h1.next!=null) { if(k==p) {
	 * newHead=h1.next; h1.next=null; h.next=h2; break; } h1=h1.next; k++; } return
	 * newHead;
	 * 
	 * }
	 */
//	public static Node<Integer> removeDuplicates(Node<Integer> head) {
//		//Your code goes here
//		if(head==null) {
//			return null;
//		}
//		Node<Integer> h=head;
//		while(h.next!=null) {
//			//System.out.println(h.data+"J"+h.next.data);
//			if(h.data.equals(h.next.data)) {
//			//	System.out.println("HI");
//				h.next=h.next.next;
//			}
//			else {
//				h=h.next;
//			}
//		}
//		return head;
//	}
	
 public static void printReverse(Node<Integer> root) { //Your code goes here
	  if(root==null){ return; }
	  Node<Integer> c=root; Node<Integer> n=root.next;
	  Node<Integer> p=null;
	  while(n!=null) {
      Node<Integer> nn=n.next;
      n.next=c;
	  c.next=p;
	  p=c; 
	  c=n; 
	  n=nn; 
	  }
	  
	  while(c.next!=null) 
	  { 
		  System.out.print(c.data+" ");
		  c=c.next; 
		  }
	  System.out.print(c.data); }
	 
	/*
	 * public static String Reverse(Node<Integer> root) { //Your code goes here
	 * if(root==null){ return null; } Node<Integer> c=root; Node<Integer>
	 * n=root.next; Node<Integer> p=null; while(n!=null) { Node<Integer> nn=n.next;
	 * n.next=c; c.next=p; p=c; c=n; n=nn; } // ArrayList<Integer> li=new
	 * ArrayList<>(); String s=""; while(c.next!=null) { // lli.add(c.data);
	 * s+=c.data; c=c.next; } //li.add(c.data); s+=c.data; return s; }
	 */
	public static void printRec(Node<Integer> head) {
		if (head == null) {
			return;
		}
		System.out.println(head.data);
		printRec(head.next);
	}

	/*
	 * public static boolean isPalindrome(Node<Integer> head) { //Your code goes
	 * here if(head==null){ return true; } Node<Integer> h=head; String s1="";
	 * while(h.next!=null){ s1+=h.data; h=h.next; } s1+=h.data; String
	 * s2=Reverse(head); // System.out.println(s1+" "+s2); return s1.equals(s2);
	 * 
	 * }
	 */
	/*
	 * public static Node<Integer> insertRec(Node<Integer> head,int data,int pos) {
	 * if(head==null && pos>0) { return head; } if(pos==0) { Node<Integer>
	 * newNode=new Node(data); newNode.next=head; return newNode; } else {
	 * //Node<Integer> n= insertRec(head.next,data,pos-1);
	 * head.next=insertRec(head.next,data,pos-1); return head; } }
	 */
//	public static Node<Integer> deleteRec(Node<Integer> head,int pos){
//		if(head==null) {
//			return head;
//		}
//		if(pos==0) {
//			return head.next;
//		}
//		else {
//			head.next=deleteRec(head.next,pos-1);
//			return head;
//		}
//	}
//	public static Node<Integer> reverseLLRec(Node<Integer> head){
//		if(head==null) {
//			return head;
//		}
//		if(head.next==null) {
//			return head;
//		}
//		else {
//			Node<Integer> reversedHead=reverseLLRec(head.next);
//			Node<Integer> h=reversedHead;
//			while(h.next!=null) {
//				h=h.next;
//			}
//			h.next=head;
//			head.next=null;
//			return reversedHead;
//		}
//	}
//	public static DoubleNode reverseRecBetter(Node<Integer> head) {
//		DoubleNode d;
//		if(head.next==null || head==null) {
//			d=new DoubleNode();
//			d.head=head;
//			d.tail=head;
//			return d;
//		}
//		else {
//			DoubleNode sd=reverseRecBetter(head.next);
//			sd.tail.next=head;
//			head.next=null;
//			d=new DoubleNode();
//			d.head=sd.head;
//		    d.tail=head;
//		    return d;
//		    
//		}
//	}
	public static Node<Integer> reverseLLBESTRec(Node<Integer> head) {
		if (head == null) {
			return head;
		}
		if (head.next == null) {
			return head;
		} else {
			Node<Integer> reversedHead = reverseLLBESTRec(head.next);
//		Node<Integer> h=reversedHead;
//		while(h.next!=null) {
//			h=h.next;
//		}
//		h.next=head;
			Node<Integer> tail = head.next;
			tail.next = head;
			head.next = null;
			return reversedHead;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Node<Integer> n1=new Node<>(10);
		// System.out.println(n1.data);
		// Node<Integer> head=takeInput();
		Node<Integer> head1 = takeInputOptimise();
//		print(head1);
//		System.out.println(head.data);
//		System.out.println(head.next);
//		Node<Integer> newhead=insert(head1,2,10);
//		print(newhead);
//		Node<Integer> newHead1=deleteNode(newhead,0);
//		print(newHead1);
//		int index=findNode(head1,0);
//		System.out.println(index);
//		Node<Integer> head2=appendLastNToFirst(head1,4);
//		print(head2);
//		Node<Integer> head2=removeDuplicates(head1);
//		print(head2);
		// printReverse(head1);
		// System.out.println(isPalindrome(head1));
		// printRec(head1);
		// Node<Integer> head2=insertRec(null,20,0);
		// Node<Integer> head2=deleteRec(head1,0);
		// Node<Integer> head2=reverseLLRec(head1);
//		DoubleNode ans=reverseRecBetter(head1);
//		Node<Integer> head2=ans.head;
		Node<Integer> head2 = reverseLLBESTRec(head1);
		printRec(head2);
	}

}
