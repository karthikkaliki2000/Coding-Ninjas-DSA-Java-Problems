package recursion;

import java.util.ArrayList;
import java.util.List;

public class LinearSearchUsingRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr= {1,2,6,3,9,10,6,78,56,6};
		//System.out.println(findPositionOfElement(arr,78,0));
		//System.out.println(elementPresentOrNot(arr,7,0));
		System.out.println(findAllIndex3(arr,6,0));
		//int []arr2= {9};
		System.out.println(findAllIndex3withoutTakingALfromOutside(arr,6,0));

	}

	private static int findPositionOfElement(int[] arr, int target,int ind) {
		// TODO Auto-generated method stub
		if(ind>arr.length-1) {
			return -1;
		}
		if(arr[ind]==target) {
			return ind;
		}
		return findPositionOfElement(arr,target,++ind);
	}
	private static boolean elementPresentOrNot(int[] arr, int target,int ind) {
		// TODO Auto-generated method stub
		if(ind>arr.length-1) {
			return false;
		}
		return arr[ind]==target || elementPresentOrNot(arr,target,++ind);
	}
	
	static List<Integer> li=new ArrayList();
	private static ArrayList findAllIndex3(int[] arr, int target,int ind) {
		// TODO Auto-generated method stub
		if(ind>arr.length-1) {
			return (ArrayList) li;
		}
		if(arr[ind]==target) {
			li.add(ind);
		}
		return findAllIndex3(arr,target,++ind);
	}
	private static ArrayList findAllIndex3withoutTakingALfromOutside(int[] arr, int target,int ind) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list=new ArrayList();
		if(ind>arr.length-1) {
			return list;
		}
		if(arr[ind]==target) {
			list.add(ind);
		}
		ArrayList ansFromBelowCalls= findAllIndex3withoutTakingALfromOutside(arr,target,++ind);
		list.addAll(ansFromBelowCalls);
		return list;
	}

}
