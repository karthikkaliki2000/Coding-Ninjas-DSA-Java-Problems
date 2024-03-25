package stack;

public class StackUsingArray {
	private int[] data;
	private int topind;
	public StackUsingArray(){
		data=new int[10];
		topind=-1;
	}
	public StackUsingArray(int i) {
		// TODO Auto-generated constructor stub
		data=new int[i];
		topind=-1;
	}
	public void push(int ele)  {
		// TODO Auto-generated method stub
		if(data.length-1==topind) {
			StackFullException e=new StackFullException();
			data=doubleCapacity(data);
			//System.out.println("doubled");
		}
		data[++topind]=ele;
		
	}
	private int[] doubleCapacity(int[] data2) {
		// TODO Auto-generated method stub
		int [] a=new int[2*data2.length];
		for(int i=0;i<data2.length;i++) {
			a[i]=data2[i];
		}
		return a;
		
	}
	public int top() throws StackEmptyException {
		// TODO Auto-generated method stub
		if(topind==-1) {
			StackEmptyException e=new StackEmptyException();
			throw e;
		}
		return data[topind];
		
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(topind==-1) {
			return true;
		}
		return false;
		
	}
	public int size() {
		// TODO Auto-generated method stub
		return topind+1;
		
	}
	public int pop() throws StackEmptyException {
		// TODO Auto-generated method stub
		if(topind==-1) {
			StackEmptyException e=new StackEmptyException();
			throw e;
		}
		int t=data[topind];
		data[topind]=0;
		topind--;
		return t;
		
	}
	
}
