package priorityqueue;

public class PriorityQueueUse {

	public static void main(String[] args) throws PQException {
		// TODO Auto-generated method stub
            MinPriorityQueue<String> p=new MinPriorityQueue<>();
            for(int i=1;i<=10;i++) {
            	p.insert("abc"+i, i+1);
            }
            for(int i=1;i<=10;i++) {
            	System.out.println(p.getMin());
            	p.deleteMin();
            }
            p.deleteMin();
	}

}
