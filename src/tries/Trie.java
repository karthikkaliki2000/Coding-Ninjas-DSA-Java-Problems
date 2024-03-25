package tries;
public class Trie {// Implementation is Important for interviews
     private TrieNode root;
     
     public Trie() {
    	 root=new TrieNode('\0');
    	
     }
     private void addHelper(TrieNode root,String word) {
    	 if(word.length()==0) {
    		 root.isTerminal=true;
    		 return;
    	 }
    	 
    	 int childIndex=word.charAt(0)-'A';
    	 TrieNode child=root.children[childIndex];
    	 if(child==null) {
    		 child=new TrieNode(word.charAt(0));
    		 root.children[childIndex]=child;
    		 root.childCount++;
    	 }
    	 addHelper(child,word.substring(1));
     }
     public void add(String word) {
    	 addHelper(root,word);
     }
     private boolean searchHelper(TrieNode root,String word) {
    	 if(word.length()==0) {
    		 if( root.isTerminal) {
    			 return true;
    		 }
    		 return false;
    	 }
    	 int childIndex=word.charAt(0)-'A';
    	 TrieNode child=root.children[childIndex];
    	 if(child==null) {
    		 return false;
    	 }
    	 return searchHelper(child,word.substring(1));
    	 
     }
     public boolean search(String word) {
    	 return searchHelper(root,word);
     }
     public void removeHelper(TrieNode root,String word) {
    	 if(word.length()==0) {
    		 if(root.isTerminal) {
    			root.isTerminal=false;
    		 }
    		 return;
    	 }
    	 int childIndex=word.charAt(0)-'A';
    	 TrieNode child=root.children[childIndex];
    	 if(child==null) {
    		 return;
    	 }
    	 removeHelper(child,word.substring(1));
    	 if(!child.isTerminal && child.childCount==0) {//Important condition in interviews 
    		 root.children[childIndex]=null;
    		 root.childCount--;
    	 }
     }
     public void remove(String word) {
    	 removeHelper(root,word);
     }
     private int countWordsHelper(TrieNode root) {
    	 int c=0;
    	 if(root.childCount==0 && root.isTerminal!=true) {
    		 return c;
    	 }
    	
    	 if(root.isTerminal) {
    		 c++;
    	 }
    	 for(int i=0;i<26;i++) {
    		 TrieNode child=root.children[i];
    		 if(child!=null) {
    			 c+= countWordsHelper(child);
    		 }
    	 }
    	 return c;
     }
     public int countWords() {
    	 return countWordsHelper(root);
     }
    
    
}
