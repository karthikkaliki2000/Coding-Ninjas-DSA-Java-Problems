package stack;

//import linkedlist.Node;
class Node<T> {
	   T data;
	   Node<T> next;
	   public Node(T data) {
		   this.data=data;
	   }
	}

public class StackUsingLL<T> {
	private Node<T> head;
	private int size;
    public StackUsingLL() {
    	head=null;
    	size=0;
    }
    public void push(T ele) {
    	Node<T> newhead=new Node(ele);
    	newhead.next=head;
		head=newhead;
    	size++;
    }
    public T pop() throws StackEmptyException {
    	if(head==null) {
    		throw new StackEmptyException();
    	}
    	T d= head.data;
    	head=head.next;
    	size--;
    	return d;
    }
    public boolean isEmpty() {
    	return size==0;
    }
    public T top() throws StackEmptyException {
    	if(head==null) {
    		throw new StackEmptyException();
    	}
    	return head.data;
    }
    public int size() {
    	return size;
    }
}
