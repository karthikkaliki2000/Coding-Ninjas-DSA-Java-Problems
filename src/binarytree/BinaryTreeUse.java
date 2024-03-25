package binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair<T, U> {
	T minimum;
	U maximum;

	public Pair(T minimum, U maximum) {
		this.minimum = minimum;
		this.maximum = maximum;
	}

}
public class BinaryTreeUse {
	public static int noOfNodes(BinaryTreeNode<Integer> root) {
		int c=0;
		if(root==null) {
			return c;
		}
		c++;
		c+=noOfNodes(root.left);
		c+=noOfNodes(root.right);
		return c;
	}
	public static int sumOfNodes(BinaryTreeNode<Integer> root) {
		int c=0;
		if(root==null) {
			return c;
		}
		c+=root.data;
		c+=sumOfNodes(root.left);
		c+=sumOfNodes(root.right);
		return c;
	}
	public static void printRec(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.println(root.data);
		printRec(root.left);
		printRec(root.right);
	}
	public static <T> void printRecDetailed(BinaryTreeNode<T> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data+":");
		if(root.left!=null) {
			System.out.print("L"+root.left.data);
		}
		if(root.right!=null) {
			System.out.print("R"+root.right.data);
		}
		System.out.println();
		printRecDetailed(root.left);
		printRecDetailed(root.right);
	}
     public static void preOrder(BinaryTreeNode<Integer> root){
    	 if(root==null) {
    		 return;
    	 }
    	 System.out.println(root.data);
    	 preOrder(root.left);
    	 preOrder(root.right);
     }
     public static void postOrder(BinaryTreeNode<Integer> root){
    	 if(root==null) {
    		 return;
    	 }
    	
    	 postOrder(root.left);
    	 postOrder(root.right);
    	 System.out.println(root.data);
     }
     public static int largestData(BinaryTreeNode<Integer> root){
    	 int max=-1;
    	 if(root==null) {
    		 return -1;
    	 }
    	 else {
    		 int lmax=largestData(root.left);
        	 int rmax=largestData(root.right);
        	 if(lmax>rmax && lmax>root.data) {
        		 max= lmax;
        	 }
        	 else if(rmax>root.data){
        		 max= rmax;
        	 }
        	 else {
        		 max=root.data;
        	 }
        	 
    	 }
    	 return max;
    	
     }
     public static int smallestData(BinaryTreeNode<Integer> root){
    	 int min=Integer.MAX_VALUE;
    	 if(root==null) {
    		 return min;
    	 }
    	 else {
    		 int lmin=smallestData(root.left);
        	 int rmin=smallestData(root.right);
        	 if(lmin>rmin && rmin<root.data) {
        		 min= rmin;
        	 }
        	 else if(lmin<root.data && lmin<rmin){
        		 min= lmin;
        	 }
        	 else {
        		 min=root.data;
        	 }
        	 
    	 }
    	 return min;
    	
     }
 	public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
		//Your code goes here
 		int c=0;
 		if(root==null) {
 			return 0;
 		}
 		if(root.data>x) {
 			c++;
 		}
 		c+=countNodesGreaterThanX(root.left,x)+countNodesGreaterThanX(root.right,x);
 		return c;
 		
	}
 	public static int height(BinaryTreeNode<Integer> root) {
		//Your code goes here
 		if(root==null) {
 			return 0;
 		}
 		int lh=height(root.left);
 		int rh=height(root.right);
 		if(lh>rh) {
 			return lh+1;
 		}
 		else {
 			return rh+1;
 		}
 		
	}
 	public static int noOfLeafNodes(BinaryTreeNode<Integer> root) {
		//Your code goes here
 		int c=0;
 		if(root==null) {
 			return 0;
 		}
 		if(root.left==null && root.right==null) {
 			c++;
 		}
 		c+=noOfLeafNodes(root.left)+noOfLeafNodes(root.right);
 		return c;
	}
 	public static void printAtDepthK(BinaryTreeNode<Integer> root,int k) {
 		if(root==null) {
 			return;
 		}
 		if(k==0) {
 			System.out.print(root.data+" ");
 		}
 		printAtDepthK(root.left,k-1);
 		printAtDepthK(root.right,k-1);
 	}
 	public static void changeToDepthTree(BinaryTreeNode<Integer> root,int k) {
	    //Your code goes here
 		if(root==null) {
 			return;
 		}
 		root.data=k;
 		System.out.println(root.data);
 		changeToDepthTree(root.left,k+1);
 		changeToDepthTree(root.right,k+1);
	}
 	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
	    //Your code goes here
 		if(root==null) {
 			return false;
 		}
 		if(root.data==x) {
 			return true;
 		}
 	    return isNodePresent(root.left,x) || isNodePresent(root.right,x);
 	 		
 		
	}
 	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		//Your code goes here
 		//data(root,null);
 		if(root==null) {
 			return;
 		}
 		if(root.left==null && root.right!=null) {
				System.out.println(root.right.data);
			}
		if(root.right==null && root.left!=null){
				System.out.println(root.left.data);
			}
		
		printNodesWithoutSibling(root.left);
		printNodesWithoutSibling(root.right);
 		
	}
 	public static void data(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> PNode) {
		//Your code goes here
 		if(root==null) {
 			return;
 		}
 		if(PNode!=null) {
 			if(PNode.left==null && PNode.right!=null) {
 				System.out.println(PNode.right.data);
 			}
 			if(PNode.right==null && PNode.left!=null){
 				System.out.println(PNode.left.data);
 			}
 		}
 		PNode=root;
 		data(root.left,PNode);
 		data(root.right,PNode);
 		System.out.println(root.data);
	}
 	public static BinaryTreeNode<Integer> removeLeafNodes(BinaryTreeNode<Integer> root){
 		if(root==null) {
 			return null;
 		}
 		if(root.left==null && root.right==null) {
 			return null;
 		}
 		root.left=removeLeafNodes(root.left);
 		root.right=removeLeafNodes(root.right);
 		return root;
 	}
	public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
		//Your code goes here
		if(root==null) {
			return;
		}
		BinaryTreeNode<Integer> left=root.left;
		BinaryTreeNode<Integer> right=root.right;
		root.left=right;
		root.right=left;
		mirrorBinaryTree(root.left);
		mirrorBinaryTree(root.right);
	}
	public static boolean isBalanced(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return true;
		}
		int lh=height(root.left);
		int rh=height(root.right);
		if(Math.abs(rh-lh)>1) {
			return false;
		}
		return isBalanced(root.left) && isBalanced(root.right);
	}
	public static BalancedReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
		if(root==null) {
			int height=0;boolean isBalanced=true;
			BalancedReturn b=new BalancedReturn();
			b.height=height;
			b.isBalanced=isBalanced;
			return b;
		}
		BalancedReturn lhr=isBalancedBetter(root.left);
		BalancedReturn rhr=isBalancedBetter(root.right);
		boolean isBalanced=true;
		if(!lhr.isBalanced || !rhr.isBalanced) {
			isBalanced=false;
		}
		if(Math.max(lhr.height, rhr.height)>1) {
			isBalanced=false;
		}
		BalancedReturn b=new BalancedReturn();
		b.isBalanced=isBalanced;
		b.height=1+Math.max(lhr.height, rhr.height);
		return b;
	}
	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
		//Your code goes here
		if(root==null) {
			//diameter=0;
			return 0;
		}
		int lh=height(root.left);
		int rh=height(root.right);
		int op1=lh+rh;
		int op2=diameterOfBinaryTree(root.left);
		int op3=diameterOfBinaryTree(root.right);
		return Math.max(op1, Math.max(op2, op3));
	}
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		//Your code goes here
		if(preOrder.length==0 && inOrder.length==0) {
			return null;
		}
		int rootData=preOrder[0];//finding root value
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
		int rooti=0;
		for(int i=0;i<inOrder.length;i++) {
			if(inOrder[i]==rootData) {
				rooti=i;//finding root index in inorder
				break;
			}
		}
		int[] lpo=new int[rooti];//left preOrder
		int j=1;
		for(int i=0;i<rooti;i++) {
			lpo[i]=preOrder[j];
			j++;
		}
		int[] rpo=new int[preOrder.length-1-lpo.length];
		int k=0;
		for(int i=1+lpo.length;i<preOrder.length;i++) {
			rpo[k]=preOrder[i];// Right preOrder
			k++;
		}
		int[] lio=new int[lpo.length];
		for(int i=0;i<rooti;i++) {
			lio[i]=inOrder[i];
		}
		int[] rio=new int[rpo.length];
		int h=0;
		for(int i=rooti+1;i<inOrder.length;i++) {
			rio[h]=inOrder[i];
			h++;
		}
		root.left=buildTree(lpo,lio);
		root.right=buildTree(rpo,rio);
		
		return root;
	}
	public static BinaryTreeNode<Integer> buildTree1(int[] postOrder, int[] inOrder) {
		//Your code goes here
		if(postOrder.length==0 && inOrder.length==0) {
			return null;
		}
		int rootData=postOrder[postOrder.length-1];//finding root value
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
		int rooti=0;
		for(int i=0;i<inOrder.length;i++) {
			if(inOrder[i]==rootData) {
				rooti=i;//finding root index in inorder
				break;
			}
		}
		
		int[] lio=new int[rooti];
		for(int i=0;i<rooti;i++) {
			lio[i]=inOrder[i];
		}
		int[] rio=new int[inOrder.length-1-lio.length];
		int h=0;
		for(int i=rooti+1;i<inOrder.length;i++) {
			rio[h]=inOrder[i];
			h++;
		}


		int[] lpo=new int[lio.length];//left preOrder
		for(int i=0;i<lpo.length;i++) {
			lpo[i]=postOrder[i];	
		}
		int[] rpo=new int[rio.length];
		int k=0;
		for(int i=lpo.length;i<postOrder.length-1;i++) {
			rpo[k]=postOrder[i];// Right preOrder
			k++;
		}
		root.left=buildTree(lpo,lio);
		root.right=buildTree(rpo,rio);
		
		return root;
	}
	public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root==null) {
			return;
		}
		int duplicateData=root.data;
		BinaryTreeNode<Integer> node=new BinaryTreeNode<Integer>(duplicateData);
		BinaryTreeNode<Integer> tl=root.left;
		BinaryTreeNode<Integer> tr=root.right;
		root.left=node;
		node.left=tl;
		insertDuplicateNode(tl);
		insertDuplicateNode(tr);
		
	}
//	static int max=0,min=;
	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		//Your code goes here
		if(root==null) {
			Pair p=new Pair(0, 0);
			return p;
		}
		int min=smallestData(root);
		int max=largestData(root);
		Pair p=new Pair(min,max);
		return p;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(1);
//		BinaryTreeNode<Integer> rootleft=new BinaryTreeNode<>(2);
//		BinaryTreeNode<Integer> rootright=new BinaryTreeNode<Integer>(3);
//		BinaryTreeNode<Integer> rootleftright=new BinaryTreeNode<Integer>(4);
//		BinaryTreeNode<Integer> rootrightleft=new BinaryTreeNode<Integer>(5);
//		root.left=rootleft;
//		root.right=rootright;
//		rootleft.right=rootleftright;
//		rootright.left=rootrightleft;
	//	printRec(root);
//		BinaryTreeNode<Integer> root=takeTreeInputBetter(true,0,true);
		
//	//	printRecDetailed(root);
		
		BinaryTreeNode<Integer> root=takeTreeInputLevelWise();//////////////////
	//	System.out.println("nodes="+noOfNodes(root));
	//	printRecDetailed(root);
	//	System.out.println(sumOfNodes(root));
	//	printLevelWise(root);
//		preOrder(root);
		//postOrder(root);
		//System.out.println(largestData(root));
	//	System.out.println(countNodesGreaterThanX(root,4));
//		System.out.println(height(root));
		//System.out.println(noOfLeafNodes(root));
	//	printAtDepthK(root,2);
		//changeToDepthTree(root,0);
	//	System.out.println(isNodePresent(root,4));
	//	printNodesWithoutSibling(root);
		
		//printRecDetailed(removeLeafNodes(root));
//		mirrorBinaryTree(root);
		
		//printRecDetailed(buildTree);
	//	System.out.println(isBalancedBetter(root).isBalanced);
//		int[] inOrder= {0,1,2,3,4,5,6};
//		int[] preOrder={3,1,0,2,5,4,6};
//		int[] postOrder= {0,2,1,4,5,6,3};
       
		//printRecDetailed(buildTree(preOrder,inOrder));
	//	printRecDetailed(buildTree(postOrder,inOrder));
		//insertDuplicateNode(root);
	//	Pair p=getMinAndMax(root);
	//	System.out.println(p.minimum+" "+p.maximum);
		//printRecDetailed(root);
		printLevelWise1(root);
	}
	private static BinaryTreeNode<Integer> takeTreeInput() {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData=s.nextInt();
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
		if(root.data==-1) {
			return null;
		}
		BinaryTreeNode<Integer> left=takeTreeInput();
		BinaryTreeNode<Integer> right=takeTreeInput();
		root.left=left;
		root.right=right;
		return root;
	}
	private static BinaryTreeNode<Integer> takeTreeInputBetter(boolean isRoot,int parentdata,boolean isLeft) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		if(isRoot) {
			System.out.println("Enter root data");
		}
		else {
			if(isLeft) {
				System.out.println("Enter left child of "+parentdata);
			}
			else {
				System.out.println("Enter right child of "+parentdata);
			}
		}
		
		int rootData=s.nextInt();
		BinaryTreeNode<Integer> root=new BinaryTreeNode<>(rootData);
		if(root.data==-1) {
			return null;
		}
		BinaryTreeNode<Integer> left=takeTreeInputBetter(false,rootData,true);
		BinaryTreeNode<Integer> right=takeTreeInputBetter(false,rootData,false);
		root.left=left;
		root.right=right;
		return root;
	}
	
	public static BinaryTreeNode<Integer> takeTreeInputLevelWise(){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData=s.nextInt();
		if(rootData==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root=new BinaryTreeNode<Integer>(rootData);
		Queue<BinaryTreeNode<Integer>> q=new LinkedList<BinaryTreeNode<Integer>>();
		q.add(root);
		while(!q.isEmpty()) {
			BinaryTreeNode<Integer> first=q.poll();
			System.out.println("Enter the left node of "+first.data);
			int left=s.nextInt();
			if(left!=-1) {
				BinaryTreeNode<Integer> leftNode=new BinaryTreeNode<Integer>(left);
				first.left=leftNode;
				q.add(leftNode);
			}
			System.out.println("Enter the right node of "+first.data);
			int right=s.nextInt();
			if(right!=-1) {
				BinaryTreeNode<Integer> rightNode=new BinaryTreeNode<Integer>(right);
				first.right=rightNode;
				q.add(rightNode);
			}
		}
		return root;
	}
	public static void printLevelWise1(BinaryTreeNode<Integer> root){
		
		if(root==null) {
			return;
		}
		
		Queue<BinaryTreeNode<Integer>> q=new LinkedList<BinaryTreeNode<Integer>>();
	
		//System.out.println(root.data);
			q.add(root);
			q.add(null);
		while(!q.isEmpty()) {
			if(q.size()==1 && q.peek()==null || q.isEmpty()) {
				break;
			}
			if(q.peek()==null){
                System.out.println();
			    q.add(q.poll());
			}
			else {
				BinaryTreeNode <Integer> first=q.peek();
				System.out.print(first.data);
				q.poll();
				if(root.left!=null) {
					q.add(root.left);
				}
				if(root.right!=null) {
					q.add(root.right);
				}
			}
		}
		
		}
		
		
	public static void printLevelWise(BinaryTreeNode<Integer> root){
		
		if(root==null) {
			return;
		}
		
		Queue<BinaryTreeNode<Integer>> q=new LinkedList<BinaryTreeNode<Integer>>();
		q.add(root);
		while(!q.isEmpty()) {
			BinaryTreeNode<Integer> first=q.poll();
			
			System.out.print(first.data+":");
			if(first.left!=null) {
				System.out.print("L"+first.left.data);
				
				q.add(first.left);
			}
			
			
			if(first.right!=null) {
				System.out.print("R"+first.right.data);
				q.add(first.right);
			}
			System.out.println();
		}
		
	}

}
