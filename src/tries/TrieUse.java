package tries;

public class TrieUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie t=new Trie();
		t.add("THE");
		t.add("THERE");
		t.add("THEY");
		t.add("THEREBY");
		t.remove("THEY");
		System.out.println(t.countWords());
		
		

	}
	

}
