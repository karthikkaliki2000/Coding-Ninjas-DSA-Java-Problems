package recursion;

public class QuickSortUsingRecursion {
	public static void quickSort(int[] input,int startIndex, int endIndex) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * No need to print or return the output.
		 * Taking input and printing output is handled automatically.
		 */
		 if(startIndex>=endIndex){
			 return;
		 }
		 int pi=partition(input,startIndex,endIndex);
		quickSort(input,startIndex,pi-1);
		quickSort(input,pi+1,endIndex);


		
	}
	public static int partition(int[] input,int startIndex, int endIndex){
		int c=0;
		int p=input[startIndex];
		for(int i=startIndex+1;i<=endIndex;i++){
           if(p>input[i]){
			   c++;
		   }
		}
		int t=input[startIndex+c];
		
		input[startIndex+c]=p;
        input[startIndex]=t;
		int i=startIndex;
		int j=endIndex;
		
		//System.out.println("s"+startIndex+"c"+c+"e"+endIndex);
		
	
		while(i<j){
			if(input[i]<p){
               i++;
			}else if(input[j]>p){
                    j--;
			}
			else{
                  int temp=input[i];
			   input[i]=input[j];
			   input[j]=temp;
			   i++;
			   j--;
			}
			}
			
	
	//	System.out.println("c"+startIndex+c);
		return startIndex+c;

		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {10,4,5,9,8,6,12,11,7};
		//System.out.println(arr.length-1);
		quickSort(arr,0,arr.length-1);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
