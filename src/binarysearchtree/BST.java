package binarysearchtree;

import java.util.ArrayList;

import binarytree.BinaryTreeNode;

public class BST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean isBST(BinaryTreeNode<Integer> root,int min,int max){
        if(root==null){
			return true;
		}
	 
		if(min>=root.data || root.data>=max){
		    return false;
		}
		return isBST(root.left,min,root.data) && isBST(root.right,root.data,max);	
		
	}
	public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
		 if(root==null){
			 return;
		 }
		 if(k1<root.data){
           elementsInRangeK1K2(root.left,k1,k2);
		 }
        if(root.data>=k1 && root.data<=k2){
			 	 System.out.print(root.data+" ");   
		 }
		 if(k2>root.data){
          elementsInRangeK1K2(root.right,k1,k2);
		 }
		
		 
	}
	public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		if(root==null){
			return false;
		}
		if(root.data==k){
			return true;
		}
		else if(root.data>k){
			return searchInBST(root.left,k);
		}
		return searchInBST(root.right,k);
		
	}
	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
		if(root==null){
			ArrayList<Integer> a=null;
			return a;
		}
		if(root.data==data){
			ArrayList<Integer> a=new ArrayList<>();
			a.add(root.data);
			return a;
		}
		ArrayList<Integer> la=getPath(root.left,data);
		if(la!=null){
			la.add(root.data);
			return la;
		}
		ArrayList<Integer> ra=getPath(root.right,data);
		if(ra!=null){
			ra.add(root.data);
			return ra;
		}
		return null;
	}
	   public static int replaceWithLargerNodesSum(BinaryTreeNode<Integer> root, int sum)
	    {
	        //Base Case
	        if(root == null)
				return sum;
	        
			//Recursive Case
			sum = replaceWithLargerNodesSum(root.right,sum);
			sum += root.data;
			root.data = sum;
			return replaceWithLargerNodesSum(root.left,sum);
	    }
	   public static int lcaBinaryTree(BinaryTreeNode <Integer> root , int a, int b){
	        // Write your code here
	        if(root==null)
	            return -1;
	        if(root.data==a || root.data==b)
	            return root.data;
	        int c=lcaBinaryTree(root.left,a,b);
	        int d=lcaBinaryTree(root.right,a,b);
	        if(c==-1 && d==-1)
	            return -1;
	        else if(c==-1 && d!=-1)
	            return  d;
	        else if(c!=-1 && d==-1)
	            return c;
	        else
	            return root.data;
	    }

//		public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
//	               Pair ans=helper(root);
//	        return ans.head;}
//	    public static Pair helper(BinaryTreeNode<Integer> root){
//	        if(root==null)
//	        {
//	            Pair output=new Pair();
//	            output.head=null;
//	            output.tail=null;
//	            return output;
//	        }
//	        Pair lefttree=helper(root.left);
//	        LinkedListNode<Integer> newNode=new LinkedListNode<>(root.data);
//	        Pair righttree=helper(root.right);
//	        Pair output=new Pair();
//	       if(lefttree.head!=null)
//	       {
//	           output.head=lefttree.head;
//	           lefttree.tail.next=newNode;
//
//	       }
//	        else {
//	            output.head=newNode;
//	        }
//	    newNode.next=righttree.head;
//	        if(righttree.head==null)
//	        {
//	            output.tail=newNode;
//
//	        }
//	        else{
//	            output.tail=righttree.tail;
//	        }
//	        return output;
//	}
	   
	   
	   
		/*
		 * public static int largestBSTSubtree(BinaryTreeNode<Integer> root) { // Write
		 * your code here if (root==null) return 0;
		 * 
		 * if (isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE)) return findHeight(root);
		 * else { return
		 * Math.max(largestBSTSubtree(root.left),largestBSTSubtree(root.right)); }
		 * 
		 * }
		 * 
		 * private static int findHeight(BinaryTreeNode<Integer> root) { if (root==null)
		 * return 0;
		 * 
		 * if (root.left==null && root.right==null) return 1;
		 * 
		 * return Math.max(findHeight(root.left),findHeight(root.right))+1; }
		 * 
		 * private static boolean isBST(BinaryTreeNode<Integer> root, int min, int max)
		 * { if(root == null) return true;
		 * 
		 * if(root.data < min || root.data > max) return false; else return
		 * isBST(root.left,min,root.data -1) && isBST(root.right,root.data +1,max); }
		 */

}
//class Pair{
//    LinkedListNode<Integer> head;
//    LinkedListNode<Integer> tail;
//}
