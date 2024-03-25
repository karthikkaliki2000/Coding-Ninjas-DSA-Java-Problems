package timecomplexity;

public class ArrayIntersection {
	 public static void sort(int[] arr,int l,int h) {
			// TODO Auto-generated method stub
			int mid=(l+h)/2;
			int pivot=arr[mid];
			int s=l;
			int e=h;
			if(l>h) {
				return;
			}
			while(s<=e) {
				while(arr[s]<pivot) {
					s++;
				}
				while(arr[e]>pivot) {
					e--;
				}
				if(s<=e) {
					int t=arr[s];
					arr[s]=arr[e];
					arr[e]=t;
					s++;
					e--;
				}
			}
			sort(arr,l,e);
			sort(arr,s,h);
			

			
			
		}

		public static void intersection(int[] arr1, int[] arr2) {
		    //Your code goes here
			if(arr1.length==0 || arr2.length==0){
				return;
			}
			sort(arr1,0,arr1.length-1);
			sort(arr2,0,arr2.length-1);
			
			for(int i=0;i<arr1.length;i++) {
				int target=arr1[i];
				for(int k=0;k<arr2.length;k++){
					if(arr2[k]==target) {
						
						System.out.print(arr2[k]+" ");
						arr2[k]=0;
						break;
					}
				}
			  
			}
		
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

}
