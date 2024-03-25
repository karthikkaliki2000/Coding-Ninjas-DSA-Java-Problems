package recursion;

import java.util.Arrays;

public class SubSets {
	
	public static int[][] helper(int input[],int si){
		if(si>=input.length){
			int ans[][]=new int[1][0];
           return ans;
		}
		int[][] so=helper(input,si+1);
		int[][] o=new int[2*so.length][];
		int k=0;
		for(int i=0;i<so.length;i++){
			o[i]=new int[so[i].length];
			for(int j=0;j<so[i].length;j++){
				o[i][j]=so[i][j];
			}
			k++;
		}
		
		for(int i=0;i<so.length;i++){
			o[k+i]=new int[so[i].length+1];
            o[k+i][0]=input[si];
			for(int j=1;j<=so[i].length;j++){
				o[i+k][j]=so[i][j-1];
			}
		}
		return o;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input= {12, 15, 20};
		int[][] res=helper(input,0);
        
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[i].length;j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}
	}

}
