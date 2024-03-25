package hashmap;

public class MapUse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> m=new Map<>();
		for(int i=0;i<20;i++) {
			m.insert("abc"+i, i+1);
		}
		m.removeKey("abc5");
		m.removeKey("abc8");
		for(int i=0;i<20;i++) {
			System.out.println(m.getValue("abc"+i));
		}

	}

}
