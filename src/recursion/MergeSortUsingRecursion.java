package recursion;

public class MergeSortUsingRecursion {
	  public static void merge(int[] a,int[] b ,int[] arr){
          
          int ap=0,bp=0,lp=0;
          while(ap<a.length && bp<b.length){
              if(a[ap]<b[bp]){
                  arr[lp]=a[ap];
                  ap++;
              }
              else{
                  arr[lp]=b[bp];
                  bp++;
              }
                 lp++;
          }
          while(ap<a.length){
               arr[lp]=a[ap];
                  lp++;
                  ap++;
          }
          while(bp<b.length){
               arr[lp]=b[bp];
                  lp++;
                  bp++;
          }
}

public static void mergeSort(int[] arr, int l, int r){
    // Write your code here
    if(l==r){
        return;
    }
    int mid=(l+r)/2;
    int a[]=new int[mid+1];
    int b[]=new int[arr.length-a.length];
    for(int i=0;i<a.length;i++){
        a[i]=arr[i];
    }
    for(int j=0;j<b.length;j++){
        b[j]=arr[j+mid+1];
    }
    mergeSort(a,0,a.length-1);
    mergeSort(b,0,b.length-1);
    merge(a,b,arr);



}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,3,4,2,7,6};

		mergeSort(arr,0,arr.length-1);
		

	}

}
