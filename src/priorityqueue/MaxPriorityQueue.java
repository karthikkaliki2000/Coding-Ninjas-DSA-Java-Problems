package priorityqueue;




import java.util.*;
public class MaxPriorityQueue {
	// Complete this class
	private ArrayList<Integer> heap;

	public MaxPriorityQueue() {
		heap = new ArrayList<>();
	}
	
	

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int getSize() {
		return heap.size();
	}

	int getMax()  {
		// Implement the getMax() function here
			if (isEmpty()) {
			// Throw an exception
			 return -1;
		}
		return heap.get(0);
	}

	 void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {
			if (heap.get(childIndex) >heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
	}

		int removeMax() {
	if(getSize()==0) {
    		return -1;
    	}
    	int removed=heap.get(0);
    	int ans=removed;
    	heap.set(0, heap.get(heap.size()-1));
    	heap.remove(heap.size()-1);
    	int parentIndex=0;
    	int LchildIndex=2*parentIndex+1;
    	int RchildIndex=2*parentIndex+2;
    	while(LchildIndex < heap.size()) {
	    	int maxIndex=parentIndex;
	    	if(heap.get(LchildIndex)>heap.get(maxIndex)) {
	    		maxIndex=LchildIndex;
	    	}
	    	if(RchildIndex< heap.size()  && heap.get(RchildIndex)>heap.get(maxIndex)) {
	    		maxIndex=RchildIndex;
	    	}
	    	if(parentIndex==maxIndex) {
	    		break;
	    	}
	    	int temp=heap.get(maxIndex);
	    	heap.set(maxIndex, heap.get(parentIndex));
	    	heap.set(parentIndex, temp);
	    	parentIndex=maxIndex;
	    	LchildIndex=2*parentIndex+1;
	    	RchildIndex=2*parentIndex+2;
	    	
    	}
    	return ans;
	}
}
