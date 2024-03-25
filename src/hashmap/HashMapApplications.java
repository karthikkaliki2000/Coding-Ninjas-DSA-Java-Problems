package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapApplications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int[] arr= {1,2,2,1};
	//	ArrayList<Integer> output=removeDuplicates(arr);
	//	int output=maxFrequencyNumber(arr);
	//	System.out.println(output);
//		int[] arr1= {7,7,7};
//		int[] arr2= {7,7,7,7};
//		printIntersection(arr1,arr2);
//		int[] arr2= {-2,2,6,-2,2,-6,3};
//		PairSum(arr2,7);
	//	System.out.println(uniqueChar("codingninjas"));
	//	int[] arr= {9,1,8,6,3,4,2,7,10,15};
		//int []arr= {2 ,12, 9, 16, 10, 5, 3 ,20, 25, 11, 1 ,8 ,6 };
		//int[] arr= {7,15 ,24, 23 ,12 ,19, 11 ,16};
		
	//	System.out.println(longestConsecutiveIncreasingSequence(arr));
		int[] arr= {5,1,2,4};
		//int[] arr= {4,4,4,4};
		System.out.println(getPairsWithDifferenceK(arr,0));

	}
	private static ArrayList<Integer> removeDuplicates(int[] arr) {
		// TODO Auto-generated method stub
		ArrayList<Integer> output=new ArrayList<Integer>();
		HashMap<Integer,Boolean> map=new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], true);
				output.add(arr[i]);
			}
		}
		return output;
	}

    public static int maxFrequencyNumber(int[] arr){ 
    	HashMap<Integer,Integer> h=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(h.containsKey(arr[i])){
                h.put(arr[i],h.get(arr[i])+1);
            }
            else
                h.put(arr[i],1);
        }
        int max=0;
        int maxKey=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
       
        {
            if(h.get(arr[i])>max){
                max=h.get(arr[i]);
                maxKey=arr[i];}
        }
     


        return maxKey ;
    }
	public static void printIntersection(int[] arr1,int[] arr2){
		HashMap<Integer,Integer> h1=new HashMap<>();
		for(int i=0;i<arr1.length;i++) {
			if(h1.containsKey(arr1[i])) {
				h1.put(arr1[i], h1.get(arr1[i])+1);
			}
			else {
				h1.put(arr1[i], 1);
			}
		}
		for(int i=0;i<arr2.length;i++) {
			if(h1.containsKey(arr2[i])) {
				System.out.println(arr2[i]);
				h1.put(arr2[i], h1.get(arr2[i])-1);
				if(h1.get(arr2[i])==0) {
						h1.remove(arr2[i]);
				}
			}
		}

	}

	public static String uniqueChar(String str){
		HashMap<Character,Integer> h=new HashMap<>();
		String res="";
		for(int i=0;i<str.length();i++) {
			char c=str.charAt(i);
			
			if(h.containsKey(c)) {
				int n=(int) h.get(c);
				h.put(c,++n);
			}
			else {
				h.put(c, 1);
				res+=c;
			}
            
		}
	//	System.out.println(h);
		return res;

	}
	public static int PairSum(int[] input, int size) {
		int c=0;
		HashMap<Integer,Integer> h1=new HashMap<>();
		for(int i=0;i<input.length;i++) {
			if(h1.containsKey(-input[i])) {
				c+=h1.get(-input[i]);
			}
			if(h1.containsKey(input[i])) {
				h1.put(input[i], h1.get(input[i])+1);
			}
			else {
				
				h1.put(input[i], 1);
			}
		}
		//System.out.println(c);
		return c;
		
	}
	public class Solution {

		public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
			// Write your code here
			 HashMap<Integer,Integer> map = new HashMap<>();
		        int sum=0,maxLen=-1;
		        for (int i=0;i<arr.length;i++)
		        {
		            sum=sum+arr[i];
		            //System.out.println("Current cumulative sum: "+sum);
		            if (sum==0)
		            {
		                maxLen=i+1;
		            }
		            if (map.containsKey(sum))
		            {
		                int prevIndex=map.get(sum);
		                //System.out.println("Sum found previously at index: "+prevIndex);
		                int currLen=i-prevIndex;
		                //System.out.println("Length of 0 sum: "+currLen);
		                if (currLen>maxLen)
		                {
		                    maxLen=currLen;
		                    //System.out.println("Max Length of 0 sum: "+maxLen);
		                }
		            }
		            else
		            {
		                //System.out.println("Adding sum to HashMap");
		                map.put(sum,i);
		            }
		            //System.out.println();
		        }
		        return maxLen;

			
		}
	}
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		HashMap<Integer,Boolean> h=new HashMap<>();
		int s=0;int e=0;
		ArrayList<Integer> li=new ArrayList<>();
		ArrayList<ArrayList<Integer>> lires=new ArrayList();
		int maxl=0;
		for(int i=0;i<arr.length;i++) {
			h.put(arr[i], true);                     //int[] arr= {9,1,8,6,3,4,2,7,10,15};
		}
		for(int i=0;i<arr.length;i++) {
			int l=0;
			int ele=arr[i];
			int tele=arr[i];
			while(h.containsKey(ele) && h.get(ele)==true) {
				s=tele;
				h.put(ele, false);
				e=ele;
				l++;
				ele++;
			}
			ele=tele-1;
			while(h.containsKey(ele) && h.get(ele)==true) {
				e=tele;
				h.put(ele, false);
				s=ele;
				l++;
				ele--;
			}	
			
			if(l>=maxl) {
				
				if(s==e) {
					li.add(s);
				}
				else {
					li.add(s);
					li.add(e);
				}
				maxl=l;
				//System.out.println(li);
				lires.add(li);
				li=new ArrayList();
			}
			
			
			
		}

		for(int i=0;i<arr.length;i++) {
			int elem=arr[i];
			for(int j=0;j<lires.size();j++) {
				if(elem==lires.get(j).get(0) && lires.get(j).size()==maxl) {
					//System.out.println(lires.get(j));
					//break;
					 return lires.get(j);
				}
			}
			
			
		}
		System.out.println(lires);
		return lires.get(0);
    }

	public static int getPairsWithDifferenceK(int arr[], int k) {
		//Write your code here
		int c=0;
		HashMap<Integer,Integer> h1=new HashMap<>();

       for(int i=0;i<arr.length;i++) {
			if(h1.containsKey(arr[i])) {
				if((h1.containsKey(arr[i]+k) || h1.containsKey(arr[i]-k))) {
					c++;
				}
			}
			else {
				if((h1.containsKey(arr[i]+k) || h1.containsKey(arr[i]-k))) {
					c+=h1.get(arr[i]);
				}
			}
			if(h1.containsKey(arr[i])) {
				int n=h1.get(arr[i]);
				h1.put(arr[i],n+1);
			}
			else {
				
				h1.put(arr[i], 1);
			}
			
		}
		return c;
		
	}

}
