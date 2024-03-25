package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeTest {
	

public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		
		// Write your code here
		Queue<TreeNode<Integer>> queue=new LinkedList();
        TreeNode<Integer> res=null;
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()){
            TreeNode<Integer> frontNode=queue.remove();
            if(frontNode==null){
                if(queue.isEmpty()){
                    break;
                }
                queue.add(null);
            }
            else{
                if(frontNode.data>n){
                    if(res==null || frontNode.data<res.data){
                        res=frontNode;
                    }
                }
                for(int i=0;i<frontNode.children.size();i++){
                    queue.add(frontNode.children.get(i));
                }
            }
        }
        return res;
	}
public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){

    if(root.children.size() == 0){
        return null;
    }
  Queue<TreeNode<Integer>> queue = new LinkedList<>();
  TreeNode<Integer> fl=root,sl=null;
  int data = 0;
  queue.add(root);

  while(!queue.isEmpty())
  {
      TreeNode<Integer> frontNode = queue.poll();

           for(int i=0;i<frontNode.children.size();i++){
              queue.add(frontNode.children.get(i));
          }
      
          if(frontNode.data >  data){
              if(frontNode.data > fl.data){
                  sl = fl;
                  data = fl.data;
                  fl = frontNode;
              }
              else if (frontNode.data < fl.data){
                  sl = frontNode;
                  data = sl.data;
              }
          }
       
          
      
      }
      
  
  return sl;


}

	public static ReturnRes maxSumNode(TreeNode<Integer> root){
		// Write your code here
		
		if(root==null) {
			return new ReturnRes(null,0);
		}
		int n=root.children.size();
		//int maxsum=root.data;
		int sum=root.data;
		for(int i=0;i<n;i++) {
			sum+=root.children.get(i).data;
		}
		ReturnRes r = new ReturnRes();
		for(int i=0;i<n;i++) {
			r=maxSumNode(root.children.get(i));
			if(r.sum>sum) {
				sum=r.sum;
				r.maxnode=root.children.get(i);
				r.sum=sum;
			}
			else {
				r.maxnode=root;
				r.sum=sum;
			}
		}
		
		return r;
	}
	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){

		// Write your code here
		 
			if(root==null) {
				return false;
			}
			
			if(root.data==x) {
				return true;
			}
			
	
			int n=root.children.size();
			boolean res=false;
			for(int i=0;i<n;i++) {
				res= res || checkIfContainsX(root.children.get(i), x);
			}
			return res;
		

	}
	public static void printPostOrder(TreeNode<Integer> root){
		/* Your class should be named Solution.
		 * Don't write main() function.
		 * Don't read input, it is passed as function argument.
		 * Print output as specified in the question
		 */
		if(root==null) {
			return;
		}
		int n=root.children.size();
		for(int i=0;i<n;i++) {
			printPostOrder(root.children.get(i));
		}
		System.out.print(root.data+" ");
	}
	public static int getHeight(TreeNode<Integer> root){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
		 * Taking input and printing output is handled automatically.
		 */
		if(root==null) {
			return 0;
		}
		int ans=0;
		
		
		int n=root.children.size();
		for(int i=0;i<n;i++) {
			
			int h1=getHeight(root.children.get(i));
		     ans=Math.max(ans, h1);
			
			
		}
		return 1+ans;
		
	}

	public static void replaceWithDepthValue1(TreeNode<Integer> root,int d){

		// Write your code here
		if(root==null){
			return;
		}
		root.data=d;
		d=d+1;;
		int n=root.children.size();
		for(int i=0;i<n;i++){
			replaceWithDepthValue1(root.children.get(i),d);
		}
		
		
		
	}
	
	public static int numNodeGreater(TreeNode<Integer> root,int x){

		// Write your code here		
		if(root==null) {
			return 0;
		}
		int c=0;
		if(root.data>x) {
			c++;
		}
		int n=root.children.size();
		for(int i=0;i<n;i++) {
			c+=numNodeGreater(root.children.get(i),x);
		}
		return c;

	}
	public static void printLevelWise(TreeNode<Integer> root){
		
		
		if(root==null) {
			return;
		}
		Queue<TreeNode<Integer>> q=new LinkedList<>();
		
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode<Integer> front=q.poll();
			System.out.print(front.data+" : ");
			int n=front.children.size();
			for(int i=0;i<n;i++) {
				TreeNode<Integer> child=front.children.get(i);
				System.out.print(child.data+" ");
				q.add(child);
			}
			System.out.println();
			
		}
		
	}
public static void printLevelWise2(TreeNode<Integer> root){
		
		
		if(root==null) {
			return;
		}
		Queue<TreeNode<Integer>> q=new LinkedList<>();
	//	System.out.print(root.data);
		q.add(root);
		q.add(null);
		while(!q.isEmpty()) {
			TreeNode<Integer> front=q.poll();
			if(front==null && q.size()!=0) {
				q.add(null);
				System.out.println();
			}else{
				if(front!=null) {
					System.out.print(front.data+" ");
					int n=front.children.size();
					for(int i=0;i<n;i++) {
						TreeNode<Integer> child=front.children.get(i);
//						System.out.print(child.data+" ");
						q.add(child);
					}
				}
				//System.out.println();
			}
			
			
		}
		
	}
	public static TreeNode<Integer> takeInputLevelWise(){
		Scanner s=new Scanner(System.in);
		System.out.println("Enter root Data ");
		int rootData=s.nextInt();
		if(rootData==-1) {
			return null;
		}
		TreeNode<Integer> root=new TreeNode<Integer> (rootData);
		Queue<TreeNode<Integer>> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			TreeNode<Integer> front=q.poll();
			System.out.println("Enter no of children of "+front.data+" : ");
			int n=s.nextInt();
			for(int i=0;i<n;i++) {
				System.out.println("Enter child"+(i+1)+" data of "+front.data);
				TreeNode<Integer> child=new TreeNode<>(s.nextInt());
				q.add(child);
				front.children.add(child);
			}
			
		}
		return root;
		
	}
	public static int sumOfAllNode(TreeNode<Integer> root){
		if(root==null) {
			return 0;
		}
		int sum=root.data;
		for(int i=0;i<root.children.size();i++) {
			sum+=sumOfAllNode(root.children.get(i));
		}
		return sum;
	}
	public static int noOfNodes(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int count=1;
		for(int i=0;i<root.children.size();i++) {
			count+=noOfNodes(root.children.get(i));
		}
		return count;
	}
     public static void printTree(TreeNode<Integer> root) {
    	 if(root==null) {
    		 return;
    	 }
    	 System.out.print(root.data+":");
    	 int s=root.children.size();
    	 for(int j=0;j<s;j++) {
			 System.out.print(root.children.get(j).data+" ");
		 }
		 System.out.println();
    	 for(int i=0;i<root.children.size();i++) {
    		
    		 
    		 printTree(root.children.get(i));
    	 }
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//         TreeNode<Integer> root=new TreeNode<>(1);
//         TreeNode<Integer> n1=new TreeNode<>(2);
//         TreeNode<Integer> n2=new TreeNode<>(3);
//         TreeNode<Integer> n3=new TreeNode<>(4);
//         TreeNode<Integer> n4=new TreeNode<>(5);
//         TreeNode<Integer> n5=new TreeNode<>(6);
//         TreeNode<Integer> n6=new TreeNode<>(7);
//         TreeNode<Integer> n7=new TreeNode<>(8);
//         TreeNode<Integer> n8=new TreeNode<>(9);
//         root.children.add(n1);
//         root.children.add(n2);
//         root.children.add(n3);
//         n3.children.add(n4);
//         n3.children.add(n5);
//         n3.children.add(n6);
//         n3.children.add(n7);
//         n3.children.add(n8);
//         printTree(root);
//         System.out.println("No of Nodes : "+noOfNodes(root));
//         System.out.println("sum of all Nodes : "+sumOfAllNode(root));
	//	TreeNode<Integer> root=takeInputLevelWise();
		// printTree(root);
		//printLevelWise(root);
		
		//printLevelWise2(root);
		//System.out.println(numNodeGreater(root,3));
		//System.out.println(getHeight(root));
		//System.out.println("----------------------Post order-------------------");
		//printPostOrder(root);
		//System.out.println(checkIfContainsX(root,3));
	//	ReturnRes res=maxSumNode(root);
	//	printLevelWise(root);
   //   System.out.println(res.maxnode.data);
		//System.out.println(findNextLargerNode(root,3).data);  
		//System.out.println(findSecondLargest(root).data);
		
		
		
	}

}
