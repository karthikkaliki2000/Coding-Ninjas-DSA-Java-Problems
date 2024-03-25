package tries;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
public class AutoComplete {

	   static Scanner sc = new Scanner(System.in);
		public static void main(String[] args) throws IOException{	
	        Trie1 t = new Trie1();
	        int n = sc.nextInt();
	        sc.nextLine();
	        ArrayList<String> input = new ArrayList<String>();
	        String[] words = sc.nextLine().split("\\s");
	        for(int i = 0; i < n; i++) {
				input.add(words[i]);
			}
			String pattern = sc.nextLine();
			t.autoComplete(input, pattern);
		}

}

class TrieNodeS{
	char data;
	boolean isTerminating;
	TrieNodeS children[];
	int childCount;

	public TrieNodeS(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNodeS[26];
		childCount = 0;
	}
}

class Trie1 {
	private TrieNodeS root;
	
	public Trie1() {
		root = new TrieNodeS('\0');
	}

	private void add(TrieNodeS root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		
		int childIndex = word.charAt(0) - 'a';
		TrieNodeS child = root.children[childIndex];
		if(child == null){
			child = new TrieNodeS(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}
	
     public TrieNodeS findword(TrieNodeS root, String word) { 
        if(word.length() == 0){
            return root;
        }
        int childIndex = word.charAt(0) - 'a';
        TrieNodeS child = root.children[childIndex];
        if(child == null){
            return null; 
        }
        return findword(child, word.substring(1));
    } 
    
    public void allwords(TrieNodeS root,String word,String output){    
		if(root==null){
			return;
		}
        if(root.childCount == 0) { 
            if(output.length() > 0) {
                System.out.println(word + output); 
            }
            return; 
        }
        if(root.isTerminating == true) {
            System.out.println(word + output);
        }

        for(int i = 0; i < root.children.length; i++) {
            if(root.children[i] != null) {
                String ans = output + root.children[i].data; 
                allwords(root.children[i],word,ans);
            }
       }
    }
     public void autoComplete(ArrayList<String> input, String word){    
        // for(String w : input) { 
        //     add(w); 
        // }
          int i=0; 
        while(i<input.size()){
            String a=input.get(i);
            add(root,a); 
            i++;
         }  
        if(root == null || root.childCount == 0) { 
            return;
        }
       TrieNodeS a=findword(root,word);
        String output = ""; 
        allwords(a,word,output); 
    }
}
