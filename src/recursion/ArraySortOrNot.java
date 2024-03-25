package recursion;

public class ArraySortOrNot {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,3,5,7,9,0};
		//System.out.println(arraySortOrNot(arr));
		System.out.println(arraySortOrNot2(arr,0));

	}

	public static boolean arraySortOrNot(int[] arr) {
		// TODO Auto-generated method stub
		if(arr.length==1) {
			return true;
		}
		if(arr[0]>arr[1]) {
			return false;
		}
		int[]a=new int[arr.length-1];
		for(int i=0;i<a.length;i++) {
			a[i]=arr[i+1];
		}
		return arraySortOrNot(a);
		
	}
	public static boolean arraySortOrNot2(int[] arr,int ind) {
		// TODO Auto-generated method stub
		if(ind==arr.length-1) {
			return true;
		}
		return (arr[ind]<arr[ind+1]) && arraySortOrNot2(arr,++ind);
		
	}

}
