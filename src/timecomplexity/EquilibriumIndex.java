package timecomplexity;

public class EquilibriumIndex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,-1,4};
		System.out.println(arrayEquilibriumIndex(arr));

	}
	public static int arrayEquilibriumIndex(int[] arr){  
		//Your code goes here
		if(arr.length<=1) {
			return -1;
		}
		int ls=0;
		int rs=0;
		for(int i=0;i<arr.length;i++) {
			rs+=arr[i];
		}
		ls=0;
		int ind=-1;
		for(int i=0;i<arr.length;i++) {
			rs-=arr[i];
			if(ls==rs) {
				ind=i;
				return ind;
			}
			else {
				ls+=arr[i];
			}
		}
		return ind;
		
		
	}

}
