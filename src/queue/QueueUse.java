package queue;

public class QueueUse {

	public static void main(String[] args) throws QueueFullException, QueueEmptyException {
		// TODO Auto-generated method stub
//        QueueUsingArrays q=new QueueUsingArrays(1);
//        q.enqueue(10);
//        q.enqueue(20);
//        q.enqueue(30);
//        q.enqueue(30);
//        q.enqueue(40);
     //   System.out.println();
//		QueueUsingLL q=new QueueUsingLL();
//		q.enqueue(17);
//		q.enqueue(23);
//		q.enqueue(11);
//		q.dequeue();
//		System.out.println(q.front());
//		System.out.println(q.getSize());
//        while(!q.isEmpty()) {
//        	System.out.println(q.dequeue());
//        }
		QueueUsing2Stacks q=new QueueUsing2Stacks();
		q.push(10);
		q.push(20);
		q.push(340);
		while(!q.isEmpty()) {
        	System.out.println(q.pop());
        }
	}

}
