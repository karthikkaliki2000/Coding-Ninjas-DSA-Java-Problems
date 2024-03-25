package recursion;

public class SubSets1 {
	 public static int[][] subsets(int input[],int k) 
	    {
	        return subsets(input,0,k);
	    }
	    public static int[][] subsets(int input[],int si,int sum) {
	        if(si>=input.length)
	        {
	            int ans[][]=new int[1][0];
	            return ans;
	        }
	        int[][] smallans=subsets(input,si+1,sum);
	        int[][] ans=new int[smallans.length*2][];
	        int k=0;
	        for(int i=0;i<smallans.length;i++){
	            ans[i]=new int[smallans[i].length];
	            for(int j=0;j<smallans[i].length;j++){
	                ans[i][j]=smallans[i][j];
	            }
	            k++;
	        }
	        for(int i=0;i<smallans.length;i++)
	        { ans[k+i]=new int[smallans[i].length+1];
	          ans[k+i][0]=input[si];
	            for(int j=1;j<=smallans[i].length;j++)
	            {
	                ans[i+k][j]=smallans[i][j-1];
	            } 
	       
	        }
	        return ans;

	}
	    public static void main(String[] args) {
			int[] arr= {1, 2, 3, 4, 6, 10};
			//int a[][]=subsets(arr,3);
			int output[][] = subsets(arr,6);
			int[] ia=new int[output.length];
			for(int i = 0; i < output.length; i++) {
				int s=0;
				for(int j = 0; j < output[i].length; j++) {
					s+=output[i][j];
				//	System.out.print(output[i][j] + " ");
				}
				if(s==6) {
					ia[i]=i;
					for(int j = 0; j < output[i].length; j++) {
						
						System.out.print(output[i][j] + " ");
					}
					System.out.println();
				}
				
			}
			System.out.println("_______");
//			for(int i:ia) {
//				if(i!=0) {
//					for(int j=0;j<output[i].length;j++) {
//						System.out.print(output[i][j]+" ");
//					}
//					System.out.println();
//				}
//			}
			
		}

}
