package recursion;
import java.util.*;
public class SubsetWithOutRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,2};
		List<List<Integer>> l=subset(arr);
		System.out.println(l);
		List<List<Integer>> l1=subsetDuplicate(arr);
		System.out.println(l1);
		

	}
	public static List<List<Integer>> subset(int[] arr){
		List<List<Integer>> outer=new ArrayList<>();
		outer.add(new ArrayList<>());
		for(int num:arr) {
			int n=outer.size();
			for(int i=0;i<n;i++) {
				List<Integer> inner=new ArrayList<>(outer.get(i));
				inner.add(num);
				outer.add(inner);
			}
			
		}
		return outer;
	}
	public static List<List<Integer>> subsetDuplicate(int[] arr){
		List<List<Integer>> outer=new ArrayList<>();
		Arrays.sort(arr);
		outer.add(new ArrayList<>());
		int start=0;
		int end=0;
		for(int j=0;j<arr.length;j++) {
			start=0;
			if(j>0 && arr[j]==arr[j-1]) {
				start=end+1;
			}
			end=outer.size()-1;
			int n=outer.size();
			for(int i=start;i<n;i++) {
				List<Integer> inner=new ArrayList<>(outer.get(i));
				inner.add(arr[j]);
				outer.add(inner);
			}
			
		}
		return outer;
	}

}
