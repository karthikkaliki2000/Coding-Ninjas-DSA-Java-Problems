package tries;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TrieNode1 {
	char data;
    boolean isTerminating;
    TrieNode1 children[];
    int childCount;
    boolean isPalindrome;

    public TrieNode1(char data,boolean isPalindrome) {
        this.data = data;
        isTerminating = false;
        children = new TrieNode1[26];
        childCount = 0;
        this.isPalindrome=isPalindrome;
	}
}

class TrieD {

	private TrieNode1 root;
	public int count;

	public TrieD() {
		root = new TrieNode1('\0',false);
	}

	private void add(TrieNode1 root, String word){
        if(word.length() == 0){
            root.isTerminating = true;
            return;
        }

        int childIndex = word.charAt(0) - 'a';
        TrieNode1 child = root.children[childIndex];

        if(child == null) {
            boolean isp=palindrome(word);
            child = new TrieNode1(word.charAt(0),isp);
            root.children[childIndex] = child;
            root.childCount++;
        }

        add(child, word.substring(1));
    }

	public void add(String word){
		add(root, word);
	}

	private boolean search(TrieNode1 root, String word) {
        if(word.length() == 0) {
            if(root.isTerminating){
                return true;
            }else{
                for (int i = 0; i < 26; i++) {
                    if(root.children[i]!=null){
                        if(root.children[i].isPalindrome)
                            return true;
                    }
                }
            }

            return false;
        }

        int childIndex=word.charAt(0) - 'a';
        TrieNode1 child=root.children[childIndex];

        if(child == null) {
            if(root.childCount!=0 && !root.isTerminating)
                return false;
            return palindrome(word);
        }

        return search(child,word.substring(1));

    }

	public boolean search(String word) {
		return search(root,word);
	}

	private void print(TrieNode1 root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word);
		}
		
		for (TrieNode1 child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}
	
	public void print() {
		print(this.root, "");
	}



    public boolean palindrome(String s){

        int i=0;
        int j=s.length()-1;
        while (i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

	/*..................... Palindrome Pair................... */


	public boolean isPalindromePair(ArrayList<String> words) {
		//Your code goes here
        
        for(String s:words){
            String s1="";
            for (int i = s.length()-1; i >=0 ; i--) {
                s1+=s.charAt(i);
            }
            this.add(s1);
        }

        for(String s:words){
            boolean v=this.search(s);
            if(v)
                return true;
        }
        return false;
	}



	
} 

public class PalindromePair {
	
	
	 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    public static ArrayList<String> takeInput() throws IOException {
	        ArrayList<String> words = new ArrayList<>();

	        int n = Integer.parseInt(br.readLine().trim());

	        if (n == 0) {
	            return words;
	        }
	        
	        String[] listOfWords; 
	        listOfWords = br.readLine().split("\\s");
	        

	        for (int i = 0; i < n; ++i) {
	            words.add(listOfWords[i]);
	        }

	        return words;
	    }

	    public static void main(String[] args) throws NumberFormatException, IOException {
	        TrieD root = new TrieD();

	        ArrayList<String> words = takeInput();
	        System.out.println(root.isPalindromePair(words));
	   
	    } 

}
