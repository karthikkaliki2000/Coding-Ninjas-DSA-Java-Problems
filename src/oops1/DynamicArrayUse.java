package oops1;
class DynamicArray{
	private int data[];
	private int data1[];
	private int nexti;
	public DynamicArray() {
		data=new int[5];
		nexti=0;
	}
	public int size() {
		return nexti;
	}
	public boolean isEmpty() {
		return nexti==0;
	}
	public int get(int ind) {
		if(ind>=nexti) {
			return 0;
		}
		return data[ind];
	}
	public void add(int ele) {
		if(nexti==data.length) {
			doubleCapacity();
		}
		data[nexti]=ele;
		nexti++;
		
	}
	private void doubleCapacity() {
		// TODO Auto-generated method stub
		int []temp=data;
		data=new int[2*temp.length];
		for(int i=0;i<temp.length;i++) {
			data[i]=temp[i];
		}
		
	}
	public void set(int ind,int ele) {
		if(ind>=nexti) {
			return;
		}
		data[ind]=ele;
	}
	public int remove() {
		if(this.size()==0) {
			return -1;
		}
		int r=data[nexti-1];
		data[nexti-1]=0;
		nexti--;
		return r;
	}
//int l=0;
//public static int[] insertX(int n, int arr[],
//              int x, int pos)
//{
//int i;
//
//// create a new array of size n+1
//
//int newarr[] = new int[n + 1];

// insert the elements from
// the old array into the new array
// insert all elements till pos
// then insert x at pos
// then insert rest of the elements
//for (i = 0; i < n + 1; i++) {
//if (i < pos - 1)
//newarr[i] = arr[i];
//else if (i == pos - 1)
//newarr[i] = x;
//else
//newarr[i] = arr[i - 1];
//}
//return newarr;
//}
//	public void add(int ind,int ele) {
//		if(ind>nexti ) {
//			return;
//		}
//int temp[]=data;
//		
//		if(this.isEmpty()) {
//			add(ele);
//		}
//		else {
//		    
//			if(nexti==data.length) {
//				doubleCapacity();
//			}
//			l=data[this.size()-1];
//			data=insertX(data.length,data,ele,ind+1);
//			//int t=data[data.length-1];
//			add(l);
//			//nexti++;
//		}
//	}
}

public class DynamicArrayUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicArray d=new DynamicArray();
		System.out.println(d.size());
		for(int i=0;i<100;i++) {
			d.add(100+i);
		}
		System.out.println(d.size());
		for(int i=0;i<d.size();i++) {
			System.out.print(d.get(i)+" ");
		}
		System.out.println();
		d.set(2,5);
		System.out.println(d.get(2));
		while(!d.isEmpty()) {
			d.remove();
		}
		System.out.println(d.size());


//	
//		d.add(0,1);
//		d.add(0,2);
//		d.add(0,3);
//		d.add(0,4);
//		d.add(0,5);
//		d.add(0,6);
//		d.add(1,7);
//		d.add(1,8);
////	d.add(7,8000000);
//		d.add(0,2);
//		d.add(0,2);
//		d.add(0,2);
//		
//		
//		for(int i=0;i<d.size();i++) {
//			System.out.print(d.get(i)+" ");
//		}
		
	}

}
