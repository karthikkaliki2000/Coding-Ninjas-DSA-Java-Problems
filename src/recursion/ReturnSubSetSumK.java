package recursion;

public class ReturnSubSetSumK {
	public static int[][] returnSubSetsK(int[] input, int k ,int si)
	{
		if(si >= input.length || k == 0)
		{
			if(k == 0)
				return new int[1][0];
			return new int[0][0];
		}
		int[][] output1 = new int[0][0];
		int[][] output2 = new int[0][0];
		if(k - input[si] >= 0)
		{
			output1 = returnSubSetsK(input, k - input[si], si + 1);
		}
		output2 = returnSubSetsK(input, k, si + 1);
		int[][] output = new int[output1.length + output2.length][];
		for(int i = 0;i < output1.length;i++)
		{
			int[] toAdd = new int[output1[i].length + 1];
			toAdd[0] = input[si];
			for(int j = 0;j<output1[i].length;j++)
				toAdd[j + 1] = output1[i][j];
			output[i] = toAdd;
		}
		for(int j = output1.length; j < output.length;j++)
		{
			output[j] = output2[j - output1.length];
		}
		return output;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {5,2,1,3,6,7};
		int[][] res=returnSubSetsK(arr,8,0);
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[i].length;j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}

	}

}
