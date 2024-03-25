package binarysearchtree;

import binarytree.BinaryTreeNode;

public class BSTClass {
    private BinaryTreeNode<Integer> root;
    private int size;
  
 public static BinaryTreeNode<Integer> addHelper(BinaryTreeNode<Integer> node,int ele) {
    	if(node==null) {
    		BinaryTreeNode<Integer> newnode=new BinaryTreeNode<Integer>(ele);
    		return newnode;
    	}
    	if(ele<node.data) {
    		node.left=addHelper(node.left,ele);
    	}
    	else {
    		node.right=addHelper(node.right,ele);
    	}
    	return node;
    }
 public void add(int ele){
	 root=addHelper(root,ele);
	 size++;
 }
    public boolean remove(int ele) {
    	BSTDeleteReturn res=removeHelper(root,ele);
    	if(res.deleted==true) {
    		size--;
    	}
    	return res.deleted;
    }
    public static BSTDeleteReturn removeHelper(BinaryTreeNode<Integer> node ,int ele) {
    	if(node==null) {
    		return new BSTDeleteReturn(null,false);
    	}
    	if(node.data<ele) {
    		BSTDeleteReturn ro=removeHelper(node.right,ele);
    		node.right=ro.root;
    		ro.root=node;
    		return ro;
    	}
    	if(node.data>ele) {
    		BSTDeleteReturn lo=removeHelper(node.left,ele);
    		node.left=lo.root;
    		lo.root=node;
    		return lo;
    	}
    	//0 child
    	if(node.left==null && node.right==null) {
    		return new BSTDeleteReturn(null,true);
    	}
    	//1 child
    	if(node.left!=null && node.right==null) {
    		return new BSTDeleteReturn(node.left,true);
    	}
    	//1 child
    	if(node.left==null && node.right!=null) {
    		return new BSTDeleteReturn(node.right,true);
    	}
    	//both present
    	int rmin=minimum(node.right);
    	node.data=rmin;
    	BSTDeleteReturn or=removeHelper(node.right,rmin);
    	node.right=or.root;
    	return new BSTDeleteReturn(node,true);
    }
    public static int minimum(BinaryTreeNode<Integer> node) {
    	if(node==null) {
    		return Integer.MAX_VALUE;
    	}
    	int l=minimum(node.left);
    	int r=minimum(node.right);
    	return Math.min(node.data, Math.min(l, r));
    }
    public boolean isPresent(int ele) {
    	return isPresentHelper(root,ele);
    }
    public static boolean isPresentHelper( BinaryTreeNode<Integer> root,int ele) {
    	if(root==null) {
    		return false;
    	}
    	if(root.data==ele) {
    		return true;
    	}
    	if(ele<root.data) {
    		//left call
    		return isPresentHelper(root.left,ele);
    	}
    	else {
    		//right call
    		return isPresentHelper(root.right,ele);
    	}
    }
    public int size() {
    	return size;
    }
    public void print() {
    	printHelper(root);
    }
    public static void printHelper(BinaryTreeNode<Integer> node) {
    	if(node==null) {
    		return;
    	}
    	System.out.print(node.data+" : ");
    	if(node.left!=null) {
    		System.out.print("L"+node.left.data+", ");
    	}
    	if(node.right!=null) {
    		System.out.print("R"+node.right.data);
    	}
    	System.out.println();
    	printHelper(node.left);
    	printHelper(node.right);
    }
}

